package com.andrei.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointcutDeclarations {
	

	@Pointcut("execution(* com.andrei.aop.dao.*.*(..))")
	public void forDaoPackage() {
		System.out.println("\n=====>>> Exectuting @Befoere Advice");
	}

	
	@Pointcut("execution(* com.andrei.aop.dao.*.get*(..))")
	public void getter() {
	}

	
	@Pointcut("execution(* com.andrei.aop.dao.*.set*(..))")
	public void setter() {
	}

	
	@Pointcut("forDaoPackage() && !(setter() || getter())")
	public void forDaoPackageNoGetterAndSetter() {
	}

}
