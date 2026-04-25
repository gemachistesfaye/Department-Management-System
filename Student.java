package project1;

public class Student extends Person {

    // Marks (weighted system - points earned out of max)
    private double midexam;
    private double project;
    private double finalExam;

    // Constructor (ONLY registration data)
    public Student(int id, String name, String sex, int age,
                   String departmentName, Address address, String course) {
        super(id, name, sex, age, departmentName, address, course);
    }

    // Set marks after registration
    public void setMarks(double midexam, double project, double finalExam) {
        this.midexam = midexam;
        this.project = project;
        this.finalExam = finalExam;
    }

    // Display student basic info
    @Override
    public void displayStudent() {
        System.out.println("----- Student Information -----");
        displayPerson();
    }

    // Grade calculation (UPDATED: Simple Addition + Combined Output)
    public void Grade() {
        // Validation: Ensure marks are within the possible points (30, 30, 40)
        if (midexam < 0 || midexam > 30 || project < 0 || project > 30 || finalExam < 0 || finalExam > 40) {
            System.out.println("Error: Marks out of range! (Midexam/Project max 30, Final max 40)");
            return;
        }

        // Logic: Simple Addition (treating inputs as points earned)
        double total = midexam + project + finalExam;

        String grade;
        String status;

        // Grading system
        if (total >= 90) { grade = "A+"; status = "Excellent"; }
        else if (total >= 85) { grade = "A"; status = "Excellent"; }
        else if (total >= 80) { grade = "A-"; status = "Very Good"; }
        else if (total >= 75) { grade = "B+"; status = "Very Good"; }
        else if (total >= 70) { grade = "B"; status = "Good"; }
        else if (total >= 65) { grade = "B-"; status = "Good"; }
        else if (total >= 60) { grade = "C+"; status = "Satisfactory"; }
        else if (total >= 50) { grade = "C"; status = "Satisfactory"; }
        else if (total >= 45) { grade = "D"; status = "Weak"; }
        else { grade = "F"; status = "Fail"; }

        String resultStatus = (total >= 50) ? "PASS" : "FAIL";

        // REDESIGNED UNIFIED OUTPUT
        System.out.println("\n============================================");
        System.out.println("            STUDENT FINAL REPORT            ");
        System.out.println("============================================");
        System.out.printf(" Name    : %-15s Course : %-10s%n", name, course);
        System.out.println("--------------------------------------------");
        System.out.printf(" Midexam (30) : %-6.1f Project (30) : %-6.1f%n", midexam, project);
        System.out.printf(" Final(40): %-6.1f Total Score  : %-6.2f%n", finalExam, total);
        System.out.println("--------------------------------------------");
        System.out.printf(" Grade   : %-6s Status       : %-10s%n", grade, status);
        System.out.println(" Result  : " + resultStatus);
        System.out.println("============================================");
    }
}