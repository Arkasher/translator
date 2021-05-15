package com.yan.translator.controller;

import com.yan.translator.dto.TranslationRequestDTO;
import com.yan.translator.dto.TranslationResponseDTO;
import com.yan.translator.model.Language;
import com.yan.translator.repository.LanguageRepository;
import com.yan.translator.service.TranslationWordService;
import com.yan.translator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/translator")
public class TranslationWordController {

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    TranslationWordService translationWordService;

    @Autowired
    UserService userService;

    @Cacheable(value = "get-languages")
    @GetMapping("/languages")
    public List<Language> getLanguages() {
        return languageRepository.findAll();
    }

    @Cacheable(value = "post-translate")
    @PostMapping("/translate")
    public String translate(@RequestBody TranslationRequestDTO translationRequestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build().toString();
        }

        if(!userService.isKeyValidToRequest(translationRequestDTO.getUserKey())) {
            return ResponseEntity.status(429).build().toString();
        }

        return translationWordService.getTranslation(translationRequestDTO).toString();
    }

}
