package Exercise.E01Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void drive(double kilometers) {
        if (kilometers * this.getFuelConsumption() > this.getFuelQuantity()) {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        } else {
            this.setFuelQuantity(this.getFuelQuantity() - kilometers * this.getFuelConsumption());
            DecimalFormat formatter = new DecimalFormat("##.##");
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), formatter.format(kilometers));
        }
    }

    protected void refuel(double fuelQuantity) {
        this.setFuelQuantity(this.getFuelQuantity() + fuelQuantity);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
