package E04RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        int carsCount = Integer.parseInt(scanner.nextLine());
        while (carsCount-- > 0) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            double tire1Pressure = Double.parseDouble(carData[5]);
            int tire1Age = Integer.parseInt(carData[6]);
            double tire2Pressure = Double.parseDouble(carData[7]);
            int tire2Age = Integer.parseInt(carData[8]);
            double tire3Pressure = Double.parseDouble(carData[9]);
            int tire3Age = Integer.parseInt(carData[10]);
            double tire4Pressure = Double.parseDouble(carData[11]);
            int tire4Age = Integer.parseInt(carData[12]);
            Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            Car car = new Car(model, engine, cargo, tire);
            cars.add(car);
        }
        String command = scanner.nextLine();
        if ("fragile".equals(command)) {
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals(command))
                    .filter(car -> hasCorrectPressure(car.getTire()))
                    .forEach(System.out::println);
        } else {
            cars.stream().filter(car -> car.getEngine().getPower() > 250)
                    .forEach(System.out::println);
        }
    }

    private static boolean hasCorrectPressure(Tire tire) {
        return tire.getTire1Pressure() < 1.0 || tire.getTire2Pressure() < 1.0 || tire.getTire3Pressure() < 1.0 || tire.getTire4Pressure() < 1.0;
    }
}
