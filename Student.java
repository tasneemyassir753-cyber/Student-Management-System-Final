import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Enrollable {

    private String studentId;
    private String program;
    private double gpa;
    private List<Course> enrolledCourses;

    public Student(String name, int id, int age, String studentId, String program, double gpa) {
        super(name, id, age);
        this.studentId = studentId;
        this.program = program;
        this.gpa = gpa;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Invalid GPA.");
        }
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
            System.out.println(getName() + " enrolled in " + course.getCourseName());
        } else {
            System.out.println(getName() + " already enrolled in " + course.getCourseName());
        }
    }

    @Override
    public void dropCourse(Course course) {
        if (enrolledCourses.remove(course)) {
            course.removeStudent(this);
            System.out.println(getName() + " removed from " + course.getCourseName());
        } else {
            System.out.println(getName() + " is not enrolled in " + course.getCourseName());
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("---------------------------------------------");
        System.out.println("STUDENT RECORD");
        showBasicInfo();
        System.out.println("Student ID  : " + studentId);
        System.out.println("Program     : " + program);
        System.out.println("GPA         : " + gpa);
        System.out.print("Courses     : ");
        if (enrolledCourses.isEmpty()) {
            System.out.println("Not enrolled in any course yet.");
        } else {
            for (Course c : enrolledCourses) {
                System.out.print(c.getCourseCode() + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }
}
