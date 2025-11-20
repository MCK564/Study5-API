package com.mck.study5.learning_service.repository;


import com.mck.study5.learning_service.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findAllByExam_Id(Long examId);
}
