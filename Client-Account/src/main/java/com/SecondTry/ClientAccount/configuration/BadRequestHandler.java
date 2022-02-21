package com.SecondTry.ClientAccount.configuration;

import com.SecondTry.ClientAccount.configuration.dto.ErroRequisicaoDto;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestControllerAdvice
public class BadRequestHandler {
    private final MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ErroRequisicaoDto> handleMethod(MethodArgumentNotValidException exception){
        List<ErroRequisicaoDto> dto = new ArrayList<>();
        List<FieldError> listError = exception.getBindingResult().getFieldErrors();
        System.out.println(listError);

        listError.forEach(e ->{
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroRequisicaoDto error = new ErroRequisicaoDto(e.getField(), message);
            dto.add(error);
        });

        return dto;
    }

}
