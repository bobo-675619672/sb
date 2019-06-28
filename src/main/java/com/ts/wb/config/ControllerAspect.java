package com.ts.wb.config;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * 针对所有Controller类的切片
 */
@Slf4j
@Aspect
@Component
@Order(1)
public class ControllerAspect {

	@Pointcut("execution(public * com.ts.wb.rest..*(..))")
    //@Pointcut("within(com.gaofenshuo.controller.*)")
    public void controllerExecution() {
		
    }
	
	@Before("controllerExecution()")
    public void doBeforeControllerExecution(JoinPoint joinPoint) throws Exception {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		
		Signature signature = joinPoint.getSignature();
        HttpServletRequest req = attributes.getRequest();
        
        log.info("Rest切面!method:{}, url:{}", signature.getName(), req.getRequestURL().toString());
        
        if (req.getRequestURL().toString().indexOf("error") >= 0) {
        	throw new Exception("错误啦!!!");
        }
        
	}
	
}
