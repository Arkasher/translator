package com.yan.translator.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TranslationRequestDTO implements Serializable {

    @NotNull @NotEmpty
    private String userKey;

    @NotNull
    private long languageFromId;

    @NotNull
    private long languageToId;

    @NotNull @NotEmpty
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

    @Override
    public String toString() {
        return "{" +
                "userKey='" + userKey + '\'' +
                ", languageFromId=" + languageFromId +
                ", languageToId=" + languageToId +
                ", word='" + word + '\'' +
                '}';
    }
}
