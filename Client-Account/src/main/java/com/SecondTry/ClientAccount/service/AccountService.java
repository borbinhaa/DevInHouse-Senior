package com.SecondTry.ClientAccount.service;

import com.SecondTry.ClientAccount.model.Account;
import com.SecondTry.ClientAccount.repository.CrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class AccountService implements CrudService<Account>{

    private CrudRepository<Account> accountsRepository;

    @Override
    public List<Account> get() {
        return this.accountsRepository.getAll();
    }

    @Override
    public Account findById(int id) {
        return this.accountsRepository.findById(id);
    }

    @Override
    public Account update(int id, Account account) {
        return this.accountsRepository.update(id, account);
    }

    @Override
    public int add(Account account) {
        return this.accountsRepository.add(account);
    }

    @Override
    public Account delete(int id) {
        return this.accountsRepository.delete(id);
    }

    public List<Account> transfer(int idAccount1, int idAccount2, double value) {
        Account account1 = this.accountsRepository.findById(idAccount1);
        Account account2 = this.accountsRepository.findById(idAccount2);
        double finalBalance = account1.getBalance() - value;
        if (finalBalance >= 0) {
            account1.setBalance(finalBalance);
            account2.setBalance(account2.getBalance() + value);
            return Arrays.asList(account1, account2);
        }
        throw new IllegalArgumentException("Valor maior do que tem na sua conta.");
    }

}
