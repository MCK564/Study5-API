package com.mck.study5.learning_service.services.questions;

import com.mck.study5.learning_service.dto.request.exam.TakeExamDTO;
import com.mck.study5.learning_service.dto.request.question.QuestionCreateOrUpdateDTO;
import com.mck.study5.learning_service.dto.response.ExamResultResponse;
import com.mck.study5.learning_service.dto.response.questions.QuestionListResponse;
import com.mck.study5.learning_service.dto.response.questions.QuestionResponse;

public interface IQuestionService {
    QuestionListResponse takeExam(Long examId, Long userId);
    ExamResultResponse completeExam(TakeExamDTO dto);
    QuestionResponse createOrUpdate(QuestionCreateOrUpdateDTO dto);
    QuestionResponse delete(Long id);
}
