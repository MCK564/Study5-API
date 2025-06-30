package com.mck.study5.product_service.repositories;

import com.mck.study5.product_service.models.Blog;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    @Query("Select b FROM Blog b JOIN b.keywords k WHERE k IN :keywords ")
    Page<Blog> findAllByKeywords(@Param("keywords")List<String> keywords, Pageable pageable);

    @Query("Select b FROM Blog b JOIN b.keywords k WHERE k =:keyword ")
    Page<Blog> findAllByKeyword(@Param("keywords")String keyword, Pageable pageable);
}
