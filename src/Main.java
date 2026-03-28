import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AttendanceManager manager = new AttendanceManager();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Mark Attendance");
                System.out.println("4. View Attendance");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {

                    case 1: {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // consume newline

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Dept: ");
                        String dept = sc.nextLine();

                        manager.addStudent(new Student(id, name, dept));
                        break;
                    }

                    case 2: {
                        manager.viewStudents();
                        break;
                    }

                    case 3: {
                        System.out.print("Enter Student ID: ");
                        int sid = sc.nextInt();

                        System.out.print("Present (true/false): ");
                        boolean p = sc.nextBoolean();

                        manager.markAttendance(sid, p);
                        break;
                    }

                    case 4: {
                        System.out.print("Enter Student ID: ");
                        int vid = sc.nextInt();
                        manager.showAttendance(vid);
                        break;
                    }

                    case 5: {
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    }

                    default: {
                        System.out.println("Invalid choice! Try again.");
                    }
                }
            }
        }
    }
}
