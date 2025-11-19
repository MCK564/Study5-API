package com.mck.study5.user_service.repositories;

import com.mck.study5.user_service.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    List<Schedule> findAllByUser_Id(Long userId);

}
