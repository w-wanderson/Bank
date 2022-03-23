package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public  class AccountCurrent extends Account {

	private static int accountant = 1;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
	Date current = new Date();

	private int numberAccount;

	private Account account;
	private String cpf;

	public AccountCurrent(Account account) {
		this.numberAccount = accountant;
		this.account = account;

		accountant += 1;

	}

	public AccountCurrent(String name, String telefone, String cpf) {
		super(name, telefone);
		this.cpf = cpf;
	}

	public int getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(int numberAccount) {
		this.numberAccount = numberAccount;
	}

	public Account getPeople() {
		return account;
	}

	public void setPeople(Account account) {
		this.account = account;
	}

	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public void balance() {

		getBalance();
	}
	@Override
	public void deposit(double value) {
		if (value > 0) {
			setBalance(getBalance() + value);
			System.out.println("Deposit Made Successfully" + " | " + sdf.format(current));
		} else {
			System.out.println("Value not Allowed!");
		}

	}
	@Override
	public void toWithdrawa(double value) {
		if (value > 0 && getBalance() >= value) {
			setBalance(getBalance() - value - account.getTax());
			

			System.out.println("Withdrawal Successful" + " | " + sdf.format(current));
		} else {
			System.out.println("Insufficient Funds");
		}
	}
	
	public void transfer(AccountCurrent originCurrent, AccountBusiness destinyBusiness, Double value) {
		if (value > 0 && getBalance() >= value) {
			setBalance(getBalance() - value);
			destinyBusiness.setBalance(destinyBusiness.getBalance() + value);
			originCurrent.setBalance(originCurrent.getBalance() + value);
			setBalance(getBalance() - value);
			System.out.println("Successful transfers" + " | " + sdf.format(current));
		} else {
			System.out.println("Insufficient Funds");
		}
	}

	@Override
	public String toString() {
		return "\nNumber Account current: " 
				+ numberAccount 
				+ "\nName: " 
				+ account.getName() 
				+ "\nCPF: " 
				+ account.getCpf()
				+ "\nTelefone: "
				+ account.getTelefone() 
				+ "\nBalance $: " + String.format("%.2f", getBalance());
	}

	
	

}
