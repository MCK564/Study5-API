package com.mck.study5.product_service.services.word;

import com.mck.study5.product_service.converter.Converter;
import com.mck.study5.product_service.dtos.request.word.WordDTO;
import com.mck.study5.product_service.models.FlashCard;
import com.mck.study5.product_service.models.Word;
import com.mck.study5.product_service.repositories.FlashCardRepository;
import com.mck.study5.product_service.repositories.WordRepository;
import com.mck.study5.product_service.responses.words.ListWordResponse;
import com.mck.study5.product_service.responses.words.WordResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WordService implements IWordService{
    private final WordRepository wordRepository;
    private final FlashCardRepository flashCardRepository;
    private final Converter converter;


    @Override
    @Cacheable(value = "redisWordList", key="#keyword+'_'+#page+'_'+#limit+'_'+#flashCardId")
    public ListWordResponse findAllByConditions(int page, int limit, String keyword, Long flashCardId) {
        PageRequest pageRequest = PageRequest.of(page-1,limit);
        if(flashCardId!=null){
            Page<Word> pages = wordRepository.findAllByFlashCardAndKeyword(keyword,flashCardId,pageRequest);
            List<WordResponse> responses = pages
                    .getContent()
                    .stream()
                    .map(WordResponse::fromWord)
                    .toList();
            return ListWordResponse.builder()
                    .words(responses)
                    .currentPage(page)
                    .totalPages(pages.getTotalPages())
                    .quantity(responses.size())
                    .build();
        }
        return null;
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = {"redisWordList","redisWord"}, allEntries = true)
            },
            put = {
                    @CachePut(value = "redisWord", key = "#dto.id", condition = "#dto.id != null")
            }
    )
    public WordResponse createOrUpdateWord(WordDTO dto) {
        Word word = converter.fromWordDTO(dto);
        word.setFlashCard(flashCardRepository.findById(dto.getFlashCardId()).get());
        Word savedWord = wordRepository.save(word);
        return WordResponse.fromWord(savedWord);
    }

    @Override
    @CacheEvict(value = {"redisWordList","redisWord"}, allEntries = true)
    public WordResponse deleteWord(Long id) {
       if(wordRepository.existsById(id)){
           WordResponse response = WordResponse.fromWord(wordRepository.findById(id).get());
//           kafka publish message delete audio
           wordRepository.deleteById(id);
           return response;
       }
       return null;
    }

    @Override
    public void updateAudio(Long wordId, Long audioId, String audioUrl) {
        wordRepository.findById(wordId)
                .ifPresent(word-> {
                    word.setImageId(audioId);
                    word.setImageUrl(audioUrl);
                    wordRepository.save(word);
                });
    }

    @Override
    @CacheEvict(value = {"redisWordList","redisWord"}, allEntries = true)
    public void evictWordCache(Long id) {
        log.info("Evicted caches for WORD id={}", id);
    }


}
