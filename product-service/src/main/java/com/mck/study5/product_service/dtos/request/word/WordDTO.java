package com.mck.study5.product_service.dtos.request.word;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.product_service.models.FlashCard;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class WordDTO {
    private Long id;
    private String text;
    private String phonetic;

    @JsonProperty("type_of_text")
    private String typeOfText;
    private String definition;
    @JsonProperty("flash_card_id")
    private Long flashCardId;
}
