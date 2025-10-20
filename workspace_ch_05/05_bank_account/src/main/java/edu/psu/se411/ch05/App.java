package edu.psu.se411.ch05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.psu.se411.ch05.model.Account;
import edu.psu.se411.ch05.threads.AddAHalalaTask;


public class App {
	
	static Logger logger =  LoggerFactory.getLogger(App.class);

	private static Account account = new Account();

	  public static void main(String[] args) {
	    ExecutorService executor = Executors.newCachedThreadPool();

	    // Create and launch 100 threads
	    for (int i = 0; i < 200; i++) {
	      executor.execute(new AddAHalalaTask(account));
	    }

	    executor.shutdown();

	    // Wait until all tasks are finished
	    while (!executor.isTerminated()) {
	    }

	    System.out.println("What is balance? " + account.getBalance());
	  }



	}