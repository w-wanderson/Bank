package Application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Account;
import Entities.AccountBusiness;
import Entities.AccountCurrent;

public class Program {

	static Scanner sc = new Scanner(System.in);

	static List<AccountCurrent> listAccountCurrent = new ArrayList<>();
	static List<AccountBusiness> listAccountBusiness = new ArrayList<>();

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
	static Date current = new Date();

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		listAccountCurrent = new ArrayList<AccountCurrent>();
		listAccountBusiness = new ArrayList<AccountBusiness>();

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
				towithdrawal();
				break;

			case 4:
				balance();
				break;

			case 5:
				transfer();
				break;

			case 6:
				listAccountsCurrent();
				listAccountsBusiness();
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

		System.out.println("What Yype Of Account Do You Want To Create?");
		System.out.println();
		System.out.println("Choose 1 For Current Or 2 For Business");
		int option = sc.nextInt();

		try {

			switch (option) {
			case 1:

				System.out.println("Name:");
				String name = sc.next();

				System.out.println("CPF: ");
				String cpf = sc.next();

				System.out.println("tel: ");
				String tel = sc.next();

				AccountCurrent accountCurrent = new AccountCurrent(name, tel, cpf);

				listAccountCurrent.add(new AccountCurrent(accountCurrent));
				System.out.println("Account Created Successfully.");
				System.out.println();

				break;

			case 2:
				System.out.println("Fantasy Name:");
				String name_ = sc.next();

				System.out.println("CNPJ: ");
				String cnpj = sc.next();

				System.out.println("Phone: ");
				String phone_ = sc.next();

				AccountBusiness accountBusiness = new AccountBusiness(name_, phone_, cnpj);

				listAccountBusiness.add(new AccountBusiness(accountBusiness));
				System.out.println("Account Created Successfully.");
				System.out.println();
				break;

			default:
				System.out.println("Invalid Option");
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Entry Not Allowed.");
		}

		operations();

	}

	public static AccountCurrent findAccount(int accountNumber) {
		AccountCurrent accountCurrent = null;
		if (listAccountCurrent.size() > 0) {
			for (AccountCurrent ac : listAccountCurrent) {
				if (ac.getNumberAccount() == accountNumber)
					accountCurrent = ac;
			}

		}
		return accountCurrent;
	}

	public static AccountBusiness findAccountBusiness(int accountNumber) {
		AccountBusiness accountBusiness = null;
		if (listAccountBusiness.size() > 0) {
			for (AccountBusiness ac1 : listAccountBusiness) {
				if (ac1.getNumberAccountBusiness() == accountNumber)
					accountBusiness = ac1;
			}

		}
		return accountBusiness;
	}

	public static void deposit() {

		System.out.println("type of deposit account: 1 - for Current or 2 - for Business");
		int typeAccount = sc.nextInt();

		switch (typeAccount) {
		case 1:

			System.out.println("Account Number For Deposit:");
			int accountNumberCurrent = sc.nextInt();

			AccountCurrent accountCurrent = findAccount(accountNumberCurrent);

			if (accountCurrent != null) {
				System.out.println("What Is The deposit Amount: ");
				double amount = sc.nextDouble();

				accountCurrent.deposit(amount);

			} else {
				System.out.println("Account Not Found");
			}

			System.out.println();

			operations();

			break;
		case 2:

			System.out.println("Account Number For Deposit:");
			int accountNumberBusiness = sc.nextInt();

			AccountBusiness accountBusiness = findAccountBusiness(accountNumberBusiness);
			if (accountBusiness != null) {
				System.out.println("What Is The deposit Amount: ");
				double amount = sc.nextDouble();

				accountBusiness.deposit(amount);

			} else {
				System.out.println("Account Not Found");
			}

			System.out.println();

			operations();
			break;

		default:
			System.out.println("Invalid Option");
			break;

		}

		operations();

	}

	public static void towithdrawal() {

		System.out.println("account type for withdrawal: 1 - for Current or 2 - for Business");
		int typeAccount = sc.nextInt();

		switch (typeAccount) {
		case 1:
			System.out.println("Account Number For withdrawal:");
			int accountNumberCurrent = sc.nextInt();

			AccountCurrent accountCurrent = findAccount(accountNumberCurrent);

			if (accountCurrent != null) {
				System.out.println("Withdrawal Amount: ");
				double amount = sc.nextDouble();

				accountCurrent.toWithdrawa(amount);

			} else {
				System.out.println("Account Not Found");
			}

			operations();

			break;
		case 2:

			System.out.println("Account Number For withdrawal:");
			int accountNumberBusiness = sc.nextInt();

			AccountBusiness accountBusiness = findAccountBusiness(accountNumberBusiness);
			if (accountBusiness != null) {
				System.out.println("What Is The withdrawal Amount: ");
				double amount = sc.nextDouble();

				accountBusiness.toWithdrawa(amount);

			} else {
				System.out.println("Account Not Found");
			}

			System.out.println();

			operations();

			break;

		default:
			System.out.println("Invalid Option");
			break;
		}

		operations();
	}

	public static void balance() {

		System.out.println("Balance: 1 - for Current or 2 - for Business");
		int typeAccount = sc.nextInt();

		switch (typeAccount) {
		case 1:
			System.out.println("Account Number For Balance:");
			int accountNumberCurrent = sc.nextInt();

			AccountCurrent accountCurrent = findAccount(accountNumberCurrent);
			if (accountCurrent != null) {

				accountCurrent.getBalance();

				System.out.println(accountCurrent + " | " + sdf.format(current));

			} else {
				System.out.println("Account Not Found");
			}

			System.out.println();

			operations();

			break;

		case 2:

			System.out.println("Account Number For Balance:");
			int accountNumberBusiness = sc.nextInt();

			AccountBusiness accountBusiness = findAccountBusiness(accountNumberBusiness);
			if (accountBusiness != null) {

				accountBusiness.getBalance();

				System.out.println(accountBusiness + " | " + sdf.format(current));

			} else {
				System.out.println("Account Not Found");
			}

			System.out.println();

			operations();

			break;
		default:
			System.out.println("Invalid Option");
			break;
		}

		operations();
	}

	public static void transfer() {

		System.out.println("select origin account: 1 para current or 2 for business:");
		int option = sc.nextInt();

		switch (option) {
		case 1:
			System.out.println("Origin Account: ");
			int OriginAccountCurret = sc.nextInt();

			AccountCurrent accountCurrent = findAccount(OriginAccountCurret);

			if (accountCurrent != null) {
				System.out.println("Destiny account: ");
				int destinyAccount = sc.nextInt();

				AccountCurrent originCurrent = findAccount(OriginAccountCurret);
				AccountBusiness destinyBusiness = findAccountBusiness(destinyAccount);
				if (destinyBusiness != null || originCurrent != null) {
					System.out.println("Transfer Value: ");
					double value = sc.nextDouble();

					originCurrent.transfer(originCurrent, destinyBusiness, value);

				} else {
					System.out.println("Deposit Account Not Found.");
				}
			} else {
				System.out.println("Account For Transfer not Found.");
			}

			operations();
			break;

		case 2:

			System.out.println("Origin account: ");
			int OriginAccountBusiness = sc.nextInt();

			AccountBusiness accountBusiness = findAccountBusiness(OriginAccountBusiness);

			if (accountBusiness != null) {
				System.out.println("Destiny account number: ");
				int destinyAccount = sc.nextInt();

				AccountBusiness OriginBusiness = findAccountBusiness(OriginAccountBusiness);
				AccountCurrent destinyCurrent = findAccount(destinyAccount);

				if (OriginBusiness != null || destinyCurrent != null) {
					System.out.println("Transfer Value: ");
					double value = sc.nextDouble();

					OriginBusiness.transfer(OriginBusiness, destinyCurrent, value);

				} else {
					System.out.println("Deposit Account Not Found.");
				}
			} else {
				System.out.println("Account For Transfer not Found.");
			}

			operations();
			break;
		default:
			System.out.println("Invalid Option");
			break;
		}

	}

	public static void listAccountsCurrent() {
		if (listAccountCurrent.size() > 0) {
			for (AccountCurrent acc1 : listAccountCurrent) {
				System.out.println(acc1);
			}
		} else {
			System.out.println("No Registered Accounts Current ");
		}

	}

	public static void listAccountsBusiness() {
		if (listAccountBusiness.size() > 0) {
			for (AccountBusiness acc1 : listAccountBusiness) {
				System.out.println(acc1);
			}
		} else {
			System.out.println("No Registered Accounts Business ");
		}

		operations();

	}
}