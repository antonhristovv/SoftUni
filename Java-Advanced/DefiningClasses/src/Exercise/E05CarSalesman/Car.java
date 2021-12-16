package Exercise.E05CarSalesman;

public class Car {
    //model, engine, weight and color
    //mandatory
    private String model;
    private Engine engine;

    //optional
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }

    @Override
    public String toString() {
        String printWeight;
        if (weight == -1) {
            printWeight = "n/a";
        } else {
            printWeight = weight + "";
        }
        return model + ":" + "\n" + engine.toString() + "\n" +
                "Weight: " + printWeight + "\n" + "Color: " + color;
    }
}
