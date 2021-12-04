package E02VehiclesExtension;

public class Car extends Vehicle {
    private final static double AC_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.setFuelConsumption(this.getFuelConsumption() + AC_FUEL_CONSUMPTION);
    }

}
