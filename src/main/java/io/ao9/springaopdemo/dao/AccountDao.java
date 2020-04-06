package io.ao9.springaopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
    public void addAccount() {
        System.out.println(getClass() + " doing my DB work: adding an acount...");

    }
}