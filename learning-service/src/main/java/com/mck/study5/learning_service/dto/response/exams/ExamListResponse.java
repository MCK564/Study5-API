package com.mck.study5.learning_service.dto.response.exams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamListResponse {
    private Integer quantity;
    private Integer totalPages;
    private Integer currentPage;
    private List<ExamResponse> exams = new ArrayList<>();
}
