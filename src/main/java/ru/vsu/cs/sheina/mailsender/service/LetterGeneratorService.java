package ru.vsu.cs.sheina.mailsender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sheina.mailsender.dto.MessageDataDTO;
import ru.vsu.cs.sheina.mailsender.dto.enums.TypeLetter;
import ru.vsu.cs.sheina.mailsender.util.FileReader;

@Service
@RequiredArgsConstructor
public class LetterGeneratorService {

    @Value("${spring.mail.username}")
    private String serverEmail;
    @Autowired
    private FileReader reader;

    public SimpleMailMessage createLetter(MessageDataDTO messageDataDTO) {
        TypeLetter type = TypeLetter.valueOf(messageDataDTO.getType());
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(serverEmail);
        mailMessage.setTo(messageDataDTO.getEmail());

        switch (type) {
            case ACTIVATE_ACCOUNT -> {
                mailMessage.setText(reader.readFile("activate_account.txt") + "\n" + messageDataDTO.getData());
                mailMessage.setSubject("Активация аккаунта");
            }
            case CONFIRM_EMAIL -> {
                mailMessage.setText(reader.readFile("confirm_email.txt") + "\n" + messageDataDTO.getData());
                mailMessage.setSubject("Подтверждение почты");
            }
            case CHANGE_PASSWORD -> {
                mailMessage.setText(reader.readFile("change_password.txt") + "\n" + messageDataDTO.getData());
                mailMessage.setSubject("Изменение пароля");
            }
            case FORGET_PASSWORD -> {
                mailMessage.setText(reader.readFile("forget_password.txt") + "\n" + messageDataDTO.getData());
                mailMessage.setSubject("Изменение пароля");
            }
        }

        return mailMessage;
    }
}
