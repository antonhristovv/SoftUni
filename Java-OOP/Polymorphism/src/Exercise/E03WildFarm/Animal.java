package Exercise.E03WildFarm;

public abstract class Animal {
    private String name;
    private String type;
    private Double weight;
    private Integer foodEaten;

    public Animal(String name, String type, Double weight) {
        this.setName(name);
        this.setType(type);
        this.setWeight(weight);
        this.foodEaten = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract void makeSound();
    public void eat(Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }

}
