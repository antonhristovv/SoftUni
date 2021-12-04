package E02VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        String vehicleInfo = scanner.nextLine();
        Vehicle car = getVehicle(vehicleInfo);
        vehicles.put("Car", car);

        vehicleInfo = scanner.nextLine();
        Vehicle truck = getVehicle(vehicleInfo);
        vehicles.put("Truck", truck);

        vehicleInfo = scanner.nextLine();
        Vehicle bus = getVehicle(vehicleInfo);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String vehicleType = tokens[1];
            Vehicle vehicle = vehicles.get(vehicleType);
            switch (command) {
                case "Drive":
                    double kilometers = Double.parseDouble(tokens[2]);
                    if (vehicle instanceof Bus) {
                        ((Bus) vehicle).setEmpty(false);
                    }
                    vehicle.drive(kilometers);
                    break;
                case "Refuel":
                    double fuelQuantity = Double.parseDouble(tokens[2]);
                    vehicle.refuel(fuelQuantity);
                    break;
                case "DriveEmpty":
                    kilometers = Double.parseDouble(tokens[2]);
                    if (vehicle instanceof Bus) {
                        ((Bus) vehicle).setEmpty(true);
                    }
                    vehicle.drive(kilometers);
                    break;
            }
        }
        vehicles.values().forEach(System.out::println);
    }

    public static Vehicle getVehicle(String vehicleInfo) {
        String[] tokens = vehicleInfo.split("\\s+");
        String vehicleType = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);
        Vehicle vehicle = null;
        switch (vehicleType) {
            case "Car":
                vehicle = new Car(fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "Truck":
                vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "Bus":
                vehicle = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
        }
        return vehicle;
    }
}
