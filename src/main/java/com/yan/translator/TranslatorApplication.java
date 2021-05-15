package com.yan.translator;

import com.yan.translator.translators.Translator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TranslatorApplication {

	public static void main(String[] args) {
		Translator.registerTranslators();
		SpringApplication.run(TranslatorApplication.class, args);
	}
}
