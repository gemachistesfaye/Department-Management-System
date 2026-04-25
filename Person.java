package project1;

public class Person implements Department {

    protected int id, age;
    protected String name, sex, departmentName, course;
    protected Address address;

    // Constructor
    public Person(int id, String name, String sex, int age,
                  String departmentName, Address address, String course) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.departmentName = departmentName;
        this.address = address;
        this.course = course;
    }

    // Getter for ID - Vital for the search logic in Case 4
    public int getId() {
        return id;
    }

    // Interface method implementation
    @Override
    public void displayCourse(String courseName, String instructorName) {
        System.out.println("\n----------------------------");
        System.out.println("Course Details");
        System.out.println("----------------------------");
        System.out.println("Course Name     : " + courseName);
        System.out.println("Instructor Name : " + instructorName);
        System.out.println("----------------------------");
    }

    // Display person info (Refined for cleaner output)
    public void displayPerson() {
        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Sex        : " + sex);
        System.out.println("Age        : " + age);
        System.out.println("Department : " + departmentName);
        System.out.println("City       : " + address.getCity());
        System.out.println("Course     : " + course);
    }

    // Placeholder for Override in Student class
    public void displayStudent() {
        System.out.println("Base Student Information (from Person class)");
    }
}