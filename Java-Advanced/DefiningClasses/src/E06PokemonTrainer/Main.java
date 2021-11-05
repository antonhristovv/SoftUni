package E06PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"Tournament".equals(input)) {
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.get(trainerName).addPokemon(pokemon);
            input = scanner.nextLine();
        }
        String element = scanner.nextLine();
        while (!"End".equals(element)) {
            checkElement(element, trainers);
            element = scanner.nextLine();
        }
        trainers.values()
                .stream().sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .forEach(System.out::println);
    }

    private static void checkElement(String element, Map<String, Trainer> trainers) {
        trainers.values().forEach(trainer -> {
            if (trainer.getPokemons().size() > 0) {
                if (trainer.getPokemonsElements().contains(element)) {
                    trainer.increaseBadges();
                } else {
                    trainer.getPokemons().forEach(Pokemon::looseHealth);
                    trainer.setPokemons(trainer.getPokemons().stream().filter(pokemon -> pokemon.getHealth() > 0).collect(Collectors.toList()));
                }
            }
        });
    }
}
