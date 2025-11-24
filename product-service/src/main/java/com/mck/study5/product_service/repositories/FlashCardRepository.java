package com.mck.study5.product_service.repositories;

import com.mck.study5.product_service.models.FlashCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashCardRepository extends JpaRepository<FlashCard,Long> {

    @Query("SELECT fl FROM FlashCard fl WHERE LOWER(fl.title) LIKE LOWER(CONCAT('%' ,:keyword, '%')) ")
    Page<FlashCard> findAll(@Param("keyword")String keyword, Pageable pageable);

}
