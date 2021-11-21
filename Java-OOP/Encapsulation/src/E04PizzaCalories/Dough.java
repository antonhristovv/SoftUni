package E04PizzaCalories;

import java.util.Map;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    private final double baseCalories = 2.0;

    //Dough Modifiers
    //    • White – 1.5;
    //    • Wholegrain – 1.0;
    //    • Crispy – 0.9;
    //    • Chewy – 1.1;
    //    • Homemade – 1.0;

    private final Map<String, Double> validFlourTypes = Map.of(
            "White", 1.5,
            "Wholegrain", 1.0);

    private final Map<String, Double> validBakingTechniques = Map.of(
            "Crispy", 0.9,
            "Chewy", 1.1,
            "Homemade", 1.0);

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        if (!validFlourTypes.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!validBakingTechniques.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        double calories = this.baseCalories * this.weight;
        calories *= this.validFlourTypes.get(this.flourType);
        calories *= this.validBakingTechniques.get(this.bakingTechnique);
        return calories;
    }
}
