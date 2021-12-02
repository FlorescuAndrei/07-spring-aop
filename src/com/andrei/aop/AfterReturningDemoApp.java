package com.andrei.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.andrei.aop.dao.Account;
import com.andrei.aop.dao.AccountDAO;
import com.andrei.aop.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class); 
		
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts= accountDAO.findAccounts(false);
		
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println(accounts);
		System.out.println("\n");
	
		
		
		context.close();

	}

}
