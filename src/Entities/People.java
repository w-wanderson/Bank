package Entities;


public class People {

	private static int counter = 1;

	private String name;
	private String cpf;

	public People(String name, String cpf) {
		
		this.name = name;
		this.cpf = cpf;
		counter += 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "name " 
				+ name 
				+ ", cpf=" 
				+ cpf;
	}
	
	
}