package com.mck.study5.product_service.services.word;

import com.mck.study5.product_service.dtos.request.word.WordDTO;
import com.mck.study5.product_service.responses.words.ListWordResponse;
import com.mck.study5.product_service.responses.words.WordResponse;

public interface IWordService {
      ListWordResponse findAllByConditions(int page, int limit, String keyword, Long flashCardId);
      WordResponse createOrUpdateWord(WordDTO dto);
      WordResponse deleteWord(Long id);
}
