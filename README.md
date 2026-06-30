# Student Management System

A Java-based Student Management System built using JDBC and MySQL.

## Features

* Add new students
* View all students
* Search student by ID
* Update student details
* Delete student records
* Count total students
* Sort students by name
* Input validation

## Technologies Used

* Java
* JDBC
* MySQL
* Eclipse IDE
* Git & GitHub

## Database Structure

Table: `students`

| Column | Type                              |
| ------ | --------------------------------- |
| id     | INT (Primary Key, Auto Increment) |
| name   | VARCHAR(100)                      |
| age    | INT                               |
| course | VARCHAR(100)                      |
| email  | VARCHAR(100)                      |

## Project Structure

src/
└── com.sms

* DBConnection.java
* Student.java
* StudentDAO.java
* Main.java

## How to Run

1. Install MySQL and create the database.
2. Add MySQL Connector/J to the project.
3. Update database credentials in `DBConnection.java`.
4. Run `Main.java`.

## Future Improvements

* GUI integration
* Better validation
* Search by name
* Export student data
* Authentication system

## Screenshots

### Main Menu - Screenshot 1

### Add Student - Screenshot 1

### View Students - Screenshot 2

### Database Table - Screenshot 3
