package service;

import model.Player;
import service.interfaces.ILoadService;

import java.util.Scanner;

public class BattleService {
    public void startGame() {
        // Load Characters and Pokemons
        ILoadService characterList = new LoadService();
        ILoadService pokemonList = new LoadService();

        PlayerService playerService = new PlayerService();
        GameService gameService = new GameService();
        Scanner scanner = new Scanner(System.in);


        Player player1 = playerService.createPlayer(scanner, characterList.loadCharacters(), pokemonList.loadPokemons());
        Player player2 = playerService.createPlayer(scanner, characterList.loadCharacters(), pokemonList.loadPokemons());

        System.out.println("1- Oyun başlasın mı ?.");
        System.out.println("2- Çıkış");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice == 1) {
            Player startingPlayer = (Math.random() < 0.5) ? player1 : player2;
            startingPlayer.setTurn(true);
            for (int i = 0; i < 2; i++) {
                boolean gameEnded = false; // Define gameEnded here for each iteration
                while (!gameEnded) {
                    gameEnded = gameService.performPlayerTurn(startingPlayer == player1 ? player1 : player2,
                            startingPlayer == player1 ? player2 : player1, scanner, i, pokemonList.loadPokemons());
                }
            }
        } else if (choice == 2) {
            System.exit(0);
        }
    }
}
