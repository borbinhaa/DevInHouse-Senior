package com.SecondTry.ClientAccount.controller;


import com.SecondTry.ClientAccount.model.Account;
import com.SecondTry.ClientAccount.model.Client;
import com.SecondTry.ClientAccount.service.ClientService;
import com.SecondTry.ClientAccount.service.CrudService;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService clientService) {
        this.service = clientService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Client>> get() {
        return ResponseEntity.ok().body(this.service.get());
    }

    @GetMapping(path = "{id}/myaccounts", produces = "application/json")
    public ResponseEntity<List<Account>> getMyAccounts(@PathVariable int id) {
        return ResponseEntity.ok().body(this.service.getMyAccount(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable int id) {
        return ResponseEntity.ok().body(this.service.findById(id));
    }

    @GetMapping("/{idClient}/account/{idAccount}")
    public ResponseEntity<Account> findAccountById(@PathVariable int idClient,@PathVariable int idAccount) {
        return ResponseEntity.ok().body(this.service.findAccountById(idClient, idAccount));
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<String> addClient(@Valid @RequestBody Client client, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/client/").buildAndExpand(client).toUri();
        return ResponseEntity.created(uri).body(this.service.add(client) + " criado.");
    }

    @PostMapping("/addAccount/{id}")
    public ResponseEntity<Client> addAccount(@PathVariable int id, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/client/").build().toUri();
        return ResponseEntity.created(uri).body(this.service.addAccount(id));
    }

    @PostMapping("/{idClient}/withdraw/{idAccount}/{value}")
    public ResponseEntity<Account> withdawAccount(@PathVariable int idClient, @PathVariable int idAccount, @PathVariable double value) {
        return ResponseEntity.ok().body(this.service.withdraw(idClient, idAccount, value));
    }

    @PostMapping("/{idClient}/deposit/{idAccount}/{value}")
    public ResponseEntity<Account> deposit(@PathVariable int idClient, @PathVariable int idAccount, @PathVariable double value) {
        return ResponseEntity.ok().body(this.service.deposit(idClient, idAccount, value));
    }

    // PRECISA MUDAR ISSO PRA CONTINUAR COM AS CONTAS
    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable int id, @RequestBody @Valid Client client, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/client/").buildAndExpand(client).toUri();
        return ResponseEntity.created(uri).body(this.service.update(id, client));
    }

    @PutMapping("/{idClient}/update/{idAccount}")
    public ResponseEntity<Account> updateAccount(@PathVariable int idClient,@PathVariable int idAccount,@RequestBody @Valid Account account, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/client/").build().toUri();
        return ResponseEntity.created(uri).body(this.service.updateAccount(idClient, idAccount, account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete(@PathVariable int id) {
        return ResponseEntity.ok().body(this.service.delete(id));
    }

    @DeleteMapping("/{idClient}/delete/{idAccount}")
    public ResponseEntity<Account> deleteAccount(@PathVariable int idClient,@PathVariable int idAccount) {
        return ResponseEntity.ok().body(this.service.deleteAccount(idClient, idAccount));
    }

}
