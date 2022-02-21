package com.SecondTry.ClientAccount.controller;

import com.SecondTry.ClientAccount.model.Account;
import com.SecondTry.ClientAccount.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService accountService) {
        this.service = accountService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Account>> get() {
        return ResponseEntity.ok().body(this.service.get());
    }

    @PutMapping("/transfer/{idAccount1}/{idAccount2}/{value}")
    public ResponseEntity<List<Account>> transfer(@PathVariable int idAccount1, @PathVariable int idAccount2, @PathVariable int value) {
        return ResponseEntity.ok().body(this.service.transfer(idAccount1, idAccount2, value));
    }
}
