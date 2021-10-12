package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resourcesAndQuantities = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"stop".equals(input)){
            int quantity = Integer.parseInt(scanner.nextLine());
            if (resourcesAndQuantities.containsKey(input)) {
                quantity += resourcesAndQuantities.get(input);
                resourcesAndQuantities.put(input, quantity);
            } else {
                resourcesAndQuantities.put(input, quantity);
            }
            input = scanner.nextLine();
        }
        resourcesAndQuantities.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
