package com.mck.study5.product_service.responses.courses;

import com.mck.study5.product_service.responses.subject.SubjectResponse;
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
public class CourseListResponse {
    private Integer totalPages;
    private Integer currentPage;
    private Integer pageSize;
    private List<CourseResponse> courses = new ArrayList<>();
}
