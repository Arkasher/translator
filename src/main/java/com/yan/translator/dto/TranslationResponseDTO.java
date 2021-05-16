package com.yan.translator.dto;

public class TranslationResponseDTO extends ResponseDTO {

    private String translated;

    public TranslationResponseDTO(String translated) {
        this.translated = translated;
    }
}
