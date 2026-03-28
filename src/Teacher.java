public class Teacher extends User {

    public Teacher(String username, String password) {
        super(username, password);
    }

    public void markAttendance(AttendanceManager manager, int studentId, String day, boolean present) {
    manager.getAttendance().markAttendance(studentId, day, present);

    }
}
