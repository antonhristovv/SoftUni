package Exercise.E03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsCount = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        while (carsCount-- > 0) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            int fuelAmount = Integer.parseInt(carData[1]);
            double fuelConsumption = Double.parseDouble(carData[2]);
            Car car = new Car(model, fuelAmount, fuelConsumption);
            cars.put(model, car);
        }
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String model = tokens[1];
            int distance = Integer.parseInt(tokens[2]);
            if (!cars.get(model).drive(distance)) {
                System.out.println("Insufficient fuel for the drive");
            }
            input = scanner.nextLine();
        }
        cars.forEach((key, value) -> System.out.println(value));
    }
}
