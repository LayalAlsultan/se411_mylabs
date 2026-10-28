package edu.psu.se411.lab12_threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import edu.psu.se411.lab12_threads.model.CryptoAccount;
import edu.psu.se411.lab12_threads.model.Transaction;

public class AppForkJoin {
	
    static final int THRESHOLD = 1000;

    static class Batch extends RecursiveAction {
    	
        CryptoAccount[] accounts; 
       
        int from, to;
        
        Batch(CryptoAccount[] a, int from, int to) {
        	this.accounts = a; 
        	this.from = from; 
        	this.to = to; 
        }

        @Override
        protected void compute() {
            if(to - from <= THRESHOLD) {
                for(int i = from; i < to; i++) {
                    int s = (int)(Math.random() * accounts.length);
                    int r = (int)(Math.random() * accounts.length);
                    if(s == r) r = (r + 1) % accounts.length;
                    new Transaction("id_", accounts[s], accounts[r], Math.random() * 100).run();
                }
            } else {
                int mid = (from + to) / 2;
                invokeAll(new Batch(accounts, from, mid), new Batch(accounts, mid, to));
            }
        }
    }

    public static void main(String[] args) {
    	int nbAccounts = args.length >= 2 ? Integer.parseInt(args[0]) : 1000;
    	int nbTransactions = args.length >= 2 ? Integer.parseInt(args[1]) : 1000000;        CryptoAccount[] accounts = new CryptoAccount[nbAccounts];
        for(int i = 0; i < nbAccounts; i++) accounts[i] = new CryptoAccount("acc_" + i, 10000.0);

        long start = System.currentTimeMillis();
        new ForkJoinPool().invoke(new Batch(accounts, 0, nbTransactions));
        long end = System.currentTimeMillis();

        double total = 0;
        for(CryptoAccount c : accounts) total += c.getBalance();
        System.out.println("Final money: " + total);
        System.out.println("Fork/join time: " + (end - start) + " ms");
    }
}