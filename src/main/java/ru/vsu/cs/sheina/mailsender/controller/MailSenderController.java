package ru.vsu.cs.sheina.mailsender.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sheina.mailsender.dto.MessageDataDTO;
import ru.vsu.cs.sheina.mailsender.service.MailSendingService;

@RestController
@RequiredArgsConstructor
public class MailSenderController {

    private final MailSendingService mailSendingService;

    @PostMapping("/mail-sender/send/letter")
    public ResponseEntity<?> sendLetter(@RequestBody MessageDataDTO messageDataDTO){
        mailSendingService.send(messageDataDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<?> handleException(IllegalArgumentException e) {
        return new ResponseEntity<>("Non-existent letter type", HttpStatus.NOT_FOUND);
    }
}