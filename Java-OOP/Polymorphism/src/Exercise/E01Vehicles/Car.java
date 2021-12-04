package Exercise.E01Vehicles;

public class Car extends Vehicle{
    private final static double AC_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.setFuelConsumption(this.getFuelConsumption() + AC_FUEL_CONSUMPTION);
    }

}
