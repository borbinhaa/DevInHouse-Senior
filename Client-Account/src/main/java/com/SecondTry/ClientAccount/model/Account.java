package com.SecondTry.ClientAccount.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class Account {


    @NotBlank @NotNull
    private String clientOwner;
    @Min(0)
    private double balance;

}
