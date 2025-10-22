package com.mck.study5.product_service.repositories;

import com.mck.study5.product_service.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findAllBySubject_id(Long id);



}
