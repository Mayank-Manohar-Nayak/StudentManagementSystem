package com.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    public void addStudent(Student student) {
        String query = "INSERT INTO students(name, age, course, email) VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getEmail());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student added successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void viewStudents() {
        String query = "SELECT * FROM students";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getInt("age") + " | " +
                    rs.getString("course") + " | " +
                    rs.getString("email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateStudent(int id, String name, int age, String course, String email) {
        String query = "UPDATE students SET name=?, age=?, course=?, email=? WHERE id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setString(4, email);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchStudent(int id) {
        String query = "SELECT * FROM students WHERE id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Email: " + rs.getString("email"));
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void countStudents() {
        String query = "SELECT COUNT(*) AS total FROM students";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Total Students: " + rs.getInt("total"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sortStudentsByName() {
        String query = "SELECT * FROM students ORDER BY name ASC";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getInt("age") + " | " +
                    rs.getString("course") + " | " +
                    rs.getString("email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}