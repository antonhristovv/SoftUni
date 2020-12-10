import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T33NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\|");
            String model = carInfo[0];
            int mileage = Integer.parseInt(carInfo[1]);
            int fuel = Integer.parseInt(carInfo[2]);
            cars.put(model, new Car(model, mileage, fuel));
        }
        String input = scanner.nextLine();
        while (!"Stop".equals(input)) {
            String[] commands = input.split(" : ");
            String command = commands[0];
            String model = commands[1];
            int carFuel = cars.get(model).getFuel();
            int carMileage = cars.get(model).getMileage();
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(commands[2]);
                    int fuel = Integer.parseInt(commands[3]);
                    if (fuel >= carFuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        cars.get(model).setFuel(carFuel - fuel);
                        carMileage += distance;
                        cars.get(model).setMileage(carMileage);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", model, distance, fuel);
                    }
                    if (carMileage >= 100000) {
                        System.out.printf("Time to sell the %s!%n", model);
                        cars.remove(model);
                    }
                    break;
                case "Refuel":
                    int refuel = Integer.parseInt(commands[2]);
                    if (carFuel + refuel > 75) {
                        refuel = 75 - carFuel;
                    }
                    cars.get(model).setFuel(carFuel + refuel);
                    System.out.printf("%s refueled with %d liters%n", model, refuel);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commands[2]);
                    if (carMileage - kilometers >= 10000) {
                        cars.get(model).setMileage(carMileage - kilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", model, kilometers);
                    } else {
                        cars.get(model).setMileage(10000);
                    }
                    break;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
            input = scanner.nextLine();
        }
        cars.entrySet().stream()
                .sorted((f, s) -> {
                    int result = Integer.compare(s.getValue().getMileage(), f.getValue().getMileage());
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                }).forEach(c -> {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", c.getKey(), c.getValue().getMileage(), c.getValue().getFuel());
        });
    }

    static class Car {
        String model;
        int mileage;
        int fuel;

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        public Car(String model, int mileage, int fuel) {
            this.model = model;
            this.mileage = mileage;
            this.fuel = fuel;
        }
    }
}
