package QL_SinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QL_SinhVien {
	private ArrayList<Student> students;

    public QL_SinhVien() {
        students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    //Hiển thị danh sách
    public void displayStudents() {
    	if (students.isEmpty()) {
            System.out.println("Chưa có sinh viên trong danh sách.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    //Xóa sinh viên theo mã sinh viên
    public boolean removeStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    //Cập nhật thông tin sinh viên theo mã sinh viên
    public boolean updateStudentById(int id, String newName, int newAge, double newGpa) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(newName);
                student.setAge(newAge);
                student.setGpa(newGpa);
                return true;
            }
        }
        return false;
    }

    //Tìm kiếm sinh viên theo tên
    public void searchStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
            }
        }
    }

    //Sắp xếp danh sách sinh viên theo GPA giảm dần
    public void sortStudentsByGPA() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getGpa(), s1.getGpa());
            }
        });
    }
}
