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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordService implements IWordService{
    private final WordRepository wordRepository;
    private final FlashCardRepository flashCardRepository;
    private final Converter converter;


    @Override
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
    public WordResponse createOrUpdateWord(WordDTO dto) {
        Word word = converter.fromWordDTO(dto);
        word.setFlashCard(flashCardRepository.findById(dto.getFlashCardId()).get());
        Word savedWord = wordRepository.save(word);
        return WordResponse.fromWord(savedWord);
    }

    @Override
    public WordResponse deleteWord(Long id) {
       if(wordRepository.existsById(id)){
           WordResponse response = WordResponse.fromWord(wordRepository.findById(id).get());
//           kafka publish message delete audio
           wordRepository.deleteById(id);
           return response;
       }
       return null;
    }
}
