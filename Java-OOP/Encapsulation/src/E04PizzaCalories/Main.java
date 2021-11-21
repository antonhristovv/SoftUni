package E04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Pizza {pizzaName} {numberOfToppings}
        String[] pizzaInfo = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);
        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);

            //Dough {flourType} {bakingTechnique} {weightInGrams}
            String[] doughInfo = scanner.nextLine().split("\\s+");
            String flourType = doughInfo[1];
            String bakingTechnique = doughInfo[2];
            int doughWeightInGrams = Integer.parseInt(doughInfo[3]);

            Dough dough = new Dough(flourType, bakingTechnique, doughWeightInGrams);
            pizza.setDough(dough);
            String input = scanner.nextLine();
            while (!"END".equals(input)) {
                //Topping {toppingType} {weightInGrams}
                String[] toppingInfo = input.split("\\s+");
                String toppingType = toppingInfo[1];
                int toppingWeightInGrams = Integer.parseInt(toppingInfo[2]);

                Topping topping = new Topping(toppingType, toppingWeightInGrams);
                pizza.addTopping(topping);
                input = scanner.nextLine();
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
