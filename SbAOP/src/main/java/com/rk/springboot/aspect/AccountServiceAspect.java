package com.rk.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountServiceAspect {

	//log all the available methods i.e. the advice will be called for all the methods
	@Pointcut(value = "execution(* com.rk.springboot.service.AccountService.*(..))")
	private void log()
	{
		//This is called for all the method in AccountService class
	}

	@Around(value = "log()")
	public void adviceAround(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println("AroundBefore---"+jp.getKind()+"---"+jp.getSignature().getName()+" method");
		try {
			jp.proceed();
		}finally {
			//
		}
		System.out.println("AroundAfter---"+jp.getKind()+"---"+jp.getSignature().getName()+" method");
	}
}
