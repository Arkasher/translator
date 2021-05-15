package com.yan.translator.translators;

public class GoogleTranslator extends Translator {
    public GoogleTranslator(String url, String key, double price) {
        super(url, key, price);
    }

    @Override
    public String getWord(long languageFromId, long languageToId, String word) {
        return null;
    }

    @Override
    public String getPhrase(long languageFromId, long languageToId, String phrase) {
        return null;
    }
}
