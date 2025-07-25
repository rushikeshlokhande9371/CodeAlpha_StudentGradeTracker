import java.util.Scanner;

public class MainApp {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        System.out.println("===== Welcome to Student Grade Tracker =====");
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    addNewStudent();
                    break;
                case "2":
                    addGradeToStudent();
                    break;
                case "3":
                    manager.showSummary();
                    break;
                case "4":
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Add New Student");
        System.out.println("2. Add Grade to Existing Student");
        System.out.println("3. View Summary Report");
        System.out.println("4. Exit");
    }

    private static void addNewStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        if (manager.findStudentByName(name) != null) {
            System.out.println("Student already exists.");
            return;
        }
        Student newStudent = new Student(name);
        manager.addStudent(newStudent);
        System.out.println("Student added successfully!");
    }

    private static void addGradeToStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = manager.findStudentByName(name);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter grade (0-100): ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // clear buffer

        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade.");
        } else {
            student.addGrade(grade);
            System.out.println("Grade added successfully!");
        }
    }
}