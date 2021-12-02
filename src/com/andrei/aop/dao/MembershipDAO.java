package com.andrei.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
	}
	
	public void addSillyMember() {
		
		System.out.println(getClass() + ": Doing stuff: ADDING A SILLY MEMBERSHIP ACCOUNT");
	}
	
	public boolean addThirdMemberType() {
		System.out.println(getClass() + ": Doing STUFF: Adding another account. THIS method return boolean");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": I'm going to sleep now...");
	}
}
