package com.yan.translator.translators;

import java.util.LinkedList;

public abstract class Translator {

    private String url;
    private String key;
    private double price;

    public Translator(String url, String key, double price) {
        this.url = url;
        this.key = key;
        this.price = price;
    }

    public abstract String getWord(long languageFromId, long languageToId, String word);
    public abstract String getPhrase(long languageFromId, long languageToId, String phrase);


    private static final LinkedList<Translator> translators = new LinkedList<>();

    private static void registerTranslator(Translator translator) {
        translators.add(translator);
    }

    public static Translator getTranslator(int index) {
        return translators.get(index);
    }

    public static void registerTranslators() {
        Translator googleTranslator = new GoogleTranslator("", "", 0);
        registerTranslator(googleTranslator);
    }
}
