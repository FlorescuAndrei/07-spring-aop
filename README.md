# 07-spring-aop
Spring AOP learning project.  
  
  
Pointcut Expresion, Pointcut Decalration.  

Advice Types:  
  - @Before  
      - JoinPoint. Access and display Method Signature, Method Arguments
  - @AfterReturning  
      - post process the data before returning to caller.  
      - runs in case of success, can intercept the result and modify it.
  - @ AfterThrowing  
      - @AfterTrowing runs in case of failure and can intercept the exception. 
      - the exception is still propagated to calling program. To stop exception propagation use @Around
  - @ After  
      - runs in case of success or failure. Mostly use for observing not for interfering
  - @ Around  
      - can pre process and post process data.  
      - can intercept a exception, stop exception propagation and change it.
      - ProceedingJoinPoint handle the target method.

Aspect Ordering:  
  - For ordering aspects insert @Order(number).
  - Place Advice in separate Aspect (create new class (Aspect)for every advice).
  - Create new class for pointcut declaration, to reuse in different Aspects.
 

Notes:  
 - java config, no xml.
 - LIB: spring jar files, aspectjwever

[BACK TO START PAGE](https://github.com/FlorescuAndrei/Start.git)  
