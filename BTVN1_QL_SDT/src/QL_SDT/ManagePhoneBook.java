package QL_SDT;

import java.util.Scanner;

public class ManagePhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // In menu quản lý danh bạ
            System.out.println("PHONEBOOK MANAGEMENT SYSTEM");
            System.out.println("1. Insert Phone");
            System.out.println("2. Remove Phone");
            System.out.println("3. Update Phone");
            System.out.println("4. Search Phone");
            System.out.println("5. Sort");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự xuống dòng

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    phoneBook.insertPhone(name, phone);
                    break;
                case 2:
                    System.out.print("Enter name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    phoneBook.removePhone(nameToRemove);
                    break;
                case 3:
                    System.out.print("Enter name to update: ");
                    String nameToUpdate = scanner.nextLine();
                    System.out.print("Enter new phone: ");
                    String newPhone = scanner.nextLine();
                    phoneBook.updatePhone(nameToUpdate, newPhone);
                    break;
                case 4:
                    System.out.print("Enter name to search: ");
                    String nameToSearch = scanner.nextLine();
                    phoneBook.searchPhone(nameToSearch);
                    break;
                case 5:
                    phoneBook.sort();
                    break;
                case 6:
                	System.out.println("Exiting...");
                	break;
                default:
                	System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 7);
        
        scanner.close();
    }
}
