package edu.psu.se411;

import edu.psu.se411.exceptions.InsufficientFundsException;
import edu.psu.se411.wallet.WalletAccount;

public class EX2 {
    public static void main(String[] args) {
        WalletAccount wallet = new WalletAccount("Layal", 100);
        try {
            wallet.withdraw(40);   
            wallet.withdraw(90);  
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}
