package Lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class L07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, ArrayList<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String town = input[2];
            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country, new ArrayList<>());
            continents.get(continent).get(country).add(town);
        }
        for (Map.Entry<String, Map<String, ArrayList<String>>> continent : continents.entrySet()) {
            System.out.println(continent.getKey() + ":");
            for (Map.Entry<String, ArrayList<String>> countryWithTowns : continent.getValue().entrySet()) {
                System.out.printf("  %s -> ", countryWithTowns.getKey());
                String output = String.join(", ", countryWithTowns.getValue());
                System.out.println(output);
            }
        }
    }
}
