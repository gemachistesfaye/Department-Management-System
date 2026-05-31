package project1;


public abstract class Person implements Displayable {

    // ─── Private Fields ───────────────────────────────────────────────────────────
    private int    id;
    private int    age;
    private String name;
    private String sex;
    private String departmentName;
    private String course;
    private Address address;

    // ─── Constructor ─────────────────────────────────────────────────────────────

    public Person(int id, String name, String sex, int age,
                  String departmentName, Address address, String course) {
        this.id             = id;
        this.name           = name;
        this.sex            = sex;
        this.age            = age;
        this.departmentName = departmentName;
        this.address        = address;
        this.course         = course;
    }

    // ─── Getters ─────────────────────────────────────────────────────────────────

    public int     getId()             { return id; }
    public int     getAge()            { return age; }
    public String  getName()           { return name; }
    public String  getSex()            { return sex; }
    public String  getDepartmentName() { return departmentName; }
    public String  getCourse()         { return course; }
    public Address getAddress()        { return address; }

    // ─── Displayable Implementation ───────────────────────────────────────────────

   
    @Override
    public void displayCourse(String courseName, String instructorName) {
        System.out.println("\n----------------------------");
        System.out.println("       Course Details        ");
        System.out.println("----------------------------");
        System.out.println("Course Name  : " + courseName);
        System.out.println("Instructor   : " + instructorName);
        System.out.println("----------------------------");
    }

    
    @Override
    public abstract void displayInfo();

    // ─── Shared Display Helper ────────────────────────────────────────────────────

    
    protected void displayPersonFields() {
        System.out.println("ID           : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Sex          : " + sex);
        System.out.println("Age          : " + age);
        System.out.println("Department   : " + departmentName);
        System.out.println("Address      : " + address);   
        System.out.println("Course       : " + course);
    }
}
