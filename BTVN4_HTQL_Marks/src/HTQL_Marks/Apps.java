package HTQL_Marks;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Apps {

	private static ArrayList<StudentMark> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option = 0;
        do {
            showMenu();
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }
            scanner.nextLine();

            switch (option) {
                case 1:
                    insertNewStudent();
                    break;
                case 2:
                    viewListOfStudents();
                    break;
                case 3:
                    showAverageMarks();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 4);
	}
	
	private static void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. Insert new Student");
        System.out.println("2. View list of Students");
        System.out.println("3. Calculate and show average mark");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }
	
	private static void insertNewStudent() {
        try {
            System.out.print("Enter student's full name: ");
            String fullName = scanner.nextLine();
            System.out.print("Enter student's class: ");
            String studentClass = scanner.nextLine();
            System.out.print("Enter semester: ");
            int semester = scanner.nextInt();

            // Create a new StudentMark instance
            StudentMark newStudent = new StudentMark(fullName, studentClass, semester);

            // Input the 5 subject marks
            int[] marks = new int[5];
            System.out.println("Enter 5 subject marks: ");
            for (int i = 0; i < 5; i++) {
                System.out.print("Mark " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
            }
            newStudent.setSubjectMarkList(marks);

            // Add the student
            studentList.add(newStudent);
            System.out.println("Student added successfully!\n");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter the correct data.");
            scanner.next();
        } finally {
            System.out.println("Returning to menu\n");
        }
    }

    //
    private static void viewListOfStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.\n");
        } else {
            System.out.println("List of Students:");
            for (StudentMark student : studentList) {
                student.display();
            }
        }
    }

    //
    private static void showAverageMarks() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.\n");
        } else {
            for (StudentMark student : studentList) {
                student.aveCal();
                student.display();
            }
        }
    }

}
