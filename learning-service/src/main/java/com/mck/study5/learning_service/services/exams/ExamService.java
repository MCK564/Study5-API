package com.mck.study5.learning_service.services.exams;

import com.mck.study5.learning_service.converter.Converter;
import com.mck.study5.learning_service.dto.request.exam.ExamDTO;
import com.mck.study5.learning_service.dto.response.exams.ExamCategoryResponse;
import com.mck.study5.learning_service.dto.response.exams.ExamListResponse;
import com.mck.study5.learning_service.dto.response.exams.ExamResponse;
import com.mck.study5.learning_service.dto.response.exams.ListExamCategoryResponse;
import com.mck.study5.learning_service.models.Exam;
import com.mck.study5.learning_service.repository.ExamCategoryRepository;
import com.mck.study5.learning_service.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService implements IExamService{
    private final ExamRepository examRepository;
    private final ExamCategoryRepository examCategoryRepository;
    private final Converter converter;


    @Override
    public ListExamCategoryResponse getExamCategories() {
        List<ExamCategoryResponse> examCategoryResponses = examCategoryRepository.findAll()
                .stream()
                .map(ExamCategoryResponse::from)
                .toList();
        return ListExamCategoryResponse.builder()
                .quantity(examCategoryResponses.size())
                .examCategories(examCategoryResponses)
                .build();
    }

    @Override
    public ExamListResponse findByCondition(Integer page, Integer limit, Long categoryId, String keyword) {
        PageRequest request = PageRequest.of(page-1, limit);
        Page<Exam> pages = examRepository.findAll(keyword,categoryId,request);
        List<ExamResponse> responses = pages.getContent()
                .stream()
                .map(ExamResponse::from)
                .toList();

        return ExamListResponse.builder()
                .exams(responses)
                .currentPage(page)
                .totalPages(pages.getTotalPages())
                .quantity(responses.size())
                .build();
    }

    @Override
    public ExamResponse findById(Long id) {
        return ExamResponse.from(examRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Exam not found: id="+id)));
    }

    @Override
    public ExamResponse createOrUpdate(ExamDTO dto) {
        Exam exam = converter.fromExamDTO(dto);
        exam.setCategory(examCategoryRepository
                .findById(dto.getExamCategoryId())
                .orElseThrow(()->new RuntimeException("ExamCategory not found: id="+dto.getExamCategoryId())));
        return ExamResponse.from(examRepository.save(exam));
    }

    @Override
    public ExamResponse delete(Long id) {
       if(examRepository.existsById(id)){
           examRepository.deleteById(id);
           return ExamResponse.builder().id(id).build();
       }
       return null;
    }

    @Override
    public void updateThumbnail(Long id, String thumbnail, Long thumbnailId) {
        Exam existedExam = examRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Exam not found: id="+id));
        existedExam.setThumbnailId(thumbnailId);
        existedExam.setThumbnailUrl(thumbnail);
        examRepository.save(existedExam);
    }
}
