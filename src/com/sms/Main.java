package com.sms;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Count Students");
            System.out.println("7. Sort Students by Name");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

            case 1:
                System.out.print("Enter name: ");
                String name = sc.nextLine();

                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty!");
                    break;
                }

                System.out.print("Enter age: ");
                int age = sc.nextInt();
                sc.nextLine();

                if (age <= 0) {
                    System.out.println("Age must be greater than 0!");
                    break;
                }

                System.out.print("Enter course: ");
                String course = sc.nextLine();

                System.out.print("Enter email: ");
                String email = sc.nextLine();

                if (!email.contains("@") || !email.contains(".")) {
                    System.out.println("Invalid email format!");
                    break;
                }

                Student student = new Student(name, age, course, email);
                dao.addStudent(student);
                break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    int searchId = sc.nextInt();

                    dao.searchStudent(searchId);
                    break;
                    
                case 4:
                    System.out.print("Enter student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new course: ");
                    String newCourse = sc.nextLine();

                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();

                    dao.updateStudent(updateId, newName, newAge, newCourse, newEmail);
                    break;
                    
                case 5:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteStudent(deleteId);
                    break;

                case 6:
                    dao.countStudents();
                    break;
                    
                case 7:
                    dao.sortStudentsByName();
                    break;
                
                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}