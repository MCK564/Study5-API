package com.mck.study5.user_service.repositories;

import com.mck.study5.user_service.models.TrainingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingHistoryRepository extends JpaRepository<TrainingHistory, Long> {
}
