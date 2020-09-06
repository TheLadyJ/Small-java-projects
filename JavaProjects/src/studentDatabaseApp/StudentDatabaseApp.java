package studentDatabaseApp;

import java.util.Scanner;

public class StudentDatabaseApp {
	
	public static void main(String[] args) {	
		System.out.println("Enter number on new students to enroll: ");
		Scanner in = new Scanner(System.in);
		int numOfSt=in.nextInt();
		Student[] students = new Student[numOfSt];
		in.close();
		
		for(int n=0;n<numOfSt;n++) {
			students[n] = new Student();
		}
		
		int choice;
		Scanner ch = new Scanner(System.in);
		do {
			System.out.println("You want a menu for student("+1+"-"+students.length+"); 0 to quit: ");
			choice = ch.nextInt()-1;
			if(choice!=-1)
			Student.menu(students[choice]);
			
		}while(choice!=-1);
		ch.close();
		
	}

}
