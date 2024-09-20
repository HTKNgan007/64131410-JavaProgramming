package QLTinTuc;

import java.util.ArrayList;
import java.util.Scanner;

public class Apps {
	private static ArrayList<News> newsList = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
        do {
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    insertNews();
                    break;
                case 2:
                    viewNewsList(false);
                    break;
                case 3:
                    viewNewsList(true);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 4);
	}
	private static void insertNews() {
        News news = new News();

        System.out.print("Enter title: ");
        news.setTitle(scanner.nextLine());
        System.out.print("Enter publish date: ");
        news.setPublishDate(scanner.nextLine());
        System.out.print("Enter author: ");
        news.setAuthor(scanner.nextLine());
        System.out.print("Enter content: ");
        news.setContent(scanner.nextLine());

        // Nhập 3 đánh giá
        int[] rates = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter rate " + (i + 1) + ": ");
            rates[i] = scanner.nextInt();
        }
        scanner.nextLine();
        news.setRateList(rates);
        newsList.add(news);

        System.out.println("News added successfully.");
    }
	//
    private static void viewNewsList(boolean calculateRate) {
        if (newsList.isEmpty()) {
            System.out.println("No news available");
            return;
        }
        for (News news : newsList) {
            if (calculateRate) {
                news.Calculate();
            }
            news.Display();
            System.out.println("------------------------");
        }
    }
}
