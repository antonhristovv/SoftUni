package Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class L04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> valuesWithOccurrences = new LinkedHashMap<>();
        for (double value : values) {
            if (valuesWithOccurrences.containsKey(value)) {
                valuesWithOccurrences.put(value, valuesWithOccurrences.get(value) + 1);
            } else {
                valuesWithOccurrences.put(value, 1);
            }
        }
        for (Double key : valuesWithOccurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", key, valuesWithOccurrences.get(key));
        }
    }
}
