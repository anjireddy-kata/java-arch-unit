package com.techmonks.archunit.utils.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class PerformanceAspect {

    @Around("@annotation(com.techmonks.archunit.utils.annotation)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.info("[PerformanceAspect] Exception in method: " + throwable.getMessage());
            throw throwable;
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("[PerformanceAspect]: " + joinPoint.getSignature() + " executed in " + (endTime - startTime) + "ms");
        }
        return result;
    }
}
