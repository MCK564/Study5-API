package com.mck.study5.product_service.services.flashcards;


import com.mck.study5.product_service.dtos.request.flashcard.FlashCardDTO;
import com.mck.study5.product_service.responses.flashcards.FlashCardListResponse;
import com.mck.study5.product_service.responses.flashcards.FlashCardResponse;

public interface IFlashCardService {
    FlashCardListResponse findAllByKeyword(String keyword, int page, int limit);
    FlashCardResponse createOrUpdate(FlashCardDTO dto);
    FlashCardResponse deleteById(Long id);
    void updateThumbnail(Long flashCardId, Long thumbnailId, String thumbnailUrl);
    void deleteThumbnail(Long flashCardId);
}
