package com.ts.wb.util;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class RestAspect {

	private final static Logger logger = LoggerFactory.getLogger(RestAspect.class);
	
	@Pointcut("execution(public * com.ts.wb..*(..))")
    public void log() {

    }
	
	@Before("log()")
    public void before(JoinPoint joinPoint) {
		logger.info("before拦截");
		
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (null == attributes) {
			return;
		}
        HttpServletRequest request = attributes.getRequest();

        //url地址拦截
        logger.info("url={}", request.getRequestURL());

        //method拦截
        logger.info("method={}", request.getMethod());

        //ip拦截
        logger.info("ip={}", request.getRemoteAddr());

        //类方法拦截
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数拦截
        logger.info("args={}", joinPoint.getArgs());
	}
	
	@After("log()")
    public void after() {
        logger.info("after拦截");
    }

	@AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object);
    }
}
