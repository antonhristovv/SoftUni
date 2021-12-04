package Exercise.E04FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            if (tokens.length == 3) {
                String group = tokens[2];
                Rebel rebel = new Rebel(name, age, group);
                buyers.putIfAbsent(name, rebel);
            } else {
                String id = tokens[2];
                String birthDate = tokens[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                buyers.putIfAbsent(name, citizen);
            }
        }
        String name = scanner.nextLine();
        while (!"End".equals(name)) {
            if (buyers.containsKey(name)) {
                buyers.get(name).buyFood();
            }
            name = scanner.nextLine();
        }
        int totalFood = buyers.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }
}
