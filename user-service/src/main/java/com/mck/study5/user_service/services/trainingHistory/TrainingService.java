package com.mck.study5.user_service.services.trainingHistory;


import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.dtos.requests.TrainingHistoryRequestDTO;
import com.mck.study5.user_service.dtos.responses.trainingHistory.ListTrainingHistoryResponse;
import com.mck.study5.user_service.dtos.responses.trainingHistory.TrainingHistoryResponse;
import com.mck.study5.user_service.repositories.TrainingHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingService implements ITrainingHistoryService{
    private final TrainingHistoryRepository trainingHistoryRepository;


    @Override
    public ListTrainingHistoryResponse getAllByUser_Id(Long userId) {
        return null;
    }

    @Override
    public String deleteTrainingHistoryById(Long userId, Long trainingHistoryId) {
        if(trainingHistoryRepository.existsById(trainingHistoryId)){
            trainingHistoryRepository.deleteById(trainingHistoryId);
            return MessageKeys.DELETE_SUCCESSFULLY+"trainingHistory with id = "+ trainingHistoryId;
        }
        return MessageKeys.EMPTY_REQUEST+": no trainingHistory with id = "+trainingHistoryId;
    }

    @Override
    public TrainingHistoryResponse createOrUpdateTrainingHistory(Long userId, TrainingHistoryRequestDTO dto) {
        return null;
    }
}
