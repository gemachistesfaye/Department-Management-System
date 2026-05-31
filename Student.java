package project1;


public class Student extends Person {

    // ─── Grade Fields ─────────────────────────────────────────────────────────────
    private double  midExam;
    private double  project;
    private double  finalExam;
    private boolean marksSet = false;   

    // ─── Constructor ─────────────────────────────────────────────────────────────

    public Student(int id, String name, String sex, int age,
                   String departmentName, Address address, String course) {
        super(id, name, sex, age, departmentName, address, course);
    }

    // ─── Marks Setter ────────────────────────────────────────────────────────────

  
    public boolean setMarks(double midExam, double project, double finalExam) {
        if (midExam   < 0 || midExam   > 30 ||
            project   < 0 || project   > 30 ||
            finalExam < 0 || finalExam > 40) {
            System.err.println("Error: Marks out of range! "
                    + "(Mid/Project max 30, Final max 40)");
            return false;
        }
        this.midExam   = midExam;
        this.project   = project;
        this.finalExam = finalExam;
        this.marksSet  = true;
        return true;
    }

    // ─── Grade Calculation Helpers ────────────────────────────────────────────────

   
    public double calculateTotal() {
        return midExam + project + finalExam;
    }

    /**
     * Returns the letter grade for a given total score.
     */
    public String getLetterGrade(double total) {
        if      (total >= 90) return "A+";
        else if (total >= 85) return "A";
        else if (total >= 80) return "A-";
        else if (total >= 75) return "B+";
        else if (total >= 70) return "B";
        else if (total >= 65) return "B-";
        else if (total >= 60) return "C+";
        else if (total >= 50) return "C";
        else if (total >= 45) return "D";
        else                  return "F";
    }

    /**
     * Returns the descriptive status for a given total score.
     */
    public String getStatus(double total) {
        if      (total >= 85) return "Excellent";
        else if (total >= 75) return "Very Good";
        else if (total >= 65) return "Good";
        else if (total >= 50) return "Satisfactory";
        else if (total >= 45) return "Weak";
        else                  return "Fail";
    }

    // ─── Display Methods ──────────────────────────────────────────────────────────

    
    @Override
    public void displayInfo() {
        System.out.println("\n===== Student Information =====");
        displayPersonFields();
        System.out.println("==============================");
    }

    
    public void displayGrade() {
        if (!marksSet) {
            System.err.println("Marks have not been set for this student yet!");
            return;
        }

        double total       = calculateTotal();
        String letterGrade = getLetterGrade(total);
        String status      = getStatus(total);
        String result      = (total >= 50) ? "PASS" : "FAIL";

        System.out.println("\n============================================");
        System.out.println("          STUDENT FINAL REPORT              ");
        System.out.println("============================================");
        System.out.printf(" Name    : %-18s ID : %d%n", getName(), getId());
        System.out.printf(" Course  : %-18s%n", getCourse());
        System.out.println("--------------------------------------------");
        System.out.printf(" Mid Exam   (max 30) : %.1f%n", midExam);
        System.out.printf(" Project    (max 30) : %.1f%n", project);
        System.out.printf(" Final Exam (max 40) : %.1f%n", finalExam);
        System.out.println("--------------------------------------------");
        System.out.printf(" Total Score : %.2f / 100%n", total);
        System.out.printf(" Grade       : %s%n", letterGrade);
        System.out.printf(" Status      : %s%n", status);
        System.out.printf(" Result      : %s%n", result);
        System.out.println("============================================");
    }

    // ─── Getters (for reporting/sorting) ─────────────────────────────────────────

    public double  getMidExam()   { return midExam; }
    public double  getProject()   { return project; }
    public double  getFinalExam() { return finalExam; }
    public boolean isMarksSet()   { return marksSet; }
}
