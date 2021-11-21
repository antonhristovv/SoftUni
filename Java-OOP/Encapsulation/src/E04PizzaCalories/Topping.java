package E04PizzaCalories;

import java.util.Map;

public class Topping {
    private String toppingType;
    private double weight;

    private final double baseCalories = 2.0;

    //Toppings Modifiers
    //    • Meat – 1.2;
    //    • Veggies – 0.8;
    //    • Cheese – 1.1;
    //    • Sauce – 0.9;

    private final Map<String, Double> validToppings = Map.of(
            "Meat", 1.2,
            "Veggies", 0.8,
            "Cheese", 1.1,
            "Sauce", 0.9);

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!validToppings.containsKey(toppingType)) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double calories = this.baseCalories * this.weight;
        calories *= this.validToppings.get(this.toppingType);
        return calories;
    }
}
