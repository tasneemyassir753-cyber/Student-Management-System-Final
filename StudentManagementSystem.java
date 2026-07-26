import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {

    private static List<Person> people = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadSampleData();
        int choice;

        do {
            printMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addInstructor();
                    break;
                case 3:
                    addCourse();
                    break;
                case 4:
                    enrollStudentInCourse();
                    break;
                case 5:
                    displayAllPeople();
                    break;
                case 6:
                    displayAllCourses();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. Add Instructor");
        System.out.println("3. Add Course");
        System.out.println("4. Enroll Student in a Course");
        System.out.println("5. Display All People");
        System.out.println("6. Display All Courses");
        System.out.println("7. Exit");
        System.out.println("======================================");
    }

    private static void addStudent() {
        System.out.println("\n-- Add New Student --");
        String name = readString("Name: ");
        int id = readInt("ID: ");
        int age = readInt("Age: ");
        String studentId = readString("Student ID: ");
        String program = readString("Program: ");
        double gpa = readDouble("GPA: ");

        Student student = new Student(name, id, age, studentId, program, gpa);
        people.add(student);
        System.out.println("Student added.");
    }

    private static void addInstructor() {
        System.out.println("\n-- Add New Instructor --");
        String name = readString("Name: ");
        int id = readInt("ID: ");
        int age = readInt("Age: ");
        String employeeId = readString("Employee ID: ");
        String department = readString("Department: ");
        double salary = readDouble("Salary: ");

        Instructor instructor = new Instructor(name, id, age, employeeId, department, salary);
        people.add(instructor);
        System.out.println("Instructor added.");
    }

    private static void addCourse() {
        System.out.println("\n-- Add New Course --");
        String code = readString("Course Code: ");
        String name = readString("Course Name: ");
        int credits = readInt("Credit Hours: ");

        Course course = new Course(code, name, credits);
        courses.add(course);
        System.out.println("Course added.");
    }

    private static void enrollStudentInCourse() {
        if (courses.isEmpty()) {
            System.out.println("No courses available yet.");
            return;
        }

        String studentId = readString("\nEnter Student ID: ");
        Student target = null;

        for (Person p : people) {
            if (p instanceof Student) {
                Student s = (Student) p;
                if (s.getStudentId().equalsIgnoreCase(studentId)) {
                    target = s;
                    break;
                }
            }
        }

        if (target == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Available Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }

        int courseChoice = readInt("Select course number: ");
        if (courseChoice < 1 || courseChoice > courses.size()) {
            System.out.println("Invalid course selection.");
            return;
        }

        Course selectedCourse = courses.get(courseChoice - 1);
        target.enrollCourse(selectedCourse);
    }

    private static void displayAllPeople() {
        if (people.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n===== ALL PEOPLE RECORDS =====");
        for (Person p : people) {
            p.displayDetails();
        }
    }

    private static void displayAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        System.out.println("\n===== ALL COURSES =====");
        for (Course c : courses) {
            c.displayCourseInfo();
            System.out.println("---------------------------------------------");
        }
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    private static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }
        double value = sc.nextDouble();
        sc.nextLine();
        return value;
    }

    private static void loadSampleData() {
        Student s1 = new Student("Ahmad Faris", 1001, 20, "BIT2301", "BIT", 3.75);
        Student s2 = new Student("Nur Aisyah", 1002, 21, "BIT2302", "BISE", 3.90);
        Instructor i1 = new Instructor("Ahmad Rahman", 2001, 35, "EMP001", "Faculty of IT", 8500.00);

        people.add(s1);
        people.add(s2);
        people.add(i1);

        Course c1 = new Course("BIT1123", "Object Oriented Programming", 3);
        Course c2 = new Course("BIT1113", "Data Structures", 3);
        courses.add(c1);
        courses.add(c2);

        s1.enrollCourse(c1);
        s2.enrollCourse(c1);
        s2.enrollCourse(c2);
    }
}
