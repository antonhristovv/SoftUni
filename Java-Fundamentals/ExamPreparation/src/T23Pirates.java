import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T23Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, City> cities = new HashMap<>();
        String input = scanner.nextLine();
        while (!"Sail".equals(input)) {
            String[] tokens = input.split("\\|{2}");
            String cityName = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);
            if (cities.containsKey(cityName)) {
                int currentGold = cities.get(cityName).getGold();
                int currentPopulation = cities.get(cityName).getPopulation();
                cities.get(cityName).setGold(currentGold + gold);
                cities.get(cityName).setPopulation(currentPopulation + population);
            } else {
                cities.put(cityName, new City(cityName, population, gold));
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] commandAndInfo = input.split("=>");
            String command = commandAndInfo[0];
            String town = commandAndInfo[1];
            switch (command) {
                case "Plunder":
                    int citizens = Integer.parseInt(commandAndInfo[2]);
                    int gold = Integer.parseInt(commandAndInfo[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, citizens);
                    int currentGold = cities.get(town).getGold() - gold;
                    int currentPopulation = cities.get(town).getPopulation() - citizens;
                    cities.get(town).setGold(currentGold);
                    cities.get(town).setPopulation(currentPopulation);
                    if (cities.get(town).getGold() == 0 || cities.get(town).getPopulation() == 0) {
                        cities.remove(town);
                        System.out.println(town + " has been wiped off the map!");
                    }
                    break;
                case "Prosper":
                    gold = Integer.parseInt(commandAndInfo[2]);
                    if (gold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        currentGold = cities.get(town).getGold() + gold;
                        cities.get(town).setGold(currentGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, currentGold);
                    }
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
            input = scanner.nextLine();
        }
        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            cities.entrySet().stream()
                    .sorted((f, s) -> {
                        int result = Integer.compare(s.getValue().getGold(), f.getValue().getGold());
                        if (result == 0) {
                            result = f.getKey().compareTo(s.getKey());
                        }
                        return result;
                    })
                    .forEach(city -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", city.getKey(), city.getValue().getPopulation(), city.getValue().getGold()));
        }

    }

    static class City {
        String name;
        int population;
        int gold;

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
    }
}
