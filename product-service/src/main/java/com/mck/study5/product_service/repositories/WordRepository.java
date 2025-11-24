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

    @Query("""
        SELECT w FROM Word w
        LEFT JOIN w.flashCard fl
        WHERE (:keyword IS NULL OR LOWER(w.text) LIKE LOWER(CONCAT('%', :keyword, '%')))
          AND fl.id = :flashCardId
        """)
    Page<Word> findAllByFlashCardAndKeyword(@Param("keyword") String keyword,
                                            @Param("flashCardId") Long flashCardId,
                                            Pageable pageable);
}
