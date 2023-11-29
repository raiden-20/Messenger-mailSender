package ru.vsu.cs.sheina.mailsender.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.vsu.cs.sheina.mailsender.dto.enums.TypeLetter;
import ru.vsu.cs.sheina.mailsender.util.FileReader;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class TextMessageConfig {

    private final FileReader fileReader;

    @Bean
    public Map<TypeLetter, String> textStorage() {
        Map<TypeLetter, String> text = new HashMap<>();

        text.put(TypeLetter.ACTIVATE_ACCOUNT, fileReader.readFile("activate_account.txt"));
        text.put(TypeLetter.CONFIRM_EMAIL, fileReader.readFile("confirm_email.txt"));
        text.put(TypeLetter.CHANGE_PASSWORD, fileReader.readFile("change_password.txt"));
        text.put(TypeLetter.FORGET_PASSWORD, fileReader.readFile("forget_password.txt"));

        return text;
    }
}
