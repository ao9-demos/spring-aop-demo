package io.ao9.springaopdemo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DemoCloudLogAspect {
    @Pointcut("execution(public void addAccount())")
    private void forAddAccount() {
    }

    @Before("forAddAccount()")
    public void beforeAddAccountAdvice() {
        System.out.println("1111 before for addAccount");
    }    

    @AfterReturning("forAddAccount()")
    public void afterAddAccountAdvice() {
        System.out.println("1111 after for addAccount\n");
    }
}