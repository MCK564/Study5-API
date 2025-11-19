package com.mck.study5.product_service.repositories;

import com.mck.study5.product_service.models.Word;
import org.hibernate.annotations.ParamDef;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word,Long> {

    @Query("SELECT w FROM Word w " +
            "JOIN FlashCard fl WHERE 1=1 AND w.text LIKE %:keyword% " +
            "AND fl.id = :flash_card_id")
    Page<Word> findAll(@Param("keyword")String keyword, @Param("flash_card_id")Long flashCardId, Pageable pageable);
}
