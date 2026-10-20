package edu.psu.se411.lab11_threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.psu.se411.lab11_threads.model.CryptoAccount;
import edu.psu.se411.lab11_threads.model.Transaction;

/**
 * Build and run using Maven goal: clean package exec:java
 */
public class App {

	static Logger logger = LoggerFactory.getLogger(App.class);

	public static Integer nbAccounts = 10;
	public static Double initialBalance = 1000.0;
	public static Integer nbTransactions = 10000;

	public static void main(String[] args) throws InterruptedException {
		logger.info("Application is starting...");
		
		// 1- Create accounts
		CryptoAccount[] accounts = new CryptoAccount[nbAccounts];
		for (Integer i = 0; i < nbAccounts; i++) {
			accounts[i] = new CryptoAccount("acc_" + i.toString(), initialBalance);
		}
		
		// TODO: 
		Thread[] threads = new Thread[nbTransactions];
		for (Integer i = 0; i < nbTransactions; i++) {
			CryptoAccount sender = accounts[(int) (Math.random() * nbAccounts)];
			CryptoAccount receiver = accounts[(int) (Math.random() * nbAccounts)];
			Double amount = Math.random() * 10 + 1;
			Transaction transaction = new Transaction("tx_" + i.toString(), sender, receiver, amount);
			threads[i] = new Thread(transaction);
			threads[i].start();
			
		}
		
		for (Integer i = 0; i < nbTransactions; i++) {
			threads[i].join();
		}
		
		
		System.out.println("Final balances: " + getTotalBalance(accounts));
		

		for (CryptoAccount account : accounts) {
			System.out.println(account.getId() + ": " + account.getBalance());

		}
		
	
		logger.info("Application is closing...");
	}
	
	public static Double getTotalBalance(CryptoAccount[] accounts) {
		Double total = 0.0;
		for (CryptoAccount account : accounts) {
			total += account.getBalance();
		}
		return total;
	}

}
