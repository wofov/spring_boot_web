package spring.edd.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component//빈 등록 위해
public class TimeTraceAop {

    @Around("execution(* spring.edd..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("----");
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs +"ms");
        }
    }

}
