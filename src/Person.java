public abstract class Person {

    private String name;
    private int id;
    private int age;

    public Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age.");
        }
    }

    public abstract void displayDetails();

    public void showBasicInfo() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age);
    }
}
