package edu.miu.cs544.labs.lab3.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class AopIsAwesomeHeaderAspect {
    private final HttpServletRequest req;
    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object checkHeader(ProceedingJoinPoint joinPoint) throws Throwable {
        String header = req.getHeader("AOP-IS-AWESOME");
        if (header == null) {
            throw new AopIsAwesomeHeaderException("The AOP-IS-AWESOME header is required");
        }
        return joinPoint.proceed();
    }

}
