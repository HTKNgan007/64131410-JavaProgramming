package HTQL_Books;

import java.util.ArrayList;
import java.util.Scanner;

public class Apps {

	private static ArrayList<Book> bookList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    insertNewBook();
                    break;
                case 2:
                    viewListOfBooks();
                    break;
                case 3:
                    showAveragePrice();
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
        System.out.println("1. Insert new book");
        System.out.println("2. View list of books");
        System.out.println("3. Calculate and show average price");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    //
    private static void insertNewBook() {
        System.out.print("Enter book name: ");
        String name = scanner.nextLine();
        System.out.print("Enter publish date: ");
        String publishDate = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter language: ");
        String language = scanner.nextLine();

        Book newBook = new Book(name, publishDate, author, language);
        //Add 5 prices 
        int[] prices = new int[5];
        System.out.println("Enter 5 prices: ");
        for (int i = 0; i < 5; i++) {
            System.out.print("Price " + (i + 1) + ": ");
            prices[i] = scanner.nextInt();
        }
        newBook.setPriceList(prices);
        bookList.add(newBook);
        System.out.println("Book added successfully!\n");
    }
    //
    private static void viewListOfBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books available.\n");
        } else {
            System.out.println("List of Books:");
            for (Book book : bookList) {
                book.display();
            }
        }
    }
    //
    private static void showAveragePrice() {
        if (bookList.isEmpty()) {
            System.out.println("No books available.\n");
        } else {
            for (Book book : bookList) {
                book.calculate();
                book.display();
            }
        }
    }

}
