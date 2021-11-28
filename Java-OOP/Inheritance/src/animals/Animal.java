package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throwException();
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throwException();
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if (gender.trim().isEmpty()) {
            throwException();
        }
        this.gender = gender;
    }

    private void throwException() {
        throw new IllegalArgumentException("Invalid input!");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String produceSound() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        output.append(this.name).append(" ").append(this.age).append(" ").append(this.gender).append(System.lineSeparator());
        output.append(this.produceSound());
        return output.toString();
    }
}
