package com.suprem.capulan.exception;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class Message {
    private String field;
    private String message;
    private final HttpStatus status = HttpStatus.BAD_REQUEST;
}
