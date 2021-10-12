package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class E03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> periodicElements = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            periodicElements.addAll(Arrays.asList(input));
        }
        periodicElements.forEach(el -> System.out.print(el + " "));
    }
}
