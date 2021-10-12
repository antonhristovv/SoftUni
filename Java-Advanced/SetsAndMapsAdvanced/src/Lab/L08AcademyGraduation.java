package Lab;

import java.util.*;
import java.util.stream.Collectors;

public class L08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> graduationList = new TreeMap<>();
        while (n-- > 0) {
            String student = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
            graduationList.putIfAbsent(student, grades);

        }
        for (Map.Entry<String, List<Double>> student : graduationList.entrySet()) {
            //TODO: find out why it is not calculating average correct
            double avgGrade = 0;
            for (Double grade : student.getValue()) {
                avgGrade += grade / student.getValue().size();
            }
            avgGrade /= student.getValue().size();
            System.out.printf("%s is graduated with %f%n", student.getKey(), avgGrade);
        }
    }
}
