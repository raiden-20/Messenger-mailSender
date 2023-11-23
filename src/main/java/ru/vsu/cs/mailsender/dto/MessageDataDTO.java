package ru.vsu.cs.mailsender.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDataDTO {

    private String data;
    private String email;
    private String type;
}
