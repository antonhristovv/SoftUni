package E03ShoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> peopleInfo = new LinkedHashMap<>();
        Map<String, Product> productsInfo = new HashMap<>();

        String[] people = scanner.nextLine().split(";");
        for (String personInfo : people) {
            String[] personData = personInfo.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);
            try {
                Person person = new Person(name, money);
                peopleInfo.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String[] allProducts = scanner.nextLine().split(";");
        for (String productInfo : allProducts) {
            String[] productData = productInfo.split("=");
            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);
            try {
                Product product = new Product(name, cost);
                productsInfo.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];
            try {
                Person person = peopleInfo.get(personName);
                Product product = productsInfo.get(productName);
                person.buyProduct(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }
        peopleInfo.values().forEach(System.out::println);
    }
}

