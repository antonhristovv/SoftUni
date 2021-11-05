package E06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    //name, number of badges and a collection of pokemon
    private String name;
    private int numberOfBadges = 0;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getBadges() {
        return numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<String> getPokemonsElements() {
        List<String> pokemonsElements = new ArrayList<>();
        pokemons.forEach(pokemon -> pokemonsElements.add(pokemon.getElement()));
        return pokemonsElements;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void increaseBadges() {
        this.numberOfBadges++;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, numberOfBadges, getPokemons().size());
    }
}
