package project1;

import java.util.Scanner;

public class InputHelper {

    private InputHelper() {
      
    }

    // ─── Integer Input ────────────────────────────────────────────────────────────

   
    public static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.err.println("  Invalid! Please enter a number.");
            sc.next();
            System.out.print(prompt);
        }
        int value = sc.nextInt();
        sc.nextLine(); 
        return value;
    }


    public static int readIntInRange(Scanner sc, String prompt, int min, int max) {
        int value;
        do {
            value = readInt(sc, prompt);
            if (value < min || value > max) {
                System.err.println("  Out of range! Enter a value between "
                        + min + " and " + max + ".");
            }
        } while (value < min || value > max);
        return value;
    }

    // ─── Double Input ─────────────────────────────────────────────────────────────

   
    public static double readDouble(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.err.println("  Invalid! Please enter a number.");
            sc.next();
            System.out.print(prompt);
        }
        double value = sc.nextDouble();
        sc.nextLine(); 
        return value;
    }

    
    public static double readDoubleInRange(Scanner sc, String prompt, double min, double max) {
        double value;
        do {
            value = readDouble(sc, prompt);
            if (value < min || value > max) {
                System.err.println("  Out of range! Enter a value between "
                        + min + " and " + max + ".");
            }
        } while (value < min || value > max);
        return value;
    }

    // ─── String Input ─────────────────────────────────────────────────────────────

   
    public static String readAlpha(Scanner sc, String prompt) {
        System.out.print(prompt);
        String value = sc.nextLine();
        while (!value.matches("[a-zA-Z ]+")) {
            System.err.println("  Invalid! Letters only, no numbers or special characters.");
            System.out.print(prompt);
            value = sc.nextLine();
        }
        return value.trim();
    }

    
    public static String readString(Scanner sc, String prompt) {
        System.out.print(prompt);
        String value = sc.nextLine().trim();
        while (value.isEmpty()) {
            System.err.println("  Input cannot be empty.");
            System.out.print(prompt);
            value = sc.nextLine().trim();
        }
        return value;
    }

    // ─── Yes/No Continue  ───────────────────────────────────────────────────

    
    public static int askContinue(Scanner sc) {
        int cont;
        do {
            cont = readInt(sc, "\nContinue? (1 = Yes, 2 = No): ");
            if (cont != 1 && cont != 2) {
                System.err.println("  Enter 1 or 2 only.");
            }
        } while (cont != 1 && cont != 2);
        return cont;
    }
}
