package com.mck.study5.product_service.repositories;

import com.mck.study5.product_service.models.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findAllBySubject_id(Long id);

    @Query("SELECT c from Course c " +
            "JOIN c.subject cs WHERE 1=1 AND " +
            "(c.name LIKE %:keyword% OR cs.name LIKE %:keyword%)")
    Page<Course> findAll(@Param("keyword")String keyword, Pageable pageable);


}
