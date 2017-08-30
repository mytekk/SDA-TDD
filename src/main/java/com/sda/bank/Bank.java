package com.sda.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-08-30.
 */
public class Bank {

    private String name;

    private List<Account> accounts;

    private List<User> users;

    public Bank(String name) {
        this.name = name;

        accounts = new ArrayList<>();
        users = new ArrayList<>();
    }

    //ta metoda bedzie testowana
    public void addUser(User user) {

        this.users.add(user);
    }

    //ta metoda bedzie testowana
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public List<Account> getAccountsByUser(Integer userId) {
        return this.accounts.stream()
                .filter(e -> e.getOwnerId().equals(userId))
                .collect(Collectors.toList());
    }

    //metoda pomocnicza do pobierania jednego konta
    public Account getAccount(Integer id) {
        Account account = null;

        if (id < accounts.size() && id >= 0) {
            account = accounts.get(id);
        }
        return account;
    }

    //metoda pomocnicza do pobierania jednego konta
    public User getUser(Integer id) {
        User user = null;

        if (id < accounts.size() && id >= 0) {
            user = users.get(id);
        }
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
