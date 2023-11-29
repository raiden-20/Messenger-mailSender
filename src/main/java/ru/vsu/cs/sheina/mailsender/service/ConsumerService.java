package ru.vsu.cs.sheina.mailsender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.vsu.cs.sheina.mailsender.configuration.RabbitQueues;
import ru.vsu.cs.sheina.mailsender.dto.MessageDTO;

@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final MailSendingService mailSendingService;

    @RabbitListener(queues = RabbitQueues.mainQueue)
    public void sendLetter(@RequestBody MessageDTO messageDTO){
        mailSendingService.send(messageDTO);
    }

}
