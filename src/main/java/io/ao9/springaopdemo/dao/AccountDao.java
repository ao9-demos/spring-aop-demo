package io.ao9.springaopdemo.dao;

import org.springframework.stereotype.Component;

import io.ao9.springaopdemo.entity.Account;

@Component
public class AccountDAO {
    private String serviceCode;

    public void addAccount(Account theAccount, boolean VIPflag) {
        System.out.println("----" + getClass() + "----add account\n");
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