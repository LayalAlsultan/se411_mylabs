package edu.psu.se411.ch05.threads;

import edu.psu.se411.ch05.model.Account;

// A Runnable (task) for adding a halala to the account
public class AddAHalalaTask implements Runnable {
	
	private Account account;
	
	public AddAHalalaTask(Account account) {
		this.account = account;
	}
	
    public void run() {
    	account.deposit(1);
	}
}
