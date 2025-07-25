import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0;
        double total = 0;
        for (double g : grades) total += g;
        return total / grades.size();
    }

    public double getHighest() {
        if (grades.isEmpty()) return 0;
        double max = Double.MIN_VALUE;
        for (double g : grades) {
            if (g > max) max = g;
        }
        return max;
    }

    public double getLowest() {
        if (grades.isEmpty()) return 0;
        double min = Double.MAX_VALUE;
        for (double g : grades) {
            if (g < min) min = g;
        }
        return min;
    }
}
