package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {

	private static int accountant = 1;

	private int numberAccount;
	private People people;
	private Double balance = 0.0;
	
	 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
	 Date current = new Date();

	public Account(People people) {
		this.numberAccount = accountant;
		this.people = people;
		
		accountant += 1;
	}

	public int getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(int numberAccount) {
		this.numberAccount = numberAccount;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void balance() {		
		
		getBalance();
	}

	public void deposit(double value) {
		if (value > 0) {
			setBalance(getBalance() + value);
			System.out.println("Deposit Made Successfully" + " | " + sdf.format(current));
		} 
		else {
			System.out.println("Value not Allowed!");
		}

	}

	public void toWithdrawa(double value) {
		if (value > 0 && getBalance() >= value) {
		//	value -= getBalance() + 5.0;
			setBalance(getBalance() - value );
			System.out.println("Withdrawal Successful" + " | " + sdf.format(current));
		}
		else{
			System.out.println("Insufficient Funds");
		}
	}
	
	public void transfer(Account accountForDeposit, Double value) {
		if (value > 0 && getBalance() >= value) {
			setBalance(getBalance() - value); 
			accountForDeposit.balance = accountForDeposit.getBalance() + value;
			System.out.println("Successful transfers" + " | " + sdf.format(current));
		}
		else {
			System.out.println("Insufficient Funds");
		}
	}

	@Override
	public String toString() {
		return "Number Account: " 
				+ numberAccount	
				+ ","
				+ people 
				+ ","
				+ " Balance R$: " + String.format("%.2f ", getBalance());
	}
	

	
}
