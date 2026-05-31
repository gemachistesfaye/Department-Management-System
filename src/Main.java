package project1;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    // ─── Application State ────────────────────────────────────────────────────────
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final ArrayList<Teacher> teachers = new ArrayList<>();
    private static Scanner input;

    // ─── Entry Point ─────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        input = new Scanner(System.in);
        int cont = 1;

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   Department Management System v2.0  ║");
        System.out.println("╚══════════════════════════════════════╝");

        while (cont == 1) {
            printMenu();
            int choice = InputHelper.readIntInRange(input, "Enter your choice (1-7): ", 1, 7);

            switch (choice) {
                case 1 -> registerCourse();
                case 2 -> registerTeacher();
                case 3 -> registerStudent();
                case 4 -> displayGrade();
                case 5 -> listAllStudents();
                case 6 -> listAllTeachers();
                case 7 -> exitProgram();
            }

            cont = InputHelper.askContinue(input);
            if (cont == 2) exitProgram();
        }
    }

    // ─── Menu ─────────────────────────────────────────────────────────────────────

    private static void printMenu() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│           MAIN MENU                 │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. Register & Display Course       │");
        System.out.println("│  2. Register Teacher                │");
        System.out.println("│  3. Register Student                │");
        System.out.println("│  4. Display Student Grade           │");
        System.out.println("│  5. List All Students               │");
        System.out.println("│  6. List All Teachers               │");
        System.out.println("│  7. Exit                            │");
        System.out.println("└─────────────────────────────────────┘");
    }

    // ─── Case 1: Register & Display Course ───────────────────────────────────────

    private static void registerCourse() {
        System.out.println("\n── Course Registration ──");
        String courseName      = InputHelper.readAlpha(input, "Course Name     : ");
        String instructorName  = InputHelper.readAlpha(input, "Instructor Name : ");

        System.out.println("\n----------------------------");
        System.out.println("       Course Details        ");
        System.out.println("----------------------------");
        System.out.println("Course Name  : " + courseName);
        System.out.println("Instructor   : " + instructorName);
        System.out.println("----------------------------");
    }

    // ─── Case 2: Register Teacher ─────────────────────────────────────────────────

  
    private static void registerTeacher() {
        System.out.println("\n── Teacher Registration ──");

        int id = InputHelper.readInt(input, "Teacher ID         : ");
        if (teacherIdExists(id)) {
            System.err.println("  A teacher with ID " + id + " already exists!");
            return;
        }

        String name           = InputHelper.readAlpha(input, "Name               : ");
        String sex            = InputHelper.readAlpha(input, "Sex (Male/Female)  : ");
        int    age            = InputHelper.readIntInRange(input, "Age                : ", 18, 99);
        String department     = InputHelper.readAlpha(input, "Department         : ");
        String city           = InputHelper.readAlpha(input, "City               : ");
        String region         = InputHelper.readAlpha(input, "Region/State       : ");
        String country        = InputHelper.readAlpha(input, "Country            : ");
        String course         = InputHelper.readAlpha(input, "Course Taught      : ");
        String specialization = InputHelper.readAlpha(input, "Specialization     : ");
        int    experience     = InputHelper.readIntInRange(input, "Years of Experience: ", 0, 60);

        Teacher t = new Teacher(id, name, sex, age, department,
                new Address(city, region, country),
                course, specialization, experience);
        teachers.add(t);
        t.displayInfo();
        System.out.println("  ✔ Teacher registered successfully.");
    }

    // ─── Case 3: Register Student ─────────────────────────────────────────────────

    private static void registerStudent() {
        System.out.println("\n── Student Registration ──");

        int id = InputHelper.readInt(input, "Student ID      : ");
        if (studentIdExists(id)) {
            System.err.println("  A student with ID " + id + " already exists!");
            return;
        }

        String name       = InputHelper.readAlpha(input, "Name            : ");
        String sex        = InputHelper.readAlpha(input, "Sex (Male/Female): ");
        int    age        = InputHelper.readIntInRange(input, "Age             : ", 10, 99);
        String department = InputHelper.readAlpha(input, "Department      : ");
        String city       = InputHelper.readAlpha(input, "City            : ");
        String region     = InputHelper.readAlpha(input, "Region/State    : ");
        String country    = InputHelper.readAlpha(input, "Country         : ");
        String course     = InputHelper.readAlpha(input, "Course          : ");

        Student s = new Student(id, name, sex, age, department,
                new Address(city, region, country), course);
        students.add(s);
        System.out.println("  ✔ Student registered successfully.");
    }

    // ─── Case 4: Display Grade ────────────────────────────────────────────────────

    
    private static void displayGrade() {
        System.out.println("\n── Grade Entry ──");

        if (students.isEmpty()) {
            System.err.println("  No students registered yet!");
            return;
        }

        int id = InputHelper.readInt(input, "Enter Student ID: ");
        Student found = findStudentById(id);

        if (found == null) {
            System.err.println("  Student with ID " + id + " not found.");
            return;
        }

        double mid     = InputHelper.readDoubleInRange(input, "Mid Exam  (0–30) : ", 0, 30);
        double project = InputHelper.readDoubleInRange(input, "Project   (0–30) : ", 0, 30);
        double fin     = InputHelper.readDoubleInRange(input, "Final Exam (0–40): ", 0, 40);

        if (found.setMarks(mid, project, fin)) {
            found.displayGrade();
        }
    }

    // ─── Case 5: List All Students ────────────────────────────────────────────────

  
    private static void listAllStudents() {
        System.out.println("\n── Registered Students ──");
        if (students.isEmpty()) {
            System.out.println("  No students registered yet.");
            return;
        }
        System.out.printf("%-6s %-20s %-5s %-20s %-20s%n",
                "ID", "Name", "Age", "Department", "Course");
        System.out.println("─".repeat(75));
        for (Student s : students) {
            System.out.printf("%-6d %-20s %-5d %-20s %-20s%n",
                    s.getId(), s.getName(), s.getAge(),
                    s.getDepartmentName(), s.getCourse());
        }
        System.out.println("─".repeat(75));
        System.out.println("Total: " + students.size() + " student(s)");
    }

    // ─── Case 6: List All Teachers ────────────────────────────────────────────────

    private static void listAllTeachers() {
        System.out.println("\n── Registered Teachers ──");
        if (teachers.isEmpty()) {
            System.out.println("  No teachers registered yet.");
            return;
        }
        System.out.printf("%-6s %-20s %-5s %-20s %-20s%n",
                "ID", "Name", "Age", "Department", "Specialization");
        System.out.println("─".repeat(75));
        for (Teacher t : teachers) {
            System.out.printf("%-6d %-20s %-5d %-20s %-20s%n",
                    t.getId(), t.getName(), t.getAge(),
                    t.getDepartmentName(), t.getSpecialization());
        }
        System.out.println("─".repeat(75));
        System.out.println("Total: " + teachers.size() + " teacher(s)");
    }

    // ─── Case 7: Exit ─────────────────────────────────────────────────────────────

    private static void exitProgram() {
        System.out.println("\n  Goodbye! Program terminated.");
        input.close();   
        System.exit(0);
    }

    // ─── ID Lookup Helpers ────────────────────────────────────────────────────────

    private static boolean studentIdExists(int id) {
        return findStudentById(id) != null;
    }

    private static boolean teacherIdExists(int id) {
        for (Teacher t : teachers) {
            if (t.getId() == id) return true;
        }
        return false;
    }

    private static Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}
