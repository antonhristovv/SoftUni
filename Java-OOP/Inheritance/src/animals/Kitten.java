package animals;

public class Kitten extends Cat {
    private static final String GENDER = "Female";

    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
