package project1;


public class Teacher extends Person {

    // ─── Teacher-Specific Fields ──────────────────────────────────────────────────
    private String specialization;
    private int    yearsOfExperience;

    // ─── Constructor ─────────────────────────────────────────────────────────────

    public Teacher(int id, String name, String sex, int age,
                   String departmentName, Address address, String course,
                   String specialization, int yearsOfExperience) {
        super(id, name, sex, age, departmentName, address, course);
        this.specialization    = specialization;
        this.yearsOfExperience = yearsOfExperience;
    }

    // ─── Getters ─────────────────────────────────────────────────────────────────

    public String getSpecialization()    { return specialization; }
    public int    getYearsOfExperience() { return yearsOfExperience; }

    // ─── Display ─────────────────────────────────────────────────────────────────

    @Override
    public void displayInfo() {
        System.out.println("\n===== Teacher Information =====");
        displayPersonFields();
        System.out.println("Specialization  : " + specialization);
        System.out.println("Experience      : " + yearsOfExperience + " year(s)");
        System.out.println("==============================");
    }
}
