package L02SalaryIncrease;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName, age, 0.0);
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (this.age < 30) {
            bonus /= 2;
        }
        this.setSalary(this.getSalary() + (this.getSalary() * bonus / 100));
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0####");
        return String.format("%s %s gets %s leva", firstName, lastName, df.format(salary));
    }
}
