package psu.edu.se411.ch04.accountsPayable.model;

public interface Payable {

	public int x = 0; // Will be a final static field because this is an interface
	public Double getPaymentAmount();
	
}
