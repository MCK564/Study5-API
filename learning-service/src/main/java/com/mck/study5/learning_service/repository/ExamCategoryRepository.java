package com.mck.study5.learning_service.repository;

import com.mck.study5.learning_service.models.ExamCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamCategoryRepository extends JpaRepository<ExamCategory,Long> {
}
