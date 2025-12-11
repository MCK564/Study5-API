package com.mck.study5.product_service.services.flashcards;


import com.mck.study5.product_service.converter.Converter;
import com.mck.study5.product_service.dtos.request.flashcard.FlashCardDTO;
import com.mck.study5.product_service.models.FlashCard;
import com.mck.study5.product_service.repositories.FlashCardRepository;
import com.mck.study5.product_service.responses.flashcards.FlashCardListResponse;
import com.mck.study5.product_service.responses.flashcards.FlashCardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlashCardService implements IFlashCardService{
    private final FlashCardRepository flashCardRepository;
    private final Converter converter;

    @Override
    @Cacheable(value = "redisFlashCards", key = "#keyword+'_' +#page + '_'+ #limit")
    public FlashCardListResponse findAllByKeyword(String keyword, int page, int limit) {
        PageRequest pageRequest = PageRequest.of(page-1,limit);
        Page<FlashCard> pages = flashCardRepository.findAll(keyword,pageRequest);
        List<FlashCardResponse> responses = pages.getContent()
                .stream()
                .map(FlashCardResponse::fromFlashCard)
                .toList();
        return FlashCardListResponse.builder()
                .flashCards(responses)
                .currentPage(pages.getNumber()+1)
                .totalPages(pages.getTotalPages())
                .quantity(responses.size())
                .build();
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value  = {"redisFlashCards","redisFlashCard"} , allEntries = true),
            },
            put = {
                    @CachePut(value = "redisFlashCard", key = "#dto.id", condition = "#dto.id != null")
            }
    )
    public FlashCardResponse createOrUpdate(FlashCardDTO dto) {
        FlashCard flashCard = converter.fromFlashCardDTO(dto);
        return FlashCardResponse.fromFlashCard(flashCardRepository.save(flashCard));
    }

    @Override
    @CacheEvict(value = {"redisFlashCards","redisFlashCard"}, allEntries = true)
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

    @Override
    @CacheEvict(value = {"redisFlashCards","redisFlashCard"}, allEntries = true)
    public void evictFlashCardCache(Long id) {
    }

}
