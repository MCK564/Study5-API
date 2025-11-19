package com.mck.study5.user_service.services.trainingHistory;

import com.mck.study5.user_service.dtos.requests.TrainingHistoryRequestDTO;
import com.mck.study5.user_service.dtos.responses.trainingHistory.ListTrainingHistoryResponse;
import com.mck.study5.user_service.dtos.responses.trainingHistory.TrainingHistoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ITrainingHistoryService {
    ListTrainingHistoryResponse getAllByUser_Id(Long userId);
    String deleteTrainingHistoryById(Long userId, Long trainingHistoryId);
    TrainingHistoryResponse createOrUpdateTrainingHistory(Long userId, TrainingHistoryRequestDTO dto);
}
