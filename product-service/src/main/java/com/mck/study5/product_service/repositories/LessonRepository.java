package com.mck.study5.product_service.repositories;

import com.mck.study5.product_service.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository  extends JpaRepository<Lesson, Long> {
    List<Lesson> findAllByCourse_Id(Long id);
}
