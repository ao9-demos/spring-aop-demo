package io.ao9.springaopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.ao9.springaopdemo.entity.Account;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {    
    @Pointcut("execution(* io.ao9.springaopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution(* io.ao9.springaopdemo.dao.*.set*(..))")
    private void setter() {
    }

    @Pointcut("execution(* io.ao9.springaopdemo.dao.*.get*(..))")
    private void getter() {
    }

    @Pointcut("forDaoPackage() && !(setter() || getter())")
    private void forDaoPackageNoSetterGetter() {
    }

    @Before("forDaoPackage()")
    public void beforeDaoPackage(JoinPoint theJoinPoint) {
        System.out.println("2222 before for Dao Package");
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("2222 " + methodSignature);
        Object[] args = theJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("2222 " + arg.getClass() + arg);
            if (arg instanceof Account) {
                Account theAccount = (Account) arg;
                System.out.println("2222 " + theAccount);               
            }
        }
    }

    @Before("forDaoPackageNoSetterGetter()")
    public void name() {
        System.out.println("2222 before for Dao Package no setter getter");
    }
}