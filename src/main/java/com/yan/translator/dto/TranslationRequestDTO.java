package com.yan.translator.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TranslationRequestDTO implements Serializable {

    @NotNull
    private String userKey;

    @NotNull
    private long languageFromId;

    @NotNull
    private long languageToId;

    @NotNull
    private String word;

    public TranslationRequestDTO() {
    }

    public TranslationRequestDTO(String userKey, long languageFromId, long languageToId, String word) {
        this.userKey = userKey;
        this.languageFromId = languageFromId;
        this.languageToId = languageToId;
        this.word = word;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public long getLanguageFromId() {
        return languageFromId;
    }

    public void setLanguageFromId(long languageFromId) {
        this.languageFromId = languageFromId;
    }

    public long getLanguageToId() {
        return languageToId;
    }

    public void setLanguageToId(long languageToId) {
        this.languageToId = languageToId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }


}
