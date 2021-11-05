package E05CarSalesman;

public class Engine {
    //model, power, displacement and efficiency
    //mandatory
    private String model;
    private int power;

    //optional
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, -1, efficiency);
    }

    public Engine(String model, int power) {
        this(model, power, -1, "n/a");
    }

    @Override
    public String toString() {
        String printDisplacement;
        if (displacement == -1) {
            printDisplacement = "n/a";
        } else {
            printDisplacement = String.valueOf(displacement);
        }

        return model + ":" + "\n" + "Power: " + power + "\n" +
                "Displacement: " + printDisplacement + "\n" +
                "Efficiency: " + efficiency;
    }
}
