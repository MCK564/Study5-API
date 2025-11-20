package com.mck.study5.learning_service.dto.response.questions;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionListResponse {
    private Integer quantity;
    private List<QuestionResponse> responses =new ArrayList<>();
}
