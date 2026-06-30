package com.sms;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_management",
                "root",
                "MaYaNk@2410"
            );

            System.out.println("Connected successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}