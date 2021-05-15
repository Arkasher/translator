package com.yan.translator.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="TranslationWords")
public class TranslationWord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id = 0;

    @NotNull
    private long wordId;

    @NotNull
    private long languageId;

    @NotNull
    private String translation;

    public TranslationWord() {
    }

    public TranslationWord(@NotNull long wordId, @NotNull long languageId, @NotNull String translation) {
        this.wordId = wordId;
        this.languageId = languageId;
        this.translation = translation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWordId() {
        return wordId;
    }

    public void setWordId(long wordId) {
        this.wordId = wordId;
    }

    public long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
