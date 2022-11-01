package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
    @Around("execution(* com.example..*(..))") //공통 관심사항을 타겟팅할수있다.
    public Object execute(ProceedingJoinPoint joinPoint)throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START "+ joinPoint.toString());
        try {
            //joinpoint.proceed() : 다음메소드로 진행
            return joinPoint.proceed();

        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish-start;
            System.out.println("End : " + joinPoint.toString() + "" + timeMs+"ms");
        }


    }
}
