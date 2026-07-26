import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseCode;
    private String courseName;
    private int creditHours;
    private List<Student> enrolledStudents;

    public Course(String courseCode, String courseName, int creditHours) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        if (creditHours > 0) {
            this.creditHours = creditHours;
        }
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void addStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public void displayCourseInfo() {
        System.out.println("Course Code : " + courseCode);
        System.out.println("Course Name : " + courseName);
        System.out.println("Credit Hrs  : " + creditHours);
        System.out.println("Enrolled    : " + enrolledStudents.size() + " student(s)");
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseName + " (" + creditHours + " credit hrs)";
    }
}
