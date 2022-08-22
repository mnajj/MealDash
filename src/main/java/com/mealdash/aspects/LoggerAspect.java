package com.mealdash.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggerAspect {
	private final Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.mealdash.controllers.*.*(..))")
	private void forControllersPackage() {
	}

	@Pointcut("execution(* com.mealdash.services.*.*(..))")
	private void forServicesPackage() {
	}

	@Pointcut("execution(* com.mealdash.repositories.*.*(..))")
	private void forRepositoriesPackage() {
	}

	@Pointcut("forControllersPackage() || forServicesPackage() || forRepositoriesPackage()")
	private void forAppWorkFlow() {
	}

	@Before("forAppWorkFlow()")
	public void beforeAdvice(JoinPoint joinPoint) {
		var methodName = joinPoint.getSignature().getName();
		logger.info("\u001B[36m" + "--> Before: Calling method: " + methodName + "\u001B[36m");
		var args = joinPoint.getArgs();
		for (Object arg : args) {
			logger.info("--> Argument: " + arg);
		}
	}

	@AfterReturning(pointcut = "forAppWorkFlow()", returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
		var methodName = joinPoint.getSignature().getName();
		logger.info("\u001B[36m" + "--> Before: Calling method: " + methodName + "\u001B[36m");
		logger.info("--> Result: " + result);
	}
}
