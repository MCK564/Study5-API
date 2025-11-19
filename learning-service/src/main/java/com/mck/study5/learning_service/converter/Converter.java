package com.mck.study5.learning_service.converter;


import com.mck.study5.learning_service.dto.request.exam.ExamDTO;
import com.mck.study5.learning_service.models.Exam;
import com.mck.study5.learning_service.models.ExamCategory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Converter {
    private final ModelMapper modelMapper;

    public ExamCategory fromExamCategoryDTO(ExamCategory dto){
        return modelMapper.map(dto, ExamCategory.class);
    }
    public Exam fromExamDTO(ExamDTO dto){
        return modelMapper.map(dto, Exam.class);
    }
}
