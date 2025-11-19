package com.mck.study5.product_service.services.flashcards;


import com.mck.study5.product_service.converter.Converter;
import com.mck.study5.product_service.dtos.request.flashcard.FlashCardDTO;
import com.mck.study5.product_service.models.FlashCard;
import com.mck.study5.product_service.repositories.FlashCardRepository;
import com.mck.study5.product_service.responses.flashcards.FlashCardListResponse;
import com.mck.study5.product_service.responses.flashcards.FlashCardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlashCardService implements IFlashCardService{
    private final FlashCardRepository flashCardRepository;
    private final Converter converter;

    @Override
    public FlashCardListResponse findAllByKeyword(String keyword, int page, int limit) {
        return null;
    }

    @Override
    public FlashCardResponse createOrUpdate(FlashCardDTO dto) {
        FlashCard flashCard = converter.fromFlashCardDTO(dto);
        return FlashCardResponse.fromFlashCard(flashCardRepository.save(flashCard));
    }

    @Override
    public FlashCardResponse deleteById(Long id) {
       if(flashCardRepository.existsById(id)){
           FlashCardResponse response = FlashCardResponse.fromFlashCard(flashCardRepository.findById(id).get());
           flashCardRepository.deleteById(id);
           return response;
       }
       return null;
    }

    @Override
    public void updateThumbnail(Long flashCardId, Long thumbnailId, String thumbnailUrl) {
        FlashCard flashCard = flashCardRepository.findById(flashCardId).get();
        flashCard.setThumbnailUrl(thumbnailUrl);
        flashCard.setThumbnailUrl(thumbnailUrl);
        flashCardRepository.save(flashCard);
    }

    @Override
    public void deleteThumbnail(Long flashCardId) {
        FlashCard flashCard = flashCardRepository.findById(flashCardId).get();
        flashCard.setThumbnailUrl(null);
        flashCard.setThumbnailUrl(null);
        flashCardRepository.save(flashCard);
    }

}
