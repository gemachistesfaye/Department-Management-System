package project1;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice, cont = 1;

        while (cont == 1) {
            // MENU
            System.out.println("\n<=====Department Management System======>");
            System.out.println("1 To Register and Display Courses");
            System.out.println("2 To Register and Display Teacher");
            System.out.println("3 To Register and Display Student");
            System.out.println("4 To display Grade");
            System.out.println("5 To Exit the program");
            System.out.print("Please, Enter Your Choice: ");

            // MENU CHOICE VALIDATION
            while (!input.hasNextInt()) {
                System.err.println("Invalid input! Enter number only (1-5).");
                input.next();
                System.out.print("Please, Enter Your Choice: ");
            }
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    input.nextLine(); // Clear buffer
                    System.out.print("Enter course name: ");
                    String cName = input.nextLine();
                    while (!cName.matches("[a-zA-Z ]+")) {
                        System.err.println("Invalid! Enter letters only.");
                        System.out.print("Enter course name: ");
                        cName = input.nextLine();
                    }

                    System.out.print("Enter instructor name: ");
                    String iName = input.nextLine();
                    while (!iName.matches("[a-zA-Z ]+")) {
                        System.err.println("Invalid! Enter letters only.");
                        System.out.print("Enter instructor name: ");
                        iName = input.nextLine();
                    }

                    Person p = new Person(0, "", "", 0, "", new Address("N/A"), "");
                    p.displayCourse(cName, iName);
                    break;

                case 2:
                    input.nextLine(); // Clear buffer

                    // 1. Teacher Name
                    System.out.print("Enter Teacher Name: ");
                    String tname = input.nextLine();
                    while (!tname.matches("[a-zA-Z ]+")) {
                        System.err.println("Invalid! Enter letters only.");
                        System.out.print("Enter Teacher Name: ");
                        tname = input.nextLine();
                    }

                    // 2. Teacher ID
                    System.out.print("Enter Teacher ID: ");
                    while (!input.hasNextInt()) {
                        System.err.println("Invalid! Enter number only.");
                        input.next();
                        System.out.print("Enter Teacher ID: ");
                    }
                    int tid = input.nextInt();
                    input.nextLine(); // Clear buffer

                    // 3. Teacher Sex
                    System.out.print("Enter Sex: ");
                    String tsex = input.nextLine();
                    while (!tsex.matches("[a-zA-Z ]+")) {
                        System.err.println("Invalid! Enter letters only.");
                        System.out.print("Enter Sex: ");
                        tsex = input.nextLine();
                    }

                    // 4. Teacher Age
                    System.out.print("Enter Age: ");
                    while (!input.hasNextInt()) {
                        System.err.println("Invalid! Enter number only.");
                        input.next();
                        System.out.print("Enter Age: ");
                    }
                    int tage = input.nextInt();
                    input.nextLine(); // Clear buffer

                    // 5. Department
                    System.out.print("Enter Department: ");
                    String tdept = input.nextLine();
                    while (!tdept.matches("[a-zA-Z ]+")) {
                        System.err.println("Invalid! Enter letters only.");
                        System.out.print("Enter Department: ");
                        tdept = input.nextLine();
                    }

                    // 6. City (Address)
                    System.out.print("Enter City: ");
                    String tcity = input.nextLine();
                    while (!tcity.matches("[a-zA-Z ]+")) {
                        System.err.println("Invalid! Enter letters only.");
                        System.out.print("Enter City: ");
                        tcity = input.nextLine();
                    }

                    // Create the Teacher object with ALL the data
                    Person teacher = new Person(tid, tname, tsex, tage, tdept, new Address(tcity), "N/A");

                    System.out.println("\n----- Teacher Info -----");
                    teacher.displayPerson();
                    break;

                case 3:
                    // ID Validation
                    System.out.print("ID: ");
                    while (!input.hasNextInt()) {
                        System.err.println("Invalid! Enter number only.");
                        input.next();
                        System.out.print("ID: ");
                    }
                    int id = input.nextInt();
                    input.nextLine();

                    // Check if ID already exists (prevents duplicate students)
                    boolean exists = false;

                    for (Student st : students) {
                        if (st.getId() == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.err.println("ID already exists! Try another ID.");
                        break; // stops this case and returns to menu
                    }

                    // Name Validation
                    System.out.print("Name: ");
                    String name = input.nextLine();
                    while (!name.matches("[a-zA-Z ]+")) {
                        System.err.println("Invalid! Enter letters only.");
                        System.out.print("Name: ");
                        name = input.nextLine();
                    }

                    // Sex Validation
                    System.out.print("Sex: ");
                    String sex = input.nextLine();
                    while (!sex.matches("[a-zA-Z ]+")) {
                        System.err.println("Invalid! Enter letters only.");
                        System.out.print("Sex: ");
                        sex = input.nextLine();
                    }

                    // Age Validation
                    System.out.print("Age: ");
                    while (!input.hasNextInt()) {
                        System.err.println("Invalid! Enter number only.");
                        input.next();
                        System.out.print("Age: ");
                    }
                    int age = input.nextInt();
                    input.nextLine();

                    // Department Validation
                    System.out.print("Department: ");
                    String dept = input.nextLine();
                    while (!dept.matches("[a-zA-Z ]+")) {
                        System.err.println("Invalid! Enter letters only.");
                        System.out.print("Department: ");
                        dept = input.nextLine();
                    }

                    // City (Address) Validation - FIXED
                    System.out.print("City: ");
                    String city = input.nextLine();
                    while (!city.matches("[a-zA-Z ]+")) {
                        System.err.println("Invalid! Enter letters only.");
                        System.out.print("City: ");
                        city = input.nextLine();
                    }

                    // Course Validation
                    System.out.print("Course: ");
                    String course = input.nextLine();
                    while (!course.matches("[a-zA-Z ]+")) {
                        System.err.println("Invalid! Enter letters only.");
                        System.out.print("Course: ");
                        course = input.nextLine();
                    }

                    Student s = new Student(id, name, sex, age, dept, new Address(city), course);
                    students.add(s);
                    System.out.println("\nStudent Registered Successfully");
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.err.println("No students registered yet!");
                        break;
                    }

                    System.out.print("Enter Student ID: ");
                    while (!input.hasNextInt()) {
                        System.err.println("Invalid! Enter number only.");
                        input.next();
                        System.out.print("Enter Student ID: ");
                    }
                    int searchId = input.nextInt();

                    Student found = null;
                    for (Student st : students) {
                        if (st.getId() == searchId) {
                            found = st;
                            break;
                        }
                    }

                    if (found != null) {
                        // Mid Validation
                        System.out.print("Enter Mid (Max 30): ");
                        while (!input.hasNextDouble()) {
                            System.err.println("Invalid! Enter number only.");
                            input.next();
                            System.out.print("Enter Mid (Max 30): ");
                        }
                        double mid = input.nextDouble();

                        // Project Validation
                        System.out.print("Enter Project (Max 30): ");
                        while (!input.hasNextDouble()) {
                            System.err.println("Invalid! Enter number only.");
                            input.next();
                            System.out.print("Enter Project (Max 30): ");
                        }
                        double project = input.nextDouble();

                        // Final Validation
                        System.out.print("Enter Final (Max 40): ");
                        while (!input.hasNextDouble()) {
                            System.err.println("Invalid! Enter number only.");
                            input.next();
                            System.out.print("Enter Final (Max 40): ");
                        }
                        double fin = input.nextDouble();

                        found.setMarks(mid, project, fin);
                        found.Grade();
                    } else {
                        System.err.println("Student ID not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.err.println("Invalid menu choice!");
            }

            // CONTINUE SAFETY
            while (true) {
                System.out.print("\nDo you want to continue? (1 for yes and 2 for no) : ");
                if (input.hasNextInt()) {
                    cont = input.nextInt();
                    if (cont == 1 || cont == 2) {
                        break;
                    }
                    System.err.println("Invalid input! Enter 1 or 2 only.");
                } else {
                    System.err.println("Invalid input! Numbers only.");
                    input.next();
                }
            }
            if (cont == 2) {
                System.err.println("Program terminated.");
                System.exit(0);
            }
        }
    }
}
