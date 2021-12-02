package com.andrei.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.andrei.aop.dao.Account;
import com.andrei.aop.dao.AccountDAO;
import com.andrei.aop.dao.MembershipDAO;

public class BeforeDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class); 
		
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		
		Account account = new Account();
		account.setLevel("Platinum");
		account.setName("Darby");
		
		accountDAO.addAcoount(account, false);
		
	
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		
		
		
		context.close();

	}

}
