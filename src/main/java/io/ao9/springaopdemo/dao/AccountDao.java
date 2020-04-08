package io.ao9.springaopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import io.ao9.springaopdemo.entity.Account;

@Component
public class AccountDAO {    
    private String serviceCode;

    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("as", "adf"));
        accounts.add(new Account("ba", "bwe"));
        accounts.add(new Account("cvb", "cjk"));
        System.out.println("----" + getClass() + "----find accounts\n");
        return accounts;
    }

    public void addAccount(Account theAccount, boolean VIPflag) {
        System.out.println("----" + getClass() + "----add account\n");
        if (VIPflag) {
            throw new RuntimeException("add account exception");
        }
    }

    public boolean doWork() {
        System.out.println("----" + getClass() + "----do work\n");
        return true;
    }

    public String getServiceCode() {
        System.out.println("----" + getClass() + "----get serviceCode\n");
        return this.serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("----" + getClass() + "----set serviceCode\n");
        this.serviceCode = serviceCode;
    }
}