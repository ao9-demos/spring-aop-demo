package io.ao9.springaopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.ao9.springaopdemo.entity.Account;

@Aspect
@Component
@Order(1)
public class DemoCloudLogAspect {    
    @Pointcut("execution(public void addAccount())")
    private void forAddAccount() {
    }

    @Pointcut("execution(* io.ao9.springaopdemo.dao.AccountDAO.findAccounts(..))")
    private void afterAccountDAOFindAccountsAdvice() {
    }

    @Before("forAddAccount()")
    public void beforeAddAccountAdvice() {
        System.out.println("1111 before for addAccount");
    }

    @AfterReturning(pointcut = "afterAccountDAOFindAccountsAdvice()", returning = "result")
    public void afterFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        System.out.println("1111 after find accounts");
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("1111 " + method);
        System.out.println("1111 " + result);
        System.out.println("1111 modifying result");
        if (!result.isEmpty()) {
            result.get(0).setName("Modified name");
        }
        setNamesToUpperCase(result);
        System.out.println();
    }

    private void setNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            String upperCaseName = account.getName().toUpperCase();
            account.setName(upperCaseName);
        }
    }
}