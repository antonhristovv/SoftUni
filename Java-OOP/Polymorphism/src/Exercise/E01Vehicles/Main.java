package Exercise.E01Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        Vehicle car = new Car(fuelQuantity, fuelConsumption);
        tokens = scanner.nextLine().split("\\s+");
        fuelQuantity = Double.parseDouble(tokens[1]);
        fuelConsumption = Double.parseDouble(tokens[2]);
        Vehicle truck = new Truck(fuelQuantity, fuelConsumption);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n; i++) {
            tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String vehicleType = tokens[1];
            switch (command) {
                case "Drive":
                    double kilometers = Double.parseDouble(tokens[2]);
                    if ("Car".equals(vehicleType)) {
                        car.drive(kilometers);
                    } else {
                        truck.drive(kilometers);
                    }
                    break;
                case "Refuel":
                    fuelQuantity = Double.parseDouble(tokens[2]);
                    if ("Car".equals(vehicleType)) {
                        car.refuel(fuelQuantity);
                    } else {
                        truck.refuel(fuelQuantity);
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
