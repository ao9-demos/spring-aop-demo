package io.ao9.springaopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {    
    public void addAccount() {
        System.out.println("----" + getClass() + "----add account\n");
    }

    public boolean addAMember() {
        System.out.println("----" + getClass() + "----add member\n");
        return true;
    }

    public int goToSleep() {
        System.out.println("----" + getClass() + "----going to sleep\n");
        return 8;
    }
}