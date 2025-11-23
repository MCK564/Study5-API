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

    @Query("""
       SELECT c FROM Course c
       LEFT JOIN c.subject cs
       WHERE (:keyword IS NULL OR :keyword = ''\s
              OR LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
              OR LOWER(cs.name) LIKE LOWER(CONCAT('%', :keyword, '%')))
      \s""")
    Page<Course> findAll(@Param("keyword")String keyword, Pageable pageable);


}
