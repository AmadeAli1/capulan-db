package com.suprem.capulan.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Message {
    private String field;
    private String message;
    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public Message(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
