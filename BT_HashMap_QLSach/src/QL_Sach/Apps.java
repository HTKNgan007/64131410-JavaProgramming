package QL_Sach;

import java.util.Scanner;

public class Apps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        QL_Sach manager = new QL_Sach();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Quản Lý Sách -----");
            System.out.println("1. Thêm sách");
            System.out.println("2. Tìm sách theo ISBN");
            System.out.println("3. Xóa sách theo ISBN");
            System.out.println("4. Hiển thị tất cả sách");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Nhập tên sách: ");
                    String title = scanner.nextLine();
                    System.out.print("Nhập tên tác giả: ");
                    String author = scanner.nextLine();
                    Book book = new Book(isbn, title, author);
                    manager.addBook(book);
                    break;

                case 2:
                    System.out.print("Nhập ISBN để tìm: ");
                    String searchIsbn = scanner.nextLine();
                    manager.findBookByIsbn(searchIsbn);
                    break;

                case 3:
                    System.out.print("Nhập ISBN để xóa: ");
                    String removeIsbn = scanner.nextLine();
                    manager.removeBookByIsbn(removeIsbn);
                    break;

                case 4:
                    manager.displayAllBooks();
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
	}
}
