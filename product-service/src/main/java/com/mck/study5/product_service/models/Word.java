package com.mck.study5.product_service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name="words")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Word extends BaseEntity{
    private String text;
    private String phonetic;
    private String typeOfText;
    private String audio;
    private String definition;
    private Long audioId;
    private Long imageId;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="flashcard_id")
    @JsonManagedReference
    private FlashCard flashCard;
}
