import java.util.*;

public class T03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Plant> plants = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("<->");
            String plantName = input[0];
            int rarity = Integer.parseInt(input[1]);
            if (plants.containsKey(plantName)) {
                plants.get(plantName).setRarity(rarity);
            } else {
                Plant plant = new Plant(plantName, rarity);
                plants.put(plantName, plant);
            }
        }
        String input = scanner.nextLine();
        while (!"Exhibition".equals(input)) {
            String[] tokens = input.split(": ");
            String command = tokens[0];
            String[] commandParameters = tokens[1].split(" - ");
            String plantName = commandParameters[0];
            if (plants.containsKey(plantName) && ("Rate".equals(command)
                    || "Update".equals(command) || "Reset".equals(command))) {
                switch (command) {
                    case "Rate":
                        double rating = Double.parseDouble(commandParameters[1]);
                            plants.get(plantName).addRating(rating);
                        break;
                    case "Update":
                        int newRarity = Integer.parseInt(commandParameters[1]);
                        plants.get(plantName).setRarity(newRarity);
                        break;
                    case "Reset":
                        plants.get(plantName).resetRatings();
                        break;
                }
            } else {
                System.out.println("error");
            }
            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plants.values()
                .stream()
                .sorted((f, s) -> {
                    if (f.getRarity() != s.getRarity()) {
                        return Integer.compare(s.getRarity(), f.getRarity());
                    } else {
                        return Double.compare(s.getAvgRating(), f.getAvgRating());
                    }
                })
                .forEach(System.out::println);
    }

    static class Plant {
        String plantName;
        int rarity;
        List<Double> ratings;

        public int getRarity() {
            return rarity;
        }

        public Plant(String plantName, int rarity) {
            this.plantName = plantName;
            this.rarity = rarity;
            this.ratings = new ArrayList<>();
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        @Override
        public String toString() {
            return "- " + plantName + "; Rarity: " + rarity +
                    "; Rating: " + String.format("%.2f", getAvgRating());
        }

        public void addRating(double rating) {
            this.ratings.add(rating);
        }

        public double getAvgRating() {
            if (this.ratings.isEmpty()) {
                return 0.0;
            }
            double avgRating = 0.0;
            for (Double rating : ratings) {
                avgRating += rating;
            }
            return avgRating / ratings.size();
        }

        public void resetRatings() {
            this.ratings.clear();
        }
    }
}
