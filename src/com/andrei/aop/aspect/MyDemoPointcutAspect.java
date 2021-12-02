package com.andrei.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoPointcutAspect {
	
	//Pointcut Expressions
//	@Before("execution(public void addAccount())")		//pointcut expression
//	@Before("execution(public void com.andrei.aop.dao.AccountDAO.addAccount())")	//fully qualified name of the method, when we need only one method
//	@Before("execution(public void add*())")			//any method that start with add	
//	@Before("execution( * add*())")						// any return type
//	@Before("execution(* add*(com.andrei.aop.dao.Account))")   //method with parameter
//	@Before("execution( * add*(com.andrei.aop.dao.Account,..))")					//any number of arguments
	@Before("execution(* com.andrei.aop.dao.*.*(..))") // any method in a package
	public void beforeAddAccountAddvice() {

		System.out.println("\n=====>>> Exectuting @Befoere Advice");
	}

	// Pointcut Declaration
	@Pointcut("execution(* com.andrei.aop.dao.*.*(..))")
	private void forDaoPackage() {
		System.out.println("\n=====>>> Exectuting @Befoere Advice");
	}

	// pointcut for getter methods
	@Pointcut("execution(* com.andrei.aop.dao.*.get*(..))")
	private void getter() {

	}

	// pointcut for setter methods
	@Pointcut("execution(* com.andrei.aop.dao.*.set*(..))")
	private void setter() {

	}

	// combining pointcut declaration && || && !
	@Pointcut("forDaoPackage() && !(setter() || getter())")
	private void forDaoPackageNoGetterAndSetter() {

	}

	// @Before("forDaoPackage()")
	@Before("forDaoPackageNoGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API Analytics");
	}


}
