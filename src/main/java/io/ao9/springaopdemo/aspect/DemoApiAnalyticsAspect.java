package io.ao9.springaopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class DemoApiAnalyticsAspect {
    @Pointcut("execution(public void io.ao9.springaopdemo.dao.AccountDAO.addAccount(io.ao9.springaopdemo.entity.Account, ..))")
    private void forAccountDAO_addAccount() {        
    }

    @Before("forAccountDAO_addAccount()")
    public void beforeAccountDAOAddAccountAdvice() {
        System.out.println("3333 before for AccountDAO.addAccount");
    }
}