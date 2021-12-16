package Exercise.E02CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public double calculateAverageSalary() {
        return this.employees.stream()
                .mapToDouble(Employee::getSalary).average().orElse(0.0);
    }
}
