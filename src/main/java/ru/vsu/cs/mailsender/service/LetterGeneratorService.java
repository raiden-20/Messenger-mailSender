package ru.vsu.cs.mailsender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import ru.vsu.cs.mailsender.dto.MessageDataDTO;
import ru.vsu.cs.mailsender.dto.enums.TypeLetter;
import ru.vsu.cs.mailsender.util.FileReader;

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
            case ACTIVATE_ACCOUNT:
                mailMessage.setText(reader.readFile("activate_account.txt") + messageDataDTO.getData());
                mailMessage.setSubject("Активация аккаунта");
                break;
            case CONFIRM_EMAIL:
                mailMessage.setText(reader.readFile("confirm_email.txt") + messageDataDTO.getData());
                mailMessage.setSubject("Подтверждение почты");
                break;
            case CHANGE_PASSWORD:
                mailMessage.setText(reader.readFile("change_password.txt") + messageDataDTO.getData());
                mailMessage.setSubject("Изменение пароля");
                break;
            case FORGET_PASSWORD:
                mailMessage.setText(reader.readFile("forget_password.txt") + messageDataDTO.getData());
                mailMessage.setSubject("Изменение пароля");
                break;
        }

        return mailMessage;
    }
}
