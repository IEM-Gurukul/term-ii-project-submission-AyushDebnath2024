public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    public void addStudent(AttendanceManager manager, Student s) {
        manager.addStudent(s);
    }

    public void removeStudent(AttendanceManager manager, int id) {
        manager.removeStudent(id);
    }
}