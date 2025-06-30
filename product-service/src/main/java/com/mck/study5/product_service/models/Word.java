package com.mck.study5.product_service.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
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
