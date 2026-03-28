import java.util.*;

public class AttendanceManager {
    private final List<Student> students = new ArrayList<>();
    private final List<Attendance> records = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void viewStudents() {
        for (Student s : students) {
            s.display();
        }
    }

    public void markAttendance(int id, boolean present) {
        records.add(new Attendance(id, java.time.LocalDate.now(), present));
    }

    public void showAttendance(int id) {
        for (Attendance a : records) {
            if (a.getStudentId() == id) {
                System.out.println(a.getDate() + " : " + (a.isPresent() ? "Present" : "Absent"));
            }
        }
    }
}
