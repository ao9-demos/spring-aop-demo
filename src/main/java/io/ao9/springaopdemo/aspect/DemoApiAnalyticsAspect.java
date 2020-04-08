package io.ao9.springaopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class DemoApiAnalyticsAspect {
    private Logger logger = Logger.getLogger(getClass().getName());
    
    @Pointcut("execution(public void io.ao9.springaopdemo.dao.AccountDAO.addAccount(io.ao9.springaopdemo.entity.Account, ..))")
    private void forAccountDAO_addAccount() {        
    }

    @Pointcut("execution(* io.ao9.springaopdemo.service.TrafficFortuneService.getFortune(..))")
    private void forTrafficFortuneServiceGetFortune() {        
    }

    @Before("forAccountDAO_addAccount()")
    public void beforeAccountDAOAddAccountAdvice() {
        logger.info("3333 before for AccountDAO.addAccount");
    }

    @AfterThrowing(pointcut = "forAccountDAO_addAccount()",
                    throwing = "theExc")
    public void afterThrowingAccountDAOAddAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        logger.info("3333 the exception is " + theExc); 
    }

    @After("forAccountDAO_addAccount()")
    public void afterAccountDAOAddAccountAdvice() {
        logger.info("3333 after for AccountDAO.addAccount\n");
        
    }

    @Around("forTrafficFortuneServiceGetFortune()")
    public Object aroundTrafficFortuneServiceGetFortuneAdvice(ProceedingJoinPoint theProceedingJoinPoint)
            throws Throwable {
        String method = theProceedingJoinPoint.getSignature().toShortString();
        logger.info("3333 around for TrafficFortuneService.getFortune " + method);

        long begin = System.currentTimeMillis();

        Object result;
        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            result = "Major accident in the excepetion";
        }

        long end = System.currentTimeMillis();
        long duration = end - begin;
        logger.info("3333 duration is " + duration/1000d + " sec"); 

        return result;
    }
}