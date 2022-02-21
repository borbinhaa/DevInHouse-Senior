package com.SecondTry.ClientAccount.configuration;


import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@AllArgsConstructor
@RestControllerAdvice
public class InternalServerErrorHandler {
    private final MessageSource messageSource;

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String illegarArgumentMethod(IllegalArgumentException exception) {
        return "Erro: " + exception.getMessage();
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String indexMethod(IndexOutOfBoundsException exception) {
        return "Erro: " + exception.getLocalizedMessage();

    }
}
