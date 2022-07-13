package com.SecondTry.ClientAccount.configuration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErroRequisicaoDto {
    private String field;
    private String error;
}
