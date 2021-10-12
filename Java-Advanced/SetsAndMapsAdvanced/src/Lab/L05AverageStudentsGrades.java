package Lab;

import java.util.*;

public class L05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<Double>> studentsWithGrades = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String studentName = input.split("\\s+")[0];
            double studentGrade = Double.parseDouble(input.split("\\s+")[1]);
            studentsWithGrades.putIfAbsent(studentName, new ArrayList<>());
            studentsWithGrades.get(studentName).add(studentGrade);
        }
        for (Map.Entry<String, ArrayList<Double>> entry : studentsWithGrades.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Double grade : entry.getValue()) {
                System.out.printf("%.2f ",grade);
            }
            double average = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                average += entry.getValue().get(i);
            }
            average /= entry.getValue().size();
            System.out.printf("(avg: %.2f)%n", average);
        }
    }
}
