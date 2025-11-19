package com.mck.study5.product_service.responses.subject;


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
public class SubjectListResponse {
    private Integer quantity;
    private List<SubjectResponse> subjects = new ArrayList<>();
}
