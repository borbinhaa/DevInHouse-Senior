package com.SecondTry.ClientAccount.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Getter
@Setter
public class Client {

    @NotNull @NotBlank
    private String name;
    @CPF
    private String cpf;
    private ArrayList<Account> myAccounts;

    public Client(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
        this.myAccounts = new ArrayList<>();
    }

}
