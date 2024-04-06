package edu.miu.cs544.labs.lab3.aspect;

import edu.miu.cs544.labs.lab3.entity.ActivityLog;
import edu.miu.cs544.labs.lab3.repository.ActivityLogRepo;
import edu.miu.cs544.labs.lab3.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {
    private final ActivityLogService service;

    @SneakyThrows
    @Around("@annotation(ExecutionTime)")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        ActivityLog log = new ActivityLog();
        log.setDate(new Date());
        log.setOperation(joinPoint.getSignature().getName());
        log.setDuration(endTime - startTime);
        service.save(log);
        return result;
    }
}
