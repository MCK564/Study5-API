package com.mck.study5.payment_service.repositories;

import com.mck.study5.payment_service.models.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findAllByUserId(Long userId);


    @Query("""
           SELECT p FROM Payment p
           WHERE (:userId IS NULL OR p.userId = :userId)
             AND (:courseId IS NULL OR p.courseId = :courseId)
           """)
    Page<Payment> adminSearchPayments(@Param("userId") Long userId,
                                      @Param("courseId") Long courseId,
                                      Pageable pageable);
}