package com.mck.study5.product_service.repositories;

import com.mck.study5.product_service.models.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    @Query("Select b FROM Blog b JOIN b.keywords k WHERE k IN :keywords ")
    Page<Blog> findAllByKeywords(@Param("keyword")List<String> keywords, Pageable pageable);

    @Query("Select b FROM Blog b JOIN b.keywords k WHERE k =:keyword ")
    Page<Blog> findAllByKeyword(@Param("keyword")String keyword, Pageable pageable);

    @Query("""
        SELECT b FROM Blog b
        WHERE 
            (:keyword IS NULL OR :keyword = '' 
             OR LOWER(b.title)    LIKE LOWER(CONCAT('%', :keyword, '%'))
             OR LOWER(b.subtitle) LIKE LOWER(CONCAT('%', :keyword, '%'))
             OR LOWER(b.keywords)  LIKE LOWER(CONCAT('%', :keyword, '%'))
            )
        """)
    Page<Blog> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
