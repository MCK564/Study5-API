package com.mck.study5.product_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="flashcards")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlashCard extends BaseEntity {
    private String title;
    private String language;
    private String description;
    private Integer numberOfWord;

    @OneToMany(mappedBy = "flashCard", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Word> words = new ArrayList<>();

}
