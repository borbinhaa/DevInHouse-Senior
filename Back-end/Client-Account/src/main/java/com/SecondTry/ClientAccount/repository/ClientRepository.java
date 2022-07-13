package com.SecondTry.ClientAccount.repository;

import com.SecondTry.ClientAccount.model.Account;
import com.SecondTry.ClientAccount.model.Client;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository implements CrudRepository<Client> {

    private final List<Client> clients = new ArrayList<>();

    @Override
    public List<Client> getAll() {
        return this.clients;
    }

    @Override
    public Client findById(int id) {
        return this.clients.get(id);
    }

    @Override
    public int add(Client client) {
        this.clients.add(client);
        return this.clients.indexOf(client);
    }

    @Override
    public Client update(int id, Client client) {
        Client oldClient = this.clients.get(id);
        ArrayList<Account> accounts = oldClient.getMyAccounts();
        accounts.forEach(account -> account.setClientOwner(client.getName()));
        client.setMyAccounts(accounts);
        return this.clients.set(id, client);
    }

    @Override
    public Client delete(int id) {
        return this.clients.remove(id);
    }
}
