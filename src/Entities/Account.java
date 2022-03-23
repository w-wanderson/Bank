package Entities;

public abstract class Account {

	private static int counterCurrent = 1;
	private static int counterBusiness = 1;

	private String name;
	private String telefone;
	private String cpf;
	private String cnpj;
	private Double balance = 0.0;
	private double tax = 5.0;
	 

	public Account() {
	}

	public Account(String name, String telefone) {

		this.name = name;
		this.telefone = telefone;
		counterCurrent += 1;
		counterBusiness += 100;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public abstract void balance();

	public abstract void deposit(double value);

	public abstract void toWithdrawa(double value);

	@Override
	public String toString() {
		return "\nName: " + name + "\nTelefone " + telefone;

	}

	

	

}