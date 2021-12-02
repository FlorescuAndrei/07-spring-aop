package com.andrei.aop.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	
public void addAccount() {
		
		System.out.println(getClass() + " : Doing my DB work: Adding an account from addAccount() 0 param.");
	}
	
	public void addAcoount(Account account) {
		System.out.println(getClass() + " : Doing my DB work: Adding an account from addAccount(Account account) 1 param.");
	}
	
	public void addAcoount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " : Doing my DB work: ADDING AN ACCOUNT FROM addAccount(Account account, boolean bipFlag) 2param.");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork");
		return false;
	}
	
	
	//For @AfterReturning @AfterThrowing @After examples
	public List<Account> findAccounts(boolean tripWire){
		//throwing an exception for @AfterThrowing demo
		if(tripWire) {
			throw new RuntimeException("No soup for you!!!");
		}
		List<Account> accounts = new ArrayList<Account>();
		
		Account a1 = new Account("John", "Silver");
		Account a2 = new Account("Madhu", "Platinum");
		Account a3 = new Account("Luca", "Gold");
		
		accounts.add(a3);
		accounts.add(a2);
		accounts.add(a1);
		
		return accounts;
	}
	
	
	
	//for @Around example
	public String processAccount() {
		
		//simulate a delay
		try {
		TimeUnit.SECONDS.sleep(5);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Do some work with the account";
		
	}

	public String getName() {
		System.out.println(getClass() + ": in getName ");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName ");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode ");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode ");
		this.serviceCode = serviceCode;
	}
	
	
	

}
