package L02Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        int carsCount = Integer.parseInt(scanner.nextLine());
        while (carsCount-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String brand = tokens[0];
            Car car = null;
            if (tokens.length == 3) {
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                car = new Car(brand, model, horsePower);
            } else if (tokens.length == 1) {
                car = new Car(brand);
            } else {
                try {
                    int horsePower = Integer.parseInt(tokens[1]);
                    car = new Car(brand);
                } catch (NumberFormatException e) {
                    String model = tokens[1];
                    car = new Car(brand, model);
                }
            }
            cars.add(car);
        }
        cars.forEach(car -> System.out.println(car.carInfo()));
    }
}
