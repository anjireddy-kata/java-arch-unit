package com.techmonks.archunit.utils.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Demonstrates the Around advice
 * Around advice executes before and after the method execution
 */
@Slf4j
@Aspect
@Component
public class PerformanceLoggerAspect {
    @Around("execution(* com.techmonks.archunit.service.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        log.info("Execution time: " + (endTime - startTime) + "ms");
        return result;
    }
}
