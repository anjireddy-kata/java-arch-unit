package com.techmonks.archunit.utils.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Demonstrates AfterReturning advice
 * AfterReturning advice executes after successful execution of the method
 */
@Slf4j
@Aspect
@Component
public class ResultLoggerAspect {
    @AfterReturning(pointcut = "execution(* com.techmonks.archunit.service.*.*(..))", returning = "result")
    public void logAfterReturning(Object result) {
        log.info("[ResultAspect] Method returned: " + result);
    }
}
