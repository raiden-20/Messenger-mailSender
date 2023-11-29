package ru.vsu.cs.sheina.mailsender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sheina.mailsender.dto.MessageDTO;

@Service
@RequiredArgsConstructor
public class MailSendingService {

    private final JavaMailSender javaMailSender;
    private final LetterGenerator letterGenerator;


    public void send(MessageDTO messageDTO) {
        SimpleMailMessage mailMessage = letterGenerator.createLetter(messageDTO);
        javaMailSender.send(mailMessage);
    }
}
