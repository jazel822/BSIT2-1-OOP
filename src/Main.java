import java.util.Scanner;

public class Main {
    // Simple data holder for a student
    static class Student {
        int id;
        String name;
        int age;
        String course;
        double grade;
        boolean enrolled;

        Student(int id, String name, int age, String course, double grade, boolean enrolled) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.course = course;
            this.grade = grade;
            this.enrolled = enrolled;
        }
    }

    public static void main(String[] args) {
        final int MAX_STUDENTS = 10;
        Student[] students = new Student[MAX_STUDENTS];
        int count = 0;

        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            // Menu
            System.out.println("Student Information System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by ID");
            System.out.println("4. View Statistics");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number 1-5.");
                continue;
            }

            switch (choice) {
                case 1:
                    // Add Student
                    if (count >= MAX_STUDENTS) {
                        System.out.println("Cannot add more students. The list is full.");
                        break;
                    }
                    System.out.print("Enter ID (int): ");
                    int id = readInt(sc);
                    System.out.print("Enter full name: ");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }
                    System.out.print("Enter age (positive int): ");
                    int age = readInt(sc);
                    if (age <= 0) {
                        System.out.println("Age must be positive.");
                        break;
                    }
                    System.out.print("Enter course: ");
                    String course = sc.nextLine().trim();
                    if (course.isEmpty()) {
                        System.out.println("Course cannot be empty.");
                        break;
                    }
                    System.out.print("Enter grade (0-100): ");
                    double grade = readDouble(sc);
                    if (grade < 0 || grade > 100) {
                        System.out.println("Grade must be between 0 and 100.");
                        break;
                    }
                    System.out.print("Enrolled? (true/false): ");
                    boolean enrolled = readBoolean(sc);

                    Student s = new Student(id, name, age, course, grade, enrolled);
                    students[count] = s;
                    count++;
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    // View All Students
                    if (count == 0) {
                        System.out.println("No students yet.");
                    } else {
                        System.out.printf("%-5s %-20s %-5s %-15s %-6s %-12s%n",
                                "ID", "Name", "Age", "Course", "Grade", "Status");
                        for (int i = 0; i < count; i++) {
                            Student st = students[i];
                            String standing = (st.grade >= 90) ? "Dean's Lister" :
                                    (st.grade >= 75) ? "Passed" : "Failed";
                            System.out.printf("%-5d %-20s %-5d %-15s %-6.2f %-12s%n",
                                    st.id, st.name, st.age, st.course, st.grade, standing);
                        }
                    }
                    break;

                case 3:
                    // Search by ID
                    if (count == 0) {
                        System.out.println("No students to search.");
                    } else {
                        System.out.print("Enter ID to search: ");
                        int searchId = readInt(sc);
                        boolean found = false;
                        for (int i = 0; i < count; i++) {
                            if (students[i].id == searchId) {
                                Student st = students[i];
                                System.out.println("Student found:");
                                System.out.println("ID: " + st.id);
                                System.out.println("Name: " + st.name);
                                System.out.println("Age: " + st.age);
                                System.out.println("Course: " + st.course);
                                System.out.println("Grade: " + st.grade);
                                System.out.println("Enrolled: " + st.enrolled);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Student with ID " + searchId + " not found.");
                        }
                    }
                    break;

                case 4:
                    // View Statistics
                    if (count == 0) {
                        System.out.println("No students to compute statistics.");
                    } else {
                        int total = count;
                        double sum = 0;
                        double topGrade = -1;
                        String topName = "";
                        int topIndex = -1;

                        for (int i = 0; i < count; i++) {
                            sum += students[i].grade;
                            if (students[i].grade > topGrade) {
                                topGrade = students[i].grade;
                                topName = students[i].name;
                                topIndex = i;
                            }
                        }
                        double avg = sum / total;
                        System.out.println("Total students: " + total);
                        System.out.printf("Average grade: %.2f%n", avg);
                        if (topIndex >= 0) {
                            System.out.println("Top student: " + topName + " with grade " + topGrade);
                        }
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1-5.");
            }

            System.out.println(); // blank line for readability
        }

        sc.close();
    }

    // Helpers for simple input parsing with basic validation
    private static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid integer. Please try again: ");
            }
        }
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please try again: ");
            }
        }
    }

    private static boolean readBoolean(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("true") || s.equals("t") || s.equals("yes") || s.equals("y")) return true;
            if (s.equals("false") || s.equals("f") || s.equals("no") || s.equals("n")) return false;
            System.out.print("Enter true/false: ");
        }
    }
}