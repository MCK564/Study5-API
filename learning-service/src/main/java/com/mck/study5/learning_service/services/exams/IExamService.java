package com.mck.study5.learning_service.services.exams;

import com.mck.study5.learning_service.dto.request.exam.ExamCategoryDTO;
import com.mck.study5.learning_service.dto.request.exam.ExamDTO;
import com.mck.study5.learning_service.dto.response.exams.ExamCategoryResponse;
import com.mck.study5.learning_service.dto.response.exams.ExamListResponse;
import com.mck.study5.learning_service.dto.response.exams.ExamResponse;
import com.mck.study5.learning_service.dto.response.exams.ListExamCategoryResponse;
import org.springframework.stereotype.Service;


public interface IExamService {
     ListExamCategoryResponse getExamCategories();
     ExamListResponse findByCondition(Integer page, Integer limit, Long categoryId, String keyword);
     ExamResponse  findById(Long id);
     ExamResponse createOrUpdate(ExamDTO dto);
     ExamResponse delete(Long id);
     void updateThumbnail(Long id, String thumbnail, Long thumbnailId);
     ExamCategoryResponse createOrUpdateExamCategory(ExamCategoryDTO dto);
     ExamCategoryResponse deleteById(Long id);
}
