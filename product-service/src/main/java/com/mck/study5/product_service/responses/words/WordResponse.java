package com.mck.study5.product_service.responses.words;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.product_service.models.FlashCard;
import com.mck.study5.product_service.models.Word;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WordResponse {
    private Long id;
    private String text;
    private String phonetic;

    @JsonProperty("type_of_text")
    private String typeOfText;

    @JsonProperty("audio_link")
    private String AudioLink;

    private String definition;

    @JsonProperty("audio_id")
    private Long audioId;

    public static WordResponse fromWord(Word word){
        return WordResponse.builder()
                .id(word.getId())
                .text(word.getText())
                .phonetic(word.getPhonetic())
                .typeOfText(word.getTypeOfText())
                .AudioLink(word.getAudioLink())
                .definition(word.getDefinition())
                .audioId(word.getAudioId())
                .build();
    }
}
