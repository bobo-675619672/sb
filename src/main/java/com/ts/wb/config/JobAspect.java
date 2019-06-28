package com.ts.wb.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.ts.wb.exception.CoolException;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class JobAspect {

	
	
	@Pointcut("execution(public * com.ts.wb.job..*(..))")
    public void annotationPointCut() {
    }
	
//    @Pointcut(value = "@annotation(com.ts.wb.annotation.Check)")
//    public void annotationPointCut() {
//    }

    @Around("annotationPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("类路径:" + signature.getDeclaringTypeName());
        System.out.println("方法名:" + signature.getMethod().getName());
        if (!validate()) {
        	log.info("没有权限");
            return null;
        }
        try {
        	log.info("有权限");
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            return null;
        }
    }

    private boolean validate() {
        // TODO 实现自己的鉴权功能
        return true;
    }
}