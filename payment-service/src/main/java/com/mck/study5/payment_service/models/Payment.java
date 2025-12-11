package com.mck.study5.payment_service.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
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
    private String email;
    private Long courseId;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    private String paymentStatus;
    private String bank;
    private Long price;
}
