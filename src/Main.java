import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AttendanceManager manager = new AttendanceManager();
        Admin admin = new Admin("admin", "1234");
        Teacher teacher = new Teacher("teacher", "1234");

        manager.loadStudents();
        manager.getAttendance().loadFromFile();

        Scanner sc = new Scanner(System.in);

        System.out.println("==== LOGIN ====");
        System.out.print("Enter username: ");
        String user = sc.next();
        System.out.print("Enter password: ");
        String pass = sc.next();

        boolean isAdmin = admin.login(user, pass);
        boolean isTeacher = teacher.login(user, pass);

        if (!isAdmin && !isTeacher) {
            System.out.println("Invalid login!");
            return;
        }

        while (true) {

            System.out.println("\n==== MENU ====");

            if (isAdmin) {
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
            }

            System.out.println("3. View Students");
            System.out.println("4. Mark Attendance");
            System.out.println("5. Generate Report");
            System.out.println("6. Individual Report");
            System.out.println("7. Save & Exit");

            try {
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        if (isAdmin) {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter Course: ");
                            String course = sc.nextLine();

                            admin.addStudent(manager, new Student(id, name, course));
                        }
                        break;

                    case 2:
                        if (isAdmin) {
                            System.out.print("Enter ID to remove: ");
                            int rid = sc.nextInt();
                            admin.removeStudent(manager, rid);
                        }
                        break;

                    case 3:
                        manager.showStudents();
                        break;

                    case 4:
                        System.out.print("Enter Student ID: ");
                        int sid = sc.nextInt();

                        System.out.print("Enter Day (Mon/Tue/...): ");
                        String day = sc.next();

                        System.out.print("Present (true/false): ");
                        boolean present = sc.nextBoolean();

                        teacher.markAttendance(manager, sid, day, present);
                        break;

                    case 5:
                        manager.generateReport();
                        break;

                    case 6:
                        System.out.print("Enter Student ID: ");
                        int iid = sc.nextInt();
                        manager.generateIndividualReport(iid);
                        break;

                    case 7:
                        manager.saveStudents();
                        manager.getAttendance().saveToFile();
                        System.out.println("Data saved successfully!");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // consume invalid input
            }
        }
    }
}
