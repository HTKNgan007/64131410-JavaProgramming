package QL_Sach;

import java.util.HashMap;

public class QL_Sach {
	private HashMap<String, Book> bookMap;

    public QL_Sach() {
        bookMap = new HashMap<>();
    }

    // Thêm sách
    public void addBook(Book book) {
        // Kiểm tra xem ISBN đã tồn tại hay chưa
        if (bookMap.containsKey(book.getIsbn())) {
            System.out.println("Sách với ISBN " + book.getIsbn() + " đã tồn tại. Không thể thêm.");
        } else {
            bookMap.put(book.getIsbn(), book);
            System.out.println("Đã thêm sách: " + book.getTitle());
        }
    }

    // Tìm sách theo ISBN
    public void findBookByIsbn(String isbn) {
        Book book = bookMap.get(isbn);
        if (book != null) {
            System.out.println("Thông tin sách: " + book);
        } else {
            System.out.println("Không tìm thấy sách với ISBN: " + isbn);
        }
    }

    // Xóa sách theo ISBN
    public void removeBookByIsbn(String isbn) {
        Book removedBook = bookMap.remove(isbn);
        if (removedBook != null) {
            System.out.println("Đã xóa sách: " + removedBook.getTitle());
        } else {
            System.out.println("Không tìm thấy sách để xóa.");
        }
    }

    // Hiển thị tất cả sách
    public void displayAllBooks() {
        if (bookMap.isEmpty()) {
            System.out.println("Không có sách trong danh sách.");
        } else {
            System.out.println("Danh sách sách:");
            for (Book book : bookMap.values()) {
                System.out.println(book);
            }
        }
    }
}
