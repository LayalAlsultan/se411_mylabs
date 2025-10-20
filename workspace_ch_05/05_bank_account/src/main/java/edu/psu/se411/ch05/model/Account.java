package edu.psu.se411.ch05.model;

public class Account {
	 private int balance = 0;

    public  void deposit(int amount) {
      System.out.println("Depositing...");
      
      ///////
      synchronized (this){
      
    	  int newBalance = balance + amount;
    	  balance = newBalance;
      }
      /////
    }
    
    public int getBalance() {
        return balance;
    }
}
