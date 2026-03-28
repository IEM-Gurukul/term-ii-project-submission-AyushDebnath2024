import java.time.LocalDate;

public class Attendance {
    private final int studentId;
    private final LocalDate date;
    private final boolean present;

    public Attendance(int studentId, LocalDate date, boolean present) {
        this.studentId = studentId;
        this.date = date;
        this.present = present;
    }

    public int getStudentId() { return studentId; }
    public LocalDate getDate() { return date; }
    public boolean isPresent() { return present; }
}