package Exercise.E03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Citizen":
                    String citizenName = tokens[1];
                    int citizenAge = Integer.parseInt(tokens[2]);
                    String citizenId = tokens[3];
                    String citizenBirthDate = tokens[4];
                    Citizen citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthDate);
                    birthables.add(citizen);
                    break;
                case "Pet":
                    String petName = tokens[1];
                    String petBirthDate = tokens[2];
                    Pet pet = new Pet(petName, petBirthDate);
                    birthables.add(pet);
                    break;
                case "Robot":
                    break;
            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();
        birthables.stream().map(Birthable::getBirthDate)
                .filter(birthDate -> birthDate.endsWith(year))
                .forEach(System.out::println);
    }
}
