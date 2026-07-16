import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    static double[] cutoffs = {90, 80, 70, 60};

    public static String letterFor(double grade) {
        if (grade >= cutoffs[0]) {
            return "A";
        } else if (grade >= cutoffs[1]) {
            return "B";
        } else if (grade >= cutoffs[2]) {
            return "C";
        } else if (grade >= cutoffs[3]) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> roster = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add student");
            System.out.println("2. View all");
            System.out.println("3. Class average");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.next();
                System.out.print("Enter grade: ");
                double grade = sc.nextDouble();

                roster.add(new Student(name, grade));
                System.out.println("Student added.");

            } else if (choice == 2) {
                if (roster.isEmpty()) {
                    System.out.println("No students yet.");
                } else {
                    for (Student s : roster) {
                        System.out.println(s.name + " " + s.grade + " " + letterFor(s.grade));
                    }
                }

            } else if (choice == 3) {
                if (roster.isEmpty()) {
                    System.out.println("No students yet.");
                } else {
                    double total = 0;
                    for (Student s : roster) {
                        total += s.grade;
                    }
                    double average = total / roster.size();
                    System.out.printf("Class average: %.2f%n", average);
                }

            } else if (choice == 4) {
                running = false;
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}