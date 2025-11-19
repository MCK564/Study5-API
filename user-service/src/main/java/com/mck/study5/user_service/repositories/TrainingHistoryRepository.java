package com.mck.study5.user_service.repositories;

import com.mck.study5.user_service.models.TrainingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingHistoryRepository extends JpaRepository<TrainingHistory, Long> {
    List<TrainingHistory> findAllByUser_Id(Long userId);

}
