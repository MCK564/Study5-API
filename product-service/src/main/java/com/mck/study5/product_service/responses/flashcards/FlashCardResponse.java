package com.mck.study5.product_service.responses.flashcards;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.product_service.models.FlashCard;
import com.mck.study5.product_service.models.Word;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlashCardResponse {
    private Long id;
    private String title;
    private String language;
    private String description;

    @JsonProperty("number_of_word")
    private Integer numberOfWord;

    @JsonProperty("thumbnail_id")
    private Long thumbnailId;

    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;

    public static FlashCardResponse fromFlashCard(FlashCard flashCard){
        return FlashCardResponse.builder()
                .id(flashCard.getId())
                .title(flashCard.getTitle())
                .description(flashCard.getDescription())
                .numberOfWord(flashCard.getNumberOfWord())
                .thumbnailId(flashCard.getThumbnailId())
                .thumbnailUrl(flashCard.getThumbnailUrl())
                .build();
    }
}
