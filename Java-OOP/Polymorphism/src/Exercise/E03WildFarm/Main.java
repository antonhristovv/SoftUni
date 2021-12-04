package Exercise.E03WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String animalInfo = scanner.nextLine();
        while (!"End".equals(animalInfo)) {
            Animal animal = createAnimal(animalInfo);

            String foodInfo = scanner.nextLine();
            Food food = generateFood(foodInfo);

            animal.makeSound();
            animal.eat(food);
            animals.add(animal);
            animalInfo = scanner.nextLine();
        }
        animals.forEach(System.out::println);
    }

    private static Food generateFood(String foodInfo) {
        String[] tokens = foodInfo.split("\\s+");
        String foodType = tokens[0];
        Integer quantity = Integer.parseInt(tokens[1]);
        switch (foodType) {
            case "Meat":
                return new Meat(quantity);
            case "Vegetable":
                return new Vegetable(quantity);
            default:
                throw new IllegalArgumentException("No such food");
        }
    }

    private static Animal createAnimal(String animalInfo) {
        String[] tokens = animalInfo.split("\\s+");
        String animalType = tokens[0];
        String animalName = tokens[1];
        Double animalWeight = Double.parseDouble(tokens[2]);
        String animalLivingRegion = tokens[3];
        switch (animalType) {
            case "Cat":
                String catBreed = tokens[4];
                return new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
            case "Mouse":
                return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
            default:
                throw new IllegalArgumentException("No such animal");
        }
    }
}
