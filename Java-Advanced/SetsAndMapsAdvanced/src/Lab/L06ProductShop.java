package Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class L06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopsWithProducts = new TreeMap<>();
        String input = scanner.nextLine();
        while (!"Revision".equals(input)) {
            String[] tokens = input.split(",\\s+");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);
            shopsWithProducts.putIfAbsent(shop, new LinkedHashMap<>());
            shopsWithProducts.get(shop).put(product, price);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Double>> shop : shopsWithProducts.entrySet()) {
            System.out.println(shop.getKey() + "->");
            for (Map.Entry<String, Double> productAndPrice : shop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", productAndPrice.getKey(), productAndPrice.getValue());
            }
        }
    }
}
