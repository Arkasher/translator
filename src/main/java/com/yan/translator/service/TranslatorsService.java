package com.yan.translator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yan.translator.translators.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TranslatorsService {

    private String ACTUAL_TRANSLATOR_INDEX = "ACTUAL_TRANSLATOR_INDEX";

    @Autowired
    RedisTemplate redisTemplate;

    private Translator getNextTranslatorAPI() {
        Integer actualTranslator = (Integer) redisTemplate.opsForHash().get(ACTUAL_TRANSLATOR_INDEX, 0);
        if(actualTranslator == null) {
            actualTranslator = 0;
        }
        Integer ruleHash = new ObjectMapper().convertValue(actualTranslator, Integer.class);
        redisTemplate.opsForHash().put(ACTUAL_TRANSLATOR_INDEX, actualTranslator, ruleHash);
        return Translator.getTranslator(actualTranslator + 1);
    }

    public Translator getTranslator() {
        return getNextTranslatorAPI();
    }

}
