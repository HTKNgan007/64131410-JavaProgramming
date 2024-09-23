package HTQL_Marks;

public class StudentMark implements IStudentMark {
	private static int count = 0;
    private String fullName;
    private int id;
    private String studentClass;
    private int semester;
    private float averageMark;
    private int[] subjectMarkList = new int[5];
    
    public StudentMark(String fullName, String studentClass, int semester) {
        this.id = ++count;
        this.fullName = fullName;
        this.studentClass = studentClass;
        this.semester = semester;
    }
    
    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Class: " + studentClass);
        System.out.println("Semester: " + semester);
        System.out.println("Average Mark: " + averageMark);
        System.out.println();
    }
    
    public void aveCal() {
        int sum = 0;
        for (int mark : subjectMarkList) {
            sum += mark;
        }
        this.averageMark = sum / 5.0f;
    }

    public void setSubjectMarkList(int[] marks) {
        if (marks.length == 5) {
            this.subjectMarkList = marks;
        } else {
            System.out.println("Subject marks must have 5 elements.");
        }
    }
}
