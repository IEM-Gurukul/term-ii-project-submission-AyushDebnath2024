[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# PCCCS495 – Term II Project

Student Attendance Management System

---

1 .Problem Statement
Managing student attendance manually is inefficient and prone to human errors. Teachers often face difficulty in maintaining records, updating attendance, and retrieving past data. This project proposes a Student Attendance Management System that allows users to add students, mark attendance, and view attendance records efficiently. The system is designed using Java and OOP principles to ensure modularity and scalability. It minimizes paperwork, improves data accuracy, and simplifies the attendance tracking process.

2. Target User
Teachers
School/College Administrators
Educational Institutions

3. Core Features
Add Student Details
View Student List
Mark Attendance
View Attendance Records
Menu-driven Console Interface
Data handling using Collections

4. OOP Concepts Used

- Abstraction: Hides complex logic inside classes like AttendanceManager.
- Inheritance: Allows extension of base classes (e.g., Student from Person if implemented).
- Polymorphism: Data is protected using private variables and accessed via getters/setters.
- Exception Handling: Handles invalid inputs using try-catch blocks.
- Collections / Threads: ArrayList is used for dynamic data storage.

5. Proposed Architecture Description
The system follows a modular object-oriented architecture. It consists of multiple classes such as Main, Student, Attendance, and AttendanceManager.

Main Class: Handles user input and menu

Student Class: Stores student details

Attendance Class: Maintains attendance status

AttendanceManager: Controls all operations

The system uses collections for storing data and can be extended to file handling for persistence.

How to Run

Open the project in VS Code

Make sure Java JDK is installed

Open terminal

Compile the program:

javac Main.java

Run the program:

java Main
Use menu options to operate the system
