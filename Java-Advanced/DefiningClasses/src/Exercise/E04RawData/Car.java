package Exercise.E04RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;

    public Car(String model, Engine engine, Cargo cargo, Tire tire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire getTire() {
        return tire;
    }

    @Override
    public String toString() {
        return model;
    }
}
