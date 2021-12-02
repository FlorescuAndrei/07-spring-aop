package com.andrei.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.andrei.aop.dao.Account;
import com.andrei.aop.dao.AccountDAO;
import com.andrei.aop.dao.MembershipDAO;

public class AfterDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class); 
		
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = null;
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch(Exception e) {
			System.out.println("\n\nMain Program... caught exception: " +e);
		}
		System.out.println("\n\nMain Program: AfterDemoApp");
		System.out.println(accounts);
		System.out.println("\n");
	
		
		
		context.close();

	}

}
