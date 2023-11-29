package ru.vsu.cs.sheina.mailsender.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {

    private String data;
    private String email;
    private String type;
}
