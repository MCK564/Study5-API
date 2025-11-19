package com.mck.study5.product_service.models;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="lessons")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Progress extends BaseEntity{
    private Long userId;
    private Boolean completed = false;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;
}
