package com.SecondTry.ClientAccount.repository;

import com.SecondTry.ClientAccount.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository implements CrudRepository<Account> {

    private final List<Account> accounts = new ArrayList<>();

    @Override
    public List<Account> getAll() {
        return this.accounts;
    }

    @Override
    public Account findById(int id) {
        return this.accounts.get(id);
    }

    @Override
    public int add(Account account) {
        this.accounts.add(account);
        return this.accounts.indexOf(account);
    }

    @Override
    public Account update(int id, Account account) {
        return this.accounts.set(id, account);
    }

    @Override
    public Account delete(int id) {
        return this.accounts.remove(id);
    }
}
