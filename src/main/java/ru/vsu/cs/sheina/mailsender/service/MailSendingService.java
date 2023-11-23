package ru.vsu.cs.sheina.mailsender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sheina.mailsender.dto.MessageDataDTO;

@Service
@RequiredArgsConstructor
public class MailSendingService {

    private final JavaMailSender javaMailSender;
    private final LetterGeneratorService letterGenerator;


    public void send(MessageDataDTO messageDataDTO) {
        SimpleMailMessage mailMessage = letterGenerator.createLetter(messageDataDTO);
        javaMailSender.send(mailMessage);
    }
}
