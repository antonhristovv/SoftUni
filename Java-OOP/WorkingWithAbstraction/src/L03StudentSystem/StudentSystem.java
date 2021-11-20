package L03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public void executeCommand(String input) {
        String[] tokens = input.split("\\s+");
        String command = tokens[0];
        switch (command) {
            case "Create":
                String name = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                double grade = Double.parseDouble(tokens[3]);
                Student student = new Student(name, age, grade);
                repo.put(name, student);
                break;
            case "Show":
                name = tokens[1];
                if (repo.containsKey(name)) {
                    student = repo.get(name);
                    grade = student.getGrade();
                    String view;
                    if (grade >= 5.00) {
                        view = " Excellent student.";
                    } else if (grade >= 3.50) {
                        view = " Average student.";
                    } else {
                        view = " Very nice person.";
                    }
                    System.out.println(student + view);
                }
                break;
        }
    }
}
