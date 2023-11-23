package ru.vsu.cs.mailsender.exception;

public class NonExistentLetterType extends Exception {
    public NonExistentLetterType(String message) {
        super(message);
    }
}
