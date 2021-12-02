package com.andrei.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoOrderAspect {
	
	@Before("com.andrei.aop.aspect.AopExpessions.forDaoPackageNoGetterAndSetter()")
	public void logToCloudAsync() {
		System.out.println("\n=====>>> Logging to Cloud in async fashion");
	}


}
//For ordering aspects insert @Order(number)
//Place Advice in separate Aspect (create new class (Aspect)for every advice)
//create new class for pointcut declaration, to reuse in different Aspects

