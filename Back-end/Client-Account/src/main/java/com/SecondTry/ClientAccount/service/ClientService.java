package com.SecondTry.ClientAccount.service;

import com.SecondTry.ClientAccount.model.Account;
import com.SecondTry.ClientAccount.model.Client;
import com.SecondTry.ClientAccount.repository.AccountRepository;
import com.SecondTry.ClientAccount.repository.CrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ClientService implements  CrudService<Client> {

    private CrudRepository<Client> clientRepository;
    private AccountRepository accountRepository;


    @Override
    public List<Client> get() {
        return this.clientRepository.getAll();
    }

    @Override
    public Client findById(int id) {
        return this.clientRepository.findById(id);
    }

    @Override
    public Client update(int id, Client client) {
        return this.clientRepository.update(id, client);
    }

    @Override
    public int add(Client client) {
        Account account = generateAccount(client);
        client.getMyAccounts().add(account);
        accountRepository.add(account);
        return this.clientRepository.add(client);
    }

    @Override
    public Client delete(int id) {
        return this.clientRepository.delete(id);
    }

    public Client addAccount(int id) {
        Client client = this.clientRepository.findById(id);
        Account account = generateAccount(client);
        client.getMyAccounts().add(account);
        accountRepository.add(account);
        return client;
    }

    public ArrayList<Account> getMyAccount(int id) {
        return this.clientRepository.findById(id).getMyAccounts();
    }

    public Account findAccountById(int idClient, int idAccount) {
        return this.clientRepository.findById(idClient).getMyAccounts().get(idAccount);
    }

    public Account deleteAccount(int idClient, int idAccount) {
        return this.clientRepository.findById(idClient).getMyAccounts().remove(idAccount);
    }

    public Account updateAccount(int idClient, int idAccount, Account account) {
        return this.clientRepository.findById(idClient).getMyAccounts().set(idAccount, account);
    }

    public Account withdraw(int idClient, int idAccount, double value) {
        Account account = this.clientRepository.findById(idClient).getMyAccounts().get(idAccount);
        double finalBalance = account.getBalance() - value;
        if (finalBalance >= 0) {
            account.setBalance(finalBalance);
            return account;
        }
        throw new IllegalArgumentException("Valor maior do que tem na sua conta.");

    }

    public Account deposit(int idClient, int idAccount, double value) {
        Account account = this.clientRepository.findById(idClient).getMyAccounts().get(idAccount);
        account.setBalance(account.getBalance() + value);
        return account;
    }

    private Account generateAccount(Client client) {
        return new Account(client.getName(), 0);
    }



}
