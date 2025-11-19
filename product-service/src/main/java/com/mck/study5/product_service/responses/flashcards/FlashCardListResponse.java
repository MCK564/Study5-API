package com.mck.study5.product_service.responses.flashcards;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class FlashCardListResponse {

    @JsonProperty("current_page")
    private Integer currentPage;

    @JsonProperty("total_pages")
    private Integer totalPages;

    private Integer quantity;

    @JsonProperty("flash_cards")
    private List<FlashCardResponse> flashCards = new ArrayList<>();
}
