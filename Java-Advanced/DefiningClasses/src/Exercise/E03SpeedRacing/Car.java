package Exercise.E03SpeedRacing;

public class Car {
    //Model, fuel amount, fuel cost for 1 kilometer and distance traveled.
    private String model;
    private double fuelAmount;
    private double fuelConsumption;
    private int distance = 0;

    public Car(String model, double fuelAmount, double fuelConsumption) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumption = fuelConsumption;
    }

    public boolean drive(int distance) {
        double requiredFuel = distance * fuelConsumption;
        if (fuelAmount >= requiredFuel) {
            this.distance += distance;
            fuelAmount -= requiredFuel;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distance);
    }
}
