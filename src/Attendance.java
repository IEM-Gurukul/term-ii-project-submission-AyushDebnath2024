import java.util.HashMap;
import java.io.*;

public class Attendance {

    
    private HashMap<Integer, HashMap<String, Boolean>> records = new HashMap<>();

    
    public void markAttendance(int studentId, String day, boolean isPresent) {
        records.putIfAbsent(studentId, new HashMap<>());
        records.get(studentId).put(day, isPresent);
    }

    
    public double getPercentage(int studentId) {
        HashMap<String, Boolean> studentRecord = records.get(studentId);

        if (studentRecord == null || studentRecord.isEmpty()) return 0;

        int present = 0;

        for (boolean status : studentRecord.values()) {
            if (status) present++;
        }

        return (present * 100.0) / studentRecord.size();
    }

    
    public double getWeeklyPercentage(int studentId) {
        HashMap<String, Boolean> studentRecord = records.get(studentId);

        if (studentRecord == null) return 0;

        String[] weekDays = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int present = 0;
        int total = 0;

        for (String day : weekDays) {
            if (studentRecord.containsKey(day)) {
                total++;
                if (studentRecord.get(day)) {
                    present++;
                }
            }
        }

        if (total == 0) return 0;

        return (present * 100.0) / total;
    }

    
    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("attendance.txt"))) {

            for (int studentId : records.keySet()) {
                for (String day : records.get(studentId).keySet()) {
                    boolean present = records.get(studentId).get(day);
                    bw.write(studentId + "," + day + "," + present);
                    bw.newLine();
                }
            }

            System.out.println("Attendance saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving attendance!");
        }
    }

    
    public void loadFromFile() {

        File file = new File("attendance.txt");

        if (!file.exists()) {
            System.out.println("No previous attendance data found.");
            return;
        }

        records.clear(); // IMPORTANT: avoid duplicate loading

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length != 3) continue; // safety check

                int id = Integer.parseInt(parts[0]);
                String day = parts[1];
                boolean present = Boolean.parseBoolean(parts[2]);

                // Direct insert (avoid extra logic)
                records.putIfAbsent(id, new HashMap<>());
                records.get(id).put(day, present);
            }

            System.out.println("Attendance loaded successfully!");

        } catch (IOException e) {
            System.out.println("Error loading attendance!");
        }
    }
}
