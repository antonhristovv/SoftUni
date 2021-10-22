package E07Google;

public class Car {
    //car {carModel} {carSpeed}
    private String carModel;
    private int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return carModel + " " + carSpeed;
    }
}
