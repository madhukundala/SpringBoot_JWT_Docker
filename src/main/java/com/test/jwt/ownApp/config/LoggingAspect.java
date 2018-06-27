package com.test.jwt.ownApp.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// What kind of method calls I would intercept
	// execution(* PACKAGE.*.*(..))
	// Weaving & Weaver
	@Before("execution(* com.test.madhu.ownApp.controller.*.*(..))")
	public void before(JoinPoint joinPoint) {
		// Advice
		logger.info("Controller Allowed execution for {}", joinPoint);
	}
	
	@Before("execution(* com.test.madhu.ownApp.*.*(..))")
	public void beforeJWT(JoinPoint joinPoint) {
		// Advice
		logger.info("Security Allowed execution for ####  {}", joinPoint);
	}
}