package com.mck.study5.product_service.responses.lessons;

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
public class ListLessonResponse {
    private Integer quantity;
    private List<LessonResponse> responses = new ArrayList<>();
}
