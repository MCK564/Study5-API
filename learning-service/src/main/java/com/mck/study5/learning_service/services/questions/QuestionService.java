package com.mck.study5.learning_service.services.questions;

import com.mck.study5.learning_service.constants.MessageKeys;
import com.mck.study5.learning_service.converter.Converter;
import com.mck.study5.learning_service.dto.request.exam.TakeExamDTO;
import com.mck.study5.learning_service.dto.request.question.QuestionCompleteExamDTO;
import com.mck.study5.learning_service.dto.request.question.QuestionCreateOrUpdateDTO;
import com.mck.study5.learning_service.dto.response.ExamResultResponse;
import com.mck.study5.learning_service.dto.response.exams.ExamAttemptResponse;
import com.mck.study5.learning_service.dto.response.questions.QuestionAnswerListResponse;
import com.mck.study5.learning_service.dto.response.questions.QuestionAnswerResponse;
import com.mck.study5.learning_service.dto.response.questions.QuestionListResponse;
import com.mck.study5.learning_service.dto.response.questions.QuestionResponse;
import com.mck.study5.learning_service.exceptions.DataNotFoundException;
import com.mck.study5.learning_service.models.ExamAttempt;
import com.mck.study5.learning_service.models.ExamResult;
import com.mck.study5.learning_service.enums.ExamStatus;
import com.mck.study5.learning_service.models.Question;
import com.mck.study5.learning_service.repository.ExamAttemptRepository;
import com.mck.study5.learning_service.repository.ExamRepository;
import com.mck.study5.learning_service.repository.ExamResultRepository;
import com.mck.study5.learning_service.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService implements  IQuestionService{
    private final QuestionRepository questionRepository;
    private final ExamAttemptRepository   examAttemptRepository;
    private final ExamResultRepository examResultRepository;
    private final ExamRepository examRepository;
    private final Converter converter;

    @Override
    public QuestionListResponse takeExam(Long examId, Long userId) {
        ExamAttempt attempt = ExamAttempt.builder()
                .userId(userId)
                .exam(examRepository.findById(examId)
                        .orElseThrow(()->new RuntimeException("Exam not found: examId="+examId)))
                .startAt(LocalDateTime.now())
                .status(ExamStatus.PENDING.getStatus())
                .build();
        examAttemptRepository.save(attempt);

        List<QuestionResponse> questionResponses = questionRepository
                .findAllByExam_Id(examId)
                .stream()
                .map(QuestionResponse::from)
                .toList();

        return QuestionListResponse.builder()
                .quantity(questionResponses.size())
                .responses(questionResponses)
                .build();

    }

    @Override
    public ExamResultResponse completeExam(TakeExamDTO dto) {

        ExamAttempt attempt  = examAttemptRepository.findById(dto.getExamAttemptId())
                .orElseThrow(()->
                        new DataNotFoundException(MessageKeys.DATA_NOT_FOUND+": ExamAtt not found with id = "+dto.getExamAttemptId()));

        if (!ExamStatus.PENDING.getStatus().equals(attempt .getStatus())) {
            throw new IllegalStateException("ExamAttempt is not in PENDING state");
        }

        attempt .setEndAt(LocalDateTime.now());
        attempt .setCompleted(true);
        attempt.setStatus(ExamStatus.COMPLETED.getStatus());


        List<Long> questionIds = dto.getQuestions()
                .stream()
                .map(QuestionCompleteExamDTO::getQuestionId)
                .toList();

        Map<Long, Question> questionMap = questionRepository
                .findAllById(questionIds)
                .stream()
                .collect(Collectors.toMap(Question::getId, Function.identity()));


        int totalCorrects = 0;
        List<QuestionAnswerResponse> qaResponses = new ArrayList<>();
        List<ExamResult> examResults = new ArrayList<>();


        for(QuestionCompleteExamDTO q : dto.getQuestions()){
            Question question = questionMap.get(q.getQuestionId());
            if (question == null) {
                throw new DataNotFoundException(
                        MessageKeys.DATA_NOT_FOUND + ": Question not found with id = " + q.getQuestionId()
                );
            }

            boolean isCorrect = q.getAnswer().equals(question.getCorrectAnswer());
            if(isCorrect) totalCorrects++;
            qaResponses.add(QuestionAnswerResponse.from(question, q.getAnswer()));

            examResults.add(ExamResult.builder()
                    .examAttempt(attempt)
                    .chosenAnswer(q.getAnswer())
                    .question(question)
                    .build());

        }
        int numberOfQuestion = attempt.getExam().getNumberOfQuestion();
        double score = (numberOfQuestion > 0) ? (double) totalCorrects / numberOfQuestion : 0.0;


        attempt.setScore(score);
        attempt.setTotalCorrect(totalCorrects);

        int numberOfCompletions = attempt.getExam().getNumberOfCompletion();
        attempt.getExam().setNumberOfCompletion(numberOfCompletions + 1);
        examRepository.save(attempt.getExam());
        examAttemptRepository.save(attempt);
        examResultRepository.saveAll(examResults);

        QuestionAnswerListResponse qaListResponse = QuestionAnswerListResponse.builder()
                .responses(qaResponses)
                .quantity(qaResponses.size())
                .build();

        return ExamResultResponse.builder()
                .examAttemptResponse(ExamAttemptResponse.from(attempt))
                .questionAnswerListResponse(qaListResponse)
                .build();
    }

    @Override
    public QuestionResponse createOrUpdate(QuestionCreateOrUpdateDTO dto) {
        Question question  = converter.fromQuestionDTO(dto);
        question.setExam(examRepository.findById(dto.getExamId())
                .orElseThrow(()->
                        new DataNotFoundException(MessageKeys.DATA_NOT_FOUND+": Exam not found with id = "+dto.getExamId())));

        return QuestionResponse.from(questionRepository.save(question));
    }

    @Override
    public QuestionResponse delete(Long id) {
        if(questionRepository.existsById(id)){
            questionRepository.deleteById(id);
            return QuestionResponse.builder().id(id).build();
        }
        throw new RuntimeException("Question not found: id="+id);
    }
}
