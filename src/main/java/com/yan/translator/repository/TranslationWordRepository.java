package com.yan.translator.repository;

import com.yan.translator.model.TranslationWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TranslationWordRepository extends JpaRepository<TranslationWord, Long> {

    Optional<TranslationWord> getByLanguageIdAndWordId(long languageId, long wordId);

}
