import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student findStudentByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) return s;
        }
        return null;
    }

    public double getOverallAverage() {
        double total = 0;
        int count = 0;
        for (Student s : students) {
            for (double g : s.getGrades()) {
                total += g;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    public Student getTopStudent() {
        Student top = null;
        double highestAvg = 0;
        for (Student s : students) {
            if (s.getAverage() > highestAvg) {
                highestAvg = s.getAverage();
                top = s;
            }
        }
        return top;
    }

    public Student getLowestStudent() {
        Student low = null;
        double lowestAvg = Double.MAX_VALUE;
        for (Student s : students) {
            if (!s.getGrades().isEmpty() && s.getAverage() < lowestAvg) {
                lowestAvg = s.getAverage();
                low = s;
            }
        }
        return low;
    }

    public void showSummary() {
        if (students.isEmpty()) {
            System.out.println("No student data to display.");
            return;
        }

        System.out.println("\n====== Student Summary Report ======");
        for (Student s : students) {
            System.out.printf("Name: %-20s | Avg: %.2f | High: %.2f | Low: %.2f\n",
                s.getName(), s.getAverage(), s.getHighest(), s.getLowest());
        }

        System.out.printf("\nOverall Average: %.2f\n", getOverallAverage());

        Student top = getTopStudent();
        if (top != null)
            System.out.printf("Top Student: %s (%.2f avg)\n", top.getName(), top.getAverage());

        Student low = getLowestStudent();
        if (low != null)
            System.out.printf("Lowest Student: %s (%.2f avg)\n", low.getName(), low.getAverage());

        System.out.println("====================================");
    }
}
