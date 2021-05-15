package com.yan.translator.dto;

public class TranslationResponseDTO {

    private String translated;

    public TranslationResponseDTO(String translated) {
        this.translated = translated;
    }

    @Override
    public String toString() {
        return "{" +
                "translated='" + translated + '\'' +
                '}';
    }
}
