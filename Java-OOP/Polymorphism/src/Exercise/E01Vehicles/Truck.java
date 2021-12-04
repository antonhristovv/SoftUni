package Exercise.E01Vehicles;

public class Truck extends Vehicle {
    private final static double AC_FUEL_CONSUMPTION = 1.6;
    private final static double AMOUNT_REFUELED = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.setFuelConsumption(this.getFuelConsumption() + AC_FUEL_CONSUMPTION);
    }

    @Override
    public void refuel(double fuelQuantity) {
        double fuelToBeAdded = fuelQuantity * AMOUNT_REFUELED;
        this.setFuelQuantity(this.getFuelQuantity() + fuelToBeAdded);
    }

}
