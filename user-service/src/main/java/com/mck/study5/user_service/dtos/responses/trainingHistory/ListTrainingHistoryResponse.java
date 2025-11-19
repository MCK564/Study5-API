package com.mck.study5.user_service.dtos.responses.trainingHistory;


import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ListTrainingHistoryResponse {
    private List<TrainingHistoryResponse> responses = new ArrayList<>();
}
