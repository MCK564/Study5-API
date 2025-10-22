package com.mck.study5.payment_service.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="payments")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment extends BaseEntity{
    private Long userId;
    private Long courseId;
    private String description;
    private PaymentStatus paymentStatus;
    private String bank;
}
