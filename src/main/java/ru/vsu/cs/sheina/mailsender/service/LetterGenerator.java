package ru.vsu.cs.sheina.mailsender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sheina.mailsender.dto.MessageDTO;
import ru.vsu.cs.sheina.mailsender.dto.enums.TypeLetter;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LetterGenerator {

    @Value("${spring.mail.username}")
    private String serverEmail;
    private final Map<TypeLetter, String> textStorage;

    public SimpleMailMessage createLetter(MessageDTO messageDTO) {
        TypeLetter type = TypeLetter.valueOf(messageDTO.getType());
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(serverEmail);
        mailMessage.setTo(messageDTO.getEmail());

        switch (type) {
            case ACTIVATE_ACCOUNT -> {
                mailMessage.setText(textStorage.get(TypeLetter.ACTIVATE_ACCOUNT) + "/n" + messageDTO.getData());
                mailMessage.setSubject("Активация аккаунта");
            }
            case CONFIRM_EMAIL -> {
                mailMessage.setText(textStorage.get(TypeLetter.CONFIRM_EMAIL) + "/n" + messageDTO.getData());
                mailMessage.setSubject("Подтверждение почты");
            }
            case CHANGE_PASSWORD -> {
                mailMessage.setText(textStorage.get(TypeLetter.CHANGE_PASSWORD) + "/n" + messageDTO.getData());
                mailMessage.setSubject("Изменение пароля");
            }
            case FORGET_PASSWORD -> {
                mailMessage.setText(textStorage.get(TypeLetter.FORGET_PASSWORD) + "/n" + messageDTO.getData());
                mailMessage.setSubject("Изменение пароля");
            }
        }

        return mailMessage;
    }
}
