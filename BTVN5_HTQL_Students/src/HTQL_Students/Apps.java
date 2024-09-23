package HTQL_Students;

import java.util.ArrayList;
import java.util.Scanner;

public class Apps {
	private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int option = 0;
        do {
            showMenu();
            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Dữ liệu không hợp lệ! Vui lòng nhập lại.");
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
                    searchStudents();
                    break;
                case 4:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        } while (option != 4);
    }

    //
    private static void showMenu() {
        System.out.println("=== Hệ Thống Quản Lý Sinh Viên ===");
        System.out.println("1. Thêm sinh viên mới");
        System.out.println("2. Xem danh sách sinh viên");
        System.out.println("3. Tìm kiếm sinh viên theo lớp");
        System.out.println("4. Thoát");
        System.out.print("Chọn một tùy chọn: ");
    }

    //
    private static void insertNewStudent() {
        try {
            System.out.print("Nhập họ tên sinh viên: ");
            String fullName = scanner.nextLine();
            System.out.print("Nhập ngày sinh (dd/mm/yyyy): ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Nhập quê quán: ");
            String nativePlace = scanner.nextLine();
            System.out.print("Nhập lớp: ");
            String studentClass = scanner.nextLine();
            System.out.print("Nhập số điện thoại: ");
            String phoneNo = scanner.nextLine();
            System.out.print("Nhập số di động: ");
            int mobile = scanner.nextInt();

            // Tạo một đối tượng Student mới
            Student newStudent = new Student(fullName, dateOfBirth, nativePlace, studentClass, phoneNo, mobile);

            // Thêm sinh viên vào danh sách
            studentList.add(newStudent);
            System.out.println("Thêm sinh viên thành công!\n");
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra khi nhập thông tin sinh viên. Vui lòng thử lại.");
            scanner.next(); // Xóa input không hợp lệ
        }
    }

    // Xem danh sách sinh viên
    private static void viewListOfStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Không có sinh viên nào.\n");
        } else {
            System.out.println("Danh sách sinh viên:");
            for (Student student : studentList) {
                student.Display();
            }
        }
    }

    // Tìm kiếm sinh viên theo lớp
    private static void searchStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Không có sinh viên nào để tìm kiếm.\n");
            return;
        }

        System.out.print("Nhập lớp để tìm kiếm: ");
        String classToSearch = scanner.nextLine();

        boolean found = false;
        for (Student student : studentList) {
            if (student.getStudentClass().equalsIgnoreCase(classToSearch)) {
                student.Display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào trong lớp " + classToSearch + ".\n");
        }
    }
}
