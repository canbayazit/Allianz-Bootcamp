package service;

import model.Character;
import model.Player;
import model.Pokemon;

import java.util.List;
import java.util.Scanner;

public class PlayerService {
    // Console'da oyuna başlamadan önce player object'i oluşturan metot
    public Player createPlayer(Scanner scanner,List<Character> characters, List<Pokemon> pokemons){
        System.out.println("Enter player's name:");
        String playerName = scanner.nextLine();

        System.out.println("Select a character:");
        for (int i = 0; i < characters.size(); i++) {
            System.out.println((i + 1) + ". " + characters.get(i).getName());
        }
        int characterChoice = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline

        System.out.println("Select a Pokémon:");
        for (int i = 0; i < pokemons.size(); i++) {
            System.out.println((i + 1) + ". " + pokemons.get(i).getName());
        }
        int pokemonChoice = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline

        Character selectedCharacter = characters.get(characterChoice);
        Pokemon selectedPokemon = pokemons.get(pokemonChoice);

        selectedCharacter.getPokemonList().add(selectedPokemon);

        return new Player(playerName, selectedCharacter);

    }

}
