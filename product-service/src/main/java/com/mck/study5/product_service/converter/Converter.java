package com.mck.study5.product_service.converter;

import com.mck.study5.product_service.dtos.request.blog.BlogDTO;
import com.mck.study5.product_service.dtos.request.flashcard.FlashCardDTO;
import com.mck.study5.product_service.dtos.request.lesson.LessonDTO;
import com.mck.study5.product_service.dtos.request.word.WordDTO;
import com.mck.study5.product_service.models.*;
import com.mck.study5.product_service.repositories.CourseRepository;
import com.mck.study5.product_service.repositories.SubjectRepository;
import com.mck.study5.product_service.dtos.request.course.CourseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Converter {
    private final SubjectRepository subjectRepository;
    private final CourseRepository  courseRepository;
    private final ModelMapper modelMapper;

    public Course fromCourseDTO(CourseDTO dto){
        return modelMapper.map(dto, Course.class);
    }

    public Blog fromBlogDTO(BlogDTO dto){
        return modelMapper.map(dto, Blog.class);
    }

    public Lesson fromLessonDTO(LessonDTO dto){
        return modelMapper.map(dto, Lesson.class);
    }

    public FlashCard fromFlashCardDTO(FlashCardDTO dto){
        return modelMapper.map(dto, FlashCard.class);
    }

    public Word fromWordDTO(WordDTO dto){
        return modelMapper.map(dto, Word.class);
    }

    public Lesson fromLessonDTO(Long courseId, LessonDTO dto){
        return modelMapper.map(dto, Lesson.class);
    }

    public BlogCategory fromBlogCategoryDTO(BlogCategory dto){
        return modelMapper.map(dto, BlogCategory.class);
    }


}
