package com.sda.bank;

import java.util.ArrayList;
import java.util.List;

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
