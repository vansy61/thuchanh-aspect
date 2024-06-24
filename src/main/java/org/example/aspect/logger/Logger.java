package org.example.aspect.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {

    @AfterThrowing(pointcut = "execution(public * org.example.aspect.service.CustomerService.findAll(..))", throwing = "e")
    public void logMethod(Exception e) {
        System.out.println("Có lối xảy ra: " + e.getMessage());
    }

    @AfterThrowing(pointcut = "execution(public * org.example.aspect.service.CustomerService.*(..))", throwing = "e")
    public void logClass(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("Có lối xảy ra: %s.%s%s: %s%n", className, method, args, e.getMessage());
    }
}
