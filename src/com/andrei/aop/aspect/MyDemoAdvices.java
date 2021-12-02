package com.andrei.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.andrei.aop.dao.Account;

@Aspect
@Component
@Order
public class MyDemoAdvices {

	@Before("execution(* com.andrei.aop.dao.*.*(..))") 
	public void beforeAddAccountAddvice(JoinPoint joinPoint) {

		System.out.println("\n=====>>> Exectuting @Befoere Advice");
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		//display method arguments
		Object[] args = joinPoint.getArgs();
		
		for(Object arg : args) {
			System.out.println(arg);
			
			if(arg instanceof Account) {
				
				Account account = (Account)arg;
				
				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());
			}
		}
		
	}
	
	
	@AfterReturning(pointcut="execution(* com.andrei.aop.dao.AccountDAO.findAccounts(..))",
					returning="myResult")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> myResult) {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=======>>>>Executing @AfterReturning on method: " + method);
		
		System.out.println("\n=======>>>>result is: " + myResult);
		
		//post process the data before returning to caller
		//convert the account name to uppercase
		
		convertAccountNameToUpperCase(myResult);
		
		System.out.println("\n=======>>>>result after preprocessing is: " + myResult);
		
		//@AfterReturning runs in case of success and can intercept the result and modify it
		//Attention the team must be notify about aspects !!!
			
	}

	private void convertAccountNameToUpperCase(List<Account> myResult) {
		
		for(Account account : myResult) {
			String  theUpperName = account.getName().toUpperCase();
			account.setName(theUpperName);
		}
		
	}
	
	@AfterThrowing(pointcut="execution(* com.andrei.aop.dao.AccountDAO.findAccounts(..))",
					throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=======>>>>Executing @AfterThrowing on method: " + method);
		
		System.out.println("\n=======>>>>The excetpion is: " + theExc);
		
		//@AfterTrowing runs in case of failure and can intercept the exception. 
		//The exception is still propagated to calling program. To stop exception propagation use @Around
	}
	
	
	@After("execution(* com.andrei.aop.dao.AccountDAO.findAccounts(..))")
	public void	afterFindAccountAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=======>>>>Executing @After on method: " + method);
		
		//@After runs in case of success or failure. Mostly use for observing not for interfering  
	}
	
	
	@Around("execution(* com.andrei.aop.dao.AccountDAO.processAccount())")
	public Object aroundProcessAccountAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>>>Executing @Around on method: " + method);
		
		long begin=System.currentTimeMillis();
		
		Object result =  proceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		System.out.println("\n===>>> Duration: " + duration/1000.0 + " seconds");
		
		
		return result;
		
		//@Around can pre process and post process data.
		//ProceedingJoinPoint handle the target method,     .proceed execute the target method
		//@Around can intercept a exception, stop exception propagation and change it. (example in the course)
 
	}
	
	


}	