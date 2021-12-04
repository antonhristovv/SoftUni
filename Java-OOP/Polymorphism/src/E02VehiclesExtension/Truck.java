package E02VehiclesExtension;

public class Truck extends Vehicle {
    private final static double AC_FUEL_CONSUMPTION = 1.6;
    private final static double AMOUNT_REFUELED = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.setFuelConsumption(this.getFuelConsumption() + AC_FUEL_CONSUMPTION);
    }

    @Override
    public void refuel(double fuelQuantity) {
        double fuelToBeAdded = fuelQuantity * AMOUNT_REFUELED;

        if (fuelQuantity <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (fuelQuantity + this.getFuelQuantity() > this.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.setFuelQuantity(this.getFuelQuantity() + fuelToBeAdded);
        }
    }

}
