package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountBusiness extends Account {

	private static int accountant = 10;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
	Date current = new Date();

	private int numberAccountBusiness;

	private Account account;
	private String cnpj;

	public AccountBusiness(Account account) {
		this.numberAccountBusiness = accountant;
		this.account = account;

		accountant += 10;
	}

	public AccountBusiness(String name, String telefone, String cnpj) {
		super(name, telefone);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getNumberAccountBusiness() {
		return numberAccountBusiness;
	}

	public void setNumberAccountBusiness(int numberAccount) {
		this.numberAccountBusiness = numberAccount;
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
			setBalance(getBalance() - value);

			System.out.println("Withdrawal Successful" + " | " + sdf.format(current));
		} else {
			System.out.println("Insufficient Funds");
		}
	}

	public void transfer(AccountBusiness origenBusiness, AccountCurrent destinyCurrent, Double value) {
		if (value > 0 && getBalance() >= value) {
			setBalance(getBalance() - value);
			origenBusiness.setBalance(origenBusiness.getBalance() + value);
			destinyCurrent.setBalance(destinyCurrent.getBalance() + value);
			setBalance(getBalance() - value);
			System.out.println("Successful transfers" + " | " + sdf.format(current));
		} else {
			System.out.println("Insufficient Funds");
		}
	}

	@Override
	public String toString() {
		return "\nNumber Account Business: " 
				+ numberAccountBusiness 
				+ "\nName: " 
				+ account.getName() 
				+ "\nCNPJ: "
				+ account.getCnpj() 
				+ "\nTelefone: " 
				+ account.getTelefone() 
				+ "\nBalance $: " + String.format("%.2f", getBalance());
	}

}
