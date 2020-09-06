package studentDatabaseApp;

import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;

	// Constructor for name and year
	public Student() {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter students first name: ");
		this.firstName = in.nextLine();

		System.out.println("Enter students last name: ");
		this.lastName = in.nextLine();

		System.out.println("Enter students class level:\n1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior");
		this.gradeYear = in.nextInt();

		setStudentID();
		in.close();
	}

	// Generate ID
	private void setStudentID() {
		id++;
		// Grade level + static id
		this.studentID = gradeYear + "" + id;
	}

	// Enroll in courses
	public void enroll() {
		int newCourse;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("Enter course to enroll (0 to quit):");
			System.out.println("1 - History 101");
			System.out.println("2 - Mathematics 101");
			System.out.println("3 - English 101");
			System.out.println("4 - Chemistry 101");
			System.out.println("5 - Computer Science 101");
			newCourse = in.nextInt();
			if (newCourse != 0) {
				tuitionBalance += costOfCourse;
			}
			switch (newCourse) {
			case 1:
				courses += "\n\tHistory 101";
				break;
			case 2:
				courses += "\n\tMathematics 101";
				break;
			case 3:
				courses += "\n\tEnglish 101";
				break;
			case 4:
				courses += "\n\tChemistry 101";
				break;
			case 5:
				courses += "\n\tComputer Science 101";
				break;
			case 0:
				break;
			default:
				System.out.println("Incorrect input!");
				break;
			}
		} while (newCourse != 0);
		in.close();

	}

	// View balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance + ".");
	}

	// Pay tuition
	public void payTuition() {
		viewBalance();
		System.out.println("Your payment amount is: ");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance -= payment;
		System.out.println("Thank you for your payment of $" + payment + ".");
		viewBalance();
		in.close();
	}

	// Show status
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nGrade Level: " + gradeYear + "\nStudentID: " + studentID
				+ "\nCourses Enrolled: " + courses + "\nBalance: $" + tuitionBalance;
	}

	public static void menu(Student st) {
		int option;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("Chose an operation for student: ");
			System.out.println("\t1 - Enroll in courses");
			System.out.println("\t2 - Pay tuition");
			System.out.println("\t3 - Show student's info");
			System.out.println("\t0 - Quit");
			option = in.nextInt();
			switch (option) {
			case 1:
				st.enroll();
				break;
			case 2:
				st.payTuition();
				break;
			case 3:
				System.out.println(st.toString());
				break;
			case 0:
				break;
			default:
				System.out.println("Wrong input!");
				break;
			}
		}while(option!=0);
		in.close();
	}

}
