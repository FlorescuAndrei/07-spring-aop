package com.andrei.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.andrei.aop.dao.Account;
import com.andrei.aop.dao.AccountDAO;
import com.andrei.aop.dao.MembershipDAO;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class); 
		
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		String data = accountDAO.processAccount();
		
		System.out.println("\n\nMain Program: AroundDemoApp");
		System.out.println(data + " \nFinished!");
		System.out.println("\n");
	
		
		
		context.close();

	}

}
