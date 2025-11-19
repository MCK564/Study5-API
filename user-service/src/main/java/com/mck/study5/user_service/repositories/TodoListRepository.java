package com.mck.study5.user_service.repositories;


import com.mck.study5.user_service.models.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList,Long> {
    List<TodoList> findAllBySchedule_Id(Long scheduleId);
}
