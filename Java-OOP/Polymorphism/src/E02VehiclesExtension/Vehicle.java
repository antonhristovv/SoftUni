package E02VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
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
        if (fuelQuantity <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (fuelQuantity + this.getFuelQuantity() > this.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.setFuelQuantity(this.getFuelQuantity() + fuelQuantity);
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
