package bankAccountApp;

public class Checking extends Account{
	// List properties specific to a Checking account
	private int debitCardNumber;
	private int debitCardPin;
	
	// Constructor to initialize settings for Checking account properties
	public Checking(String name, String sSN,double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber=2+accountNumber;
		setDebitCard();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() * 0.15;
		
	}
	
	
	
	private void setDebitCard() {
		debitCardNumber = (int)(Math.random() * Math.pow(10, 12));
		debitCardPin = (int) (int)(Math.random() * Math.pow(10, 4));
	}
	
	
	// List any methods specific to the Checking account
	
	public void showInfo() {
		super.showInfo();
		System.out.println(
				"Your Checking Account Features:"
				+ "\nDebit card number : "+debitCardNumber+
				 "\nDebit card pin : "+debitCardPin);
		System.out.println();
	}

	

}
