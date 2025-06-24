package com.mck.study5.product_service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Table(name="words")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Word extends BaseEntity{
    private String text;
    private String phonetic;
    private String typeOfText;
    private String AudioLink;
    private String definition;

    @ManyToOne
    @JoinColumn(name="flashcard_id")
    @JsonManagedReference
    private FlashCard flashCard;
}
