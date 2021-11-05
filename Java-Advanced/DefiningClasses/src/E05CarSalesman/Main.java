package E05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();
        int engineCount = Integer.parseInt(scanner.nextLine());
        while (engineCount-- > 0) {
            //"{Model} {Power} {Displacement} {Efficiency}"
            String[] engineData = scanner.nextLine().split("\\s+");
            Engine engine;
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            if (engineData.length == 4) {
                int displacement = Integer.parseInt(engineData[2]);
                String efficiency = engineData[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (engineData.length == 2) {
                engine = new Engine(model, power);
            } else {
                try {
                    int displacement = Integer.parseInt(engineData[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException e) {
                    String efficiency = engineData[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            engines.put(model, engine);
        }
        int carsCount = Integer.parseInt(scanner.nextLine());
        while (carsCount-- > 0) {
            //{Model} {Engine} {Weight} {Color}
            Car car;
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            String engineModel = carData[1];
            Engine engine = engines.get(engineModel);
            if (carData.length == 4) {
                int weight = Integer.parseInt(carData[2]);
                String color = carData[3];
                car = new Car(model, engine, weight, color);
            } else if (carData.length == 2) {
                car = new Car(model, engine);
            } else {
                try {
                    int weight = Integer.parseInt(carData[2]);
                    car = new Car(model, engine, weight);
                } catch (NumberFormatException e) {
                    String color = carData[2];
                    car = new Car(model, engine, color);
                }
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
