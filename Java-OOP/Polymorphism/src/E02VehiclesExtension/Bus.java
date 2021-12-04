package E02VehiclesExtension;

public class Bus extends Vehicle {
    private final static double AC_FUEL_CONSUMPTION = 1.4;
    private boolean isEmpty;

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.setFuelConsumption(this.getFuelConsumption());
        isEmpty = true;
    }

    @Override
    public void drive(double kilometers) {
        super.drive(kilometers);
    }

    public void setEmpty(boolean empty) {
        if (this.isEmpty == empty) {
            return;
        }
        //if bus was empty
        if (!empty) {
            this.setFuelConsumption(this.getFuelConsumption() + AC_FUEL_CONSUMPTION);
        }
        //if bus was not empty
        if (empty) {
            this.setFuelConsumption(this.getFuelConsumption() - AC_FUEL_CONSUMPTION);
        }
        this.isEmpty = empty;
    }
}
