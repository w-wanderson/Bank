package Application;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import java.util.InputMismatchException;

import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Entities.Account;
import Entities.People;

public class Program {

	static Scanner sc = new Scanner(System.in);
	static List<Account> accountsBanks = new ArrayList<>();

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
	static Date current = new Date();

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		accountsBanks = new ArrayList<Account>();

		operations();
	}

	public static void operations() {
		System.out.println("choose the desired option");
		System.out.println();

		System.out.println("1 - Create an Account");
		System.out.println("2 - Deposit");
		System.out.println("3 - Withdraw");
		System.out.println("4 - Balance");
		System.out.println("5 - Transfer");
		System.out.println("6 - List Accounts");
		System.out.println("7 - Exit");
		System.out.println();

		try {
			int option = sc.nextInt();

			switch (option) {
			case 1:
				createAccount();

				break;
			case 2:
				deposit();
				break;

			case 3:
				toWhitdraw();
				break;

			case 4:
				balance();
				break;

			case 5:
				transfer();
				break;

			case 6:
				listAccounts();
				break;

			case 7:
				System.out.println("Thank You Always Come Back");
				System.exit(0);

				break;

			default:
				System.out.println("Invalid Option");
				break;

			}

		} catch (InputMismatchException e) {
			System.out.println("Entry Not Allowed.");

		}

	}

	public static void createAccount() {

		System.out.println("Name:");
		String name = sc.next();

		System.out.println("CPF: ");
		String cpf = sc.next();

		People people = new People(name, cpf);

		Account acc = new Account(people);

		accountsBanks.add(acc);
		System.out.println("Account Created Successfully.");
		System.out.println();

		operations();

	}

	public static Account findAccount(int accountNumber) {
		Account acc = null;
		if (accountsBanks.size() > 0) {
			for (Account ac : accountsBanks) {
				if (ac.getNumberAccount() == accountNumber)
					acc = ac;
			}

		}
		return acc;
	}

	public static void deposit() {
		System.out.println("Account Number For Deposit:");
		int accountNum = sc.nextInt();

		Account acc = findAccount(accountNum);

		if (acc != null) {
			System.out.println("What Is The deposit Amount: ");
			double amount = sc.nextDouble();

			acc.deposit(amount);

		} 
		else {
			System.out.println("Account Not Found");
		}
		
		System.out.println();
		operations();

	}

	public static void toWhitdraw() {
		System.out.println("Account Number: ");
		int accountNum = sc.nextInt();

		Account acc = findAccount(accountNum);

		if (acc != null) {
			System.out.println("Withdrawal Amount: ");
			double amount = sc.nextDouble();

			acc.toWithdrawa(amount);

		} 
		else {
			System.out.println("Account Not Found");
		}
		operations();
	}

	public static void balance() {

		System.out.println("Account Number: ");
		int accountNum = sc.nextInt();
		Account acc = findAccount(accountNum);

		acc.balance();
		System.out.println(acc + " | " + sdf.format(current));

		operations();
	}

	public static void transfer() {
		System.out.println("Sender Account Number: ");
		int accountNumSen = sc.nextInt();

		Account accountSender = findAccount(accountNumSen);

		if (accountSender != null) {
			System.out.println("Destiny account number: ");
			int destinyAccount = sc.nextInt();

			Account destiny = findAccount(destinyAccount);

			if (destiny != null) {
				System.out.println("Transfer Value: ");
				double value = sc.nextDouble();

				accountSender.transfer(destiny, value);

			} 
			else {
				System.out.println("Deposit Account Not Found.");
			}
		} 
		else {
			System.out.println("Account For Transfer not Found.");
		}

		operations();
	}

	public static void listAccounts() {
		if (accountsBanks.size() > 0) {
			for (Account acc : accountsBanks) {
				System.out.println(acc);
			}
		} 
		else {
			System.out.println("No Registered Accounts ");
		}
		operations();
	}

}
