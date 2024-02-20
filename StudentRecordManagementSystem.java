import java.util.Scanner;

class Student {
    // Individual variables to store student information
    private int id;
    private String name;
    private int age;
    private double grade;

    // Constructor to initialize student information
    public Student(int id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getter methods for accessing student information
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    // Setter method to update student information
    public void updateStudent(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------------");
    }
}

class StudentManagement {
    // Static variables for storing total number of students and student list
    private static int totalStudents = 0;
    private static Student[] students = new Student[100];

    // Method to add a new student
    public static void addStudent(String name, int age, double grade) {
        Student newStudent = new Student(++totalStudents, name, age, grade);
        students[totalStudents - 1] = newStudent;
        System.out.println("Student added successfully!");
    }

    // Method to update student information
    public static void updateStudent(int id, String name, int age, double grade) {
        for (Student student : students) {
            if (student != null && student.getId() == id) {
                student.updateStudent(name, age, grade);
                System.out.println("Student information updated successfully!");
                return;
            }
        }
        System.out.println("Student ID not found!");
    }

    // Method to view all student details
    public static void viewStudentDetails() {
        if (totalStudents == 0) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("Student Details:");
        for (Student student : students) {
            if (student != null) {
                student.displayDetails();
            }
        }
    }
}

public class StudentRecordManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Record Management System");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter student grade: ");
                    double grade = scanner.nextDouble();
                    StudentManagement.addStudent(name, age, grade);
                    break;
                case 2:
                    System.out.print("Enter student ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    double newGrade = scanner.nextDouble();
                    StudentManagement.updateStudent(idToUpdate, newName, newAge, newGrade);
                    break;
                case 3:
                    StudentManagement.viewStudentDetails();
                    break;
                case 4:
                    System.out.println("Exiting Student Record Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
