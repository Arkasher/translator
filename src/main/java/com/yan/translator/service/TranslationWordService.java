package com.yan.translator.service;

import com.yan.translator.dto.TranslationRequestDTO;
import com.yan.translator.dto.TranslationResponseDTO;
import com.yan.translator.model.TranslationWord;
import com.yan.translator.repository.LanguageRepository;
import com.yan.translator.repository.TranslationWordRepository;
import com.yan.translator.repository.WordRepository;
import com.yan.translator.translators.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TranslationWordService {

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    WordRepository wordRepository;

    @Autowired
    TranslationWordRepository translationWordRepository;

    @Autowired
    TranslatorsService translatorsService;

    private Optional<TranslationWord> getByLanguageIdAndTranslationContainingIgnoreCase(long languageId, String translation) {
        return translationWordRepository.findAll().stream()
                .filter((w) -> w.getLanguageId() ==
                        languageId && w.getTranslation().equalsIgnoreCase(translation)).findFirst();
    }

    public TranslationResponseDTO getTranslation(TranslationRequestDTO translationRequestDTO) {
        Optional<TranslationWord> translationWord = getByLanguageIdAndTranslationContainingIgnoreCase(translationRequestDTO.getLanguageFromId(), translationRequestDTO.getWord());
        if(translationWord.isPresent()) {
            Optional<TranslationWord> translatedWord =
                    translationWordRepository.getByLanguageIdAndWordId(translationRequestDTO.getLanguageToId(), translationWord.get().getWordId());

            if(translatedWord.isPresent()) {
                return new TranslationResponseDTO(translatedWord.get().getTranslation());
            }
        }

        return new TranslationResponseDTO(translatorsService.getTranslator().getWord(translationRequestDTO.getLanguageFromId(), translationRequestDTO.getLanguageToId(), translationRequestDTO.getWord()));
    }

}
