package com.techmonks.archunit.utils.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * This demonstrates the example of Before and After Advice
 */
@Aspect
@Slf4j
@Component
public class LoggingAspect {
    /**
     * Defines the advice to run before the method execution.
     * Executes the logic prior to executing the method.
     * execution(* com.techmonks.archunit.service.UserService.*(..)): Pointcut expression that matches all methods in UserService
     */
    @Before("execution(* com.techmonks.archunit.service.UserService.*(..))")
    public void logBeforeMethodExecution() {
        log.info("Before method execution[LoggingAspect] Method is about to be executed.");
    }

    /**
     * Defines the advice to run after the method execution.
     * Executes after the method execution, regardless of its outcome.
     * execution(* com.techmonks.archunit.service.UserService.*(..)): Pointcut expression that matches all methods in UserService
     */
    @After("execution(* com.techmonks.archunit.service.UserService.*(..))")
    public void logAfterMethodExecution() {
        log.info("logAfterMethodExecution[LoggingAspect] Method execution completed.");
    }


    @AfterThrowing(pointcut = "execution(* com.techmonks.archunit.service.UserService.*(..))", throwing = "ex")
    public void logAfterThrowingException(Exception ex) {
        System.out.println("[LoggingAspect] An exception has been thrown: " + ex.getMessage());
    }
}
