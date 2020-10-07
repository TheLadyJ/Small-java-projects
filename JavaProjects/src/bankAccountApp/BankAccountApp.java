package bankAccountApp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		
		/*Checking chacc=new Checking("Tom Holland","123456789", 1500);
		Savings savacc=new Savings("Emma Watson","123321456",2500);
		
		chacc.showInfo();
		savacc.showInfo();
//		System.out.println();
//		savacc.deposit(5000);
//		savacc.withdraw(200);
//		savacc.transfer("Brokerage", 3000);
		
		savacc.compound();
		
		
		
		// Read a CSV file then create new accounts based on that data
		*/
		
		List<Account> accounts = new LinkedList<Account>();
		
		String file = "D:\\Udemy courses\\Java projects\\NewBankAccounts.csv";
		List<String[]> newAccountHolders = utilities.CSV.read(file);	
		
		for(String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			
			System.out.println(name+", "+sSN+", "+accountType+", "+initDeposit);
			if(accountType.equals("Savings")) {
				System.out.println("Open a savings account.");
				accounts.add(new Savings(name, sSN, initDeposit));
			}
			else if (accountType.equals("Checking")) {
				System.out.println("Open a checking account.");
				accounts.add(new Checking(name, sSN, initDeposit));
			}
			
			else
				System.out.println("ERROR reading account type.");
		}
		
		System.out.println();
		for(Account acc : accounts) {
			acc.showInfo();
		}
		
	}

}
