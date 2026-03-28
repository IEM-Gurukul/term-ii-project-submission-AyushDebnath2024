import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class AttendanceManager {
    private List<Student> students = new ArrayList<>();
    private Attendance attendance = new Attendance();

    
    public void addStudent(Student s) {
        if (students.stream().anyMatch(existing -> existing.getId() == s.getId())) {
            System.out.println("Student ID " + s.getId() + " already exists.");
            return;
        }
        students.add(s);
        System.out.println("Student added successfully!");
    }

    
    public void removeStudent(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    
    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {
            System.out.println(s.getId() + " - " + s.getName() + " (" + s.getCourse() + ")");
        }
    }

    
    public void markAttendance(int studentId, String day, boolean isPresent) {
        if (students.stream().noneMatch(s -> s.getId() == studentId)) {
            System.out.println("Student ID " + studentId + " not found.");
            return;
        }

        attendance.markAttendance(studentId, day, isPresent);
        System.out.println("Attendance marked for ID " + studentId + " on " + day);
    }

    public void generateReport() {
        if (students.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        for (Student s : students) {

            double overall = attendance.getPercentage(s.getId());
            double weekly = attendance.getWeeklyPercentage(s.getId());

            System.out.println("\nStudent: " + s.getName());
            System.out.println("Overall Attendance: " + overall + "%");
            System.out.println("Weekly Attendance: " + weekly + "%");

            if (weekly < 75) {
                System.out.println("⚠ Low Weekly Attendance!");
            }
        }
    }

    
    public void generateIndividualReport(int studentId) {

        Student found = null;

        for (Student s : students) {
            if (s.getId() == studentId) {
                found = s;
                break;
            }
        }

        if (found == null) {
            System.out.println("Student not found!");
            return;
        }

        double overall = attendance.getPercentage(studentId);
        double weekly = attendance.getWeeklyPercentage(studentId);

        System.out.println("\n===== Individual Report =====");
        System.out.println("ID: " + found.getId());
        System.out.println("Name: " + found.getName());
        System.out.println("Course: " + found.getCourse());
        System.out.println("Overall Attendance: " + overall + "%");
        System.out.println("Weekly Attendance: " + weekly + "%");

        if (weekly < 75) {
            System.out.println("⚠ Low Attendance Warning!");
        }
    }

    public Attendance getAttendance() {
        return attendance;
    }

    
    public void saveStudents() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"))) {

            for (Student s : students) {
                bw.write(s.toFileString());
                bw.newLine();
            }

            System.out.println("Students saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving students!");
        }
    }

    
    public void loadStudents() {

        File file = new File("students.txt");

        if (!file.exists()) {
            System.out.println("No previous student data found.");
            return;
        }

        students.clear(); // IMPORTANT: avoid duplicate loading

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length != 3) continue; // safety check

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String course = parts[2];

                students.add(new Student(id, name, course));
            }

            System.out.println("Students loaded successfully!");

        } catch (IOException e) {
            System.out.println("Error loading students!");
        }
    }
}
