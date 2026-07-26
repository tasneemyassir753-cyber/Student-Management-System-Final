public class Instructor extends Person {

    private String employeeId;
    private String department;
    private double salary;

    public Instructor(String name, int id, int age, String employeeId, String department, double salary) {
        super(name, id, age);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("---------------------------------------------");
        System.out.println("INSTRUCTOR RECORD");
        showBasicInfo();
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Department  : " + department);
        System.out.println("Salary(RM)  : " + salary);
        System.out.println("---------------------------------------------");
    }
}
