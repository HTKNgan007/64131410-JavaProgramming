package QL_SinhVien;

import java.util.Scanner;

public class Apps {

	public static void main(String[] args) {
		//
		QL_SinhVien manager = new QL_SinhVien();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("MENU");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Xóa sinh viên theo mã");
            System.out.println("4. Cập nhật thông tin sinh viên");
            System.out.println("5. Tìm kiếm sinh viên theo tên");
            System.out.println("6. Sắp xếp sinh viên theo GPA giảm dần");
            System.out.println("7. Thoát");
            System.out.print("Choose an opition");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Thêm sinh viên
                    System.out.print("Nhập mã sinh viên: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên sinh viên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập tuổi sinh viên: ");
                    int age = scanner.nextInt();
                    System.out.print("Nhập GPA: ");
                    double gpa = scanner.nextDouble();
                    Student student = new Student(id, name, age, gpa);
                    manager.addStudent(student);
                    break;
                case 2:
                    // Hiển thị danh sách sinh viên
                    manager.displayStudents();
                    break;
                case 3:
                    // Xóa sinh viên theo mã
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    int removeId = scanner.nextInt();
                    if (manager.removeStudentById(removeId)) {
                        System.out.println("Xóa thành công.");
                    } else {
                        System.out.println("Không tìm thấy sinh viên.");
                    }
                    break;
                case 4:
                    // Cập nhật thông tin sinh viên
                    System.out.print("Nhập mã sinh viên cần cập nhật: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nhập tuổi mới: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Nhập GPA mới: ");
                    double newGpa = scanner.nextDouble();
                    if (manager.updateStudentById(updateId, newName, newAge, newGpa)) {
                        System.out.println("Cập nhật thành công.");
                    } else {
                        System.out.println("Không tìm thấy sinh viên.");
                    }
                    break;
                case 5:
                    // Tìm kiếm sinh viên theo tên
                    scanner.nextLine();
                    System.out.print("Nhập tên sinh viên cần tìm: ");
                    String searchName = scanner.nextLine();
                    manager.searchStudentByName(searchName);
                    break;
                case 6:
                    // Sắp xếp sinh viên theo GPA giảm dần
                    manager.sortStudentsByGPA();
                    System.out.println("Đã sắp xếp sinh viên theo GPA.");
                    break;
                case 7:
                    // Thoát
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 7);

        scanner.close();
    }
}
