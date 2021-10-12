package Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> symbolsOccurrences = new TreeMap<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            symbolsOccurrences.putIfAbsent(currentChar, 0);
            symbolsOccurrences.put(currentChar, symbolsOccurrences.get(currentChar) + 1);
        }
        symbolsOccurrences.forEach((key, value) -> System.out.printf("%s: %d time/s%n", key, value));
    }
}
