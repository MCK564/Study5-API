package com.mck.study5.learning_service.repository;


import com.mck.study5.learning_service.models.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    @Query("""
        SELECT e FROM Exam e
        JOIN e.category c
        WHERE c.id = :categoryId
          AND (
                LOWER(e.title) LIKE LOWER(CONCAT('%', :keyword, '%'))
             OR LOWER(e.type) = LOWER(:keyword)
             OR LOWER(c.content) LIKE LOWER(CONCAT('%', :keyword, '%'))
          )
       """)
    Page<Exam> findAll(@Param("keyword") String keyword,
                       @Param("categoryId") Long categoryId,
                       Pageable pageable);
}
