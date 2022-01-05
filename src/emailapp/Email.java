package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 50;
	private String alternateEmail;
	private int defaultPasswordLength = 10;
	private String companySuffix = "aeycompany.com";

	// constructor to receive data
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("email created:  " + firstName + " " + lastName);

		// calling method asking department
		this.department = setDepartment();
		System.out.println("Department of " + this.department);

		// calling method generate random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("your password is: " + this.password);

		// combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
		System.out.println("your email is: " + email);
	}

	private String setDepartment() {
		System.out.println("enter department codes : \n1 for sales \n2 for development \n3 for Accounting \n-->");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {
			return "sales";
		} else if (depChoice == 2) {
			return "dev";
		} else if (depChoice == 3) {
			return "acct";
		} else {
			return "";
		}
	}

	// Generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWYZ0123456789*#";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	// set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// change password
	public void changePassword(String password) {
		this.password = password;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}
	public String getPassword() {
		return password;
	}
	
	//method display
	public String show() {
		return ("Full Name: "+firstName+" "+lastName+" email: "+email+ " mailbox capacity: "+ mailboxCapacity);
	}
	
}
