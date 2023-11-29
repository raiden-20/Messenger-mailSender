package ru.vsu.cs.sheina.mailsender.dto.enums;

public enum TypeLetter {
    ACTIVATE_ACCOUNT("ACTIVATE_ACCOUNT"),
    CONFIRM_EMAIL("CONFIRM_EMAIL"),
    CHANGE_PASSWORD("CHANGE_PASSWORD"),
    FORGET_PASSWORD("FORGET_PASSWORD");

    private final String type;

    TypeLetter(String type) {
        this.type = type;
    }
}
