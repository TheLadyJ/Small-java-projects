package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private int defaultPasswordLength = 10;
	static String companyName = "company";

	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		System.out.println("New worker: " + firstName + " " + lastName);

		// Call a method asking for the department - return the department
		this.department = setDepartment();

		// Call a method that returns a random password
		this.password = randomPassword();

		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companyName + ".com";

		System.out.println("Your password is: " + password);

	}

	// Ask for department
	private String setDepartment() {
		System.out.println("Enter the department:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
		Scanner in = new Scanner(System.in);
		int dep = in.nextInt();
		if (dep == 1) {
			in.close();
			return "sales";
		} else if (dep == 2) {
			in.close();
			return "development";
		} else if (dep == 3) {
			in.close();
			return "accounting";
		} else {
			in.close();
			return "";
		}

	}

	// Generate a random password
	private String randomPassword() {
		String passwordSet = "ABCDEFGHIJKLMNOPRSTUWXYZ0123456789!@#$%&*";
		char[] password = new char[defaultPasswordLength];
		for (int i = 0; i < defaultPasswordLength; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// Set an alternate email
	public void setAlternteEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}

	// Display the name, email, and mailbox capacity
	public int getMailboxCapacity() {
		return mailboxCapacity;
	};

	public String getAlternateEmail() {
		return alternateEmail;
	};

	public String getPassword() {
		return password;
	}

	public String displayInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: "
				+ mailboxCapacity;
	}

}
