package com.mck.study5.learning_service.converter;


import com.mck.study5.learning_service.dto.request.exam.ExamCategoryDTO;
import com.mck.study5.learning_service.dto.request.exam.ExamDTO;
import com.mck.study5.learning_service.dto.request.question.QuestionCreateOrUpdateDTO;
import com.mck.study5.learning_service.models.Exam;
import com.mck.study5.learning_service.models.ExamCategory;
import com.mck.study5.learning_service.models.Question;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Converter {
    private final ModelMapper modelMapper;

    public ExamCategory fromExamCategoryDTO(ExamCategoryDTO dto){
        return modelMapper.map(dto, ExamCategory.class);
    }
    public Exam fromExamDTO(ExamDTO dto){
        return modelMapper.map(dto, Exam.class);
    }
    public Question fromQuestionDTO(QuestionCreateOrUpdateDTO dto){return modelMapper.map(dto, Question.class);}

}
