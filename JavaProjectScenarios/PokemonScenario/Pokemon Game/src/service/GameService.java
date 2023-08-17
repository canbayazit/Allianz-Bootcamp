package service;

import model.Player;
import model.Pokemon;
import model.TypeEnum;
import model.WeatherTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameService {

    // console'da iki oyuncunun karşılıklı olarak multiplayer tarzında sırayla birbirine saldırmasını sağlayan metot.
    public boolean performPlayerTurn(Player startingPlayer, Player opponentPlayer, Scanner scanner, int i,
                                     List<Pokemon> pokemonList) {
        // oyuncuların saldırı sırasını belirliyoruz
        Player attackingPlayer = startingPlayer.isTurn() ? startingPlayer : opponentPlayer;
        Player defendingPlayer = startingPlayer.isTurn() ? opponentPlayer : startingPlayer;
        WeatherService weatherService = new WeatherService();
        WeatherTypeEnum weather = weatherService.getWeatherRandomly();
        System.out.println("Weather: " + weather);
        System.out.println(attackingPlayer.getName() + "'s Turn");
        System.out.println(attackingPlayer.getName() + ", choose your attack:");
        System.out.println("1. Use Pokémon Special Power");
        System.out.println("2. Use Character Special Power");
        System.out.println("3. Combine Pokémon and Character Special Powers");
        System.out.println("4. Perform a Normal Attack");
        int attackChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        // hangi tür saldırı yapılacağını seçiyoruz
        switch (attackChoice) {
            case 1:
                calculateDamage(attackingPlayer, defendingPlayer, true, false, weather);
                break;
            case 2:
                calculateDamage(attackingPlayer, defendingPlayer, false, true, weather);
                break;
            case 3:
                calculateDamage(attackingPlayer, defendingPlayer, true, true, weather);
                break;
            case 4:
                calculateDamage(attackingPlayer, defendingPlayer, false, false, weather);
                break;
            default:
                System.out.println("Invalid choice. Performing a Normal Attack.");
                calculateDamage(attackingPlayer, defendingPlayer, false, false, weather);
                break;
        }

        // pokemonun hayatta kalıp kalmamasına göre oyunun gidişatını belirliyoruz.
        if (isAlivePokemon(defendingPlayer, i)) {
            attackingPlayer.setTurn(!attackingPlayer.isTurn());
            defendingPlayer.setTurn(!defendingPlayer.isTurn());
            return false; // The game hasn't ended yet
        } else {
            if (i == 0) {
                swapPokemon(defendingPlayer, attackingPlayer, pokemonList);
                System.out.println("2. level başladı");
                return true;
            } else if (i == 1) {
                System.out.println(attackingPlayer.getName() + " Kazandı ! Tebrikler !");
                return true; // The game has ended
            }

        }

        return false;
    }

    // her turda bir pokemonun diğer pokemona verdiği hasarı belli senaryolara göre hesaplayan metot.
    private void calculateDamage(Player attacker, Player defender, boolean isPokeSpecialAttack,
                                 boolean isCharSpecialAttack, WeatherTypeEnum currentWeather) {
        Pokemon attackingPokemon = attacker.getCharacter().getPokemonList().get(attacker.getActivePokemonIndex()); // atak yapan pokemon
        Pokemon defendingPokemon = defender.getCharacter().getPokemonList().get(defender.getActivePokemonIndex()); // atak yiyen pokemon

        // senaryo:
        // 2 özel güç var biri pokemonun özel gücü diğer karakterimizin özel gücü
        // özel gücü hakkı yoksa ama yinede özel gücünü kullanmak istiyorsa oyuncuya ceza verelim
        // ve hasar veremesin yani sıfır vursun hamlesi boşa gitsin dedik.


        // özel gücü varmı yok mu onu kontrol ediyoruz
        boolean specialAttack = false;
        if (isPokeSpecialAttack && isCharSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainRight() > 0
                    && attacker.getCharacter().getSpecialPower().getRemainRight() > 0;
        } else if (isPokeSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainRight() > 0;
        } else if (isCharSpecialAttack) {
            specialAttack = attacker.getCharacter().getSpecialPower().getRemainRight() > 0;
        }

        int charRemainRight = attacker.getCharacter().getSpecialPower().getRemainRight();
        int damage = 0;
        if (specialAttack) {
            if (isPokeSpecialAttack && isCharSpecialAttack) {
                if (currentWeather == WeatherTypeEnum.SUNNY && attackingPokemon.getType() == TypeEnum.FIRE) {
                    damage = attackingPokemon.specialAttack()
                            + attacker.getCharacter().getSpecialPower().getExtraDamage() + 10; // special attack pokemon özel gücü fonksiyonu
                    // karakterin special hakkı 1 azaldı
                    attacker.getCharacter().getSpecialPower().setRemainRight(charRemainRight - 1);
                } else if (currentWeather == WeatherTypeEnum.RAINY && attackingPokemon.getType() == TypeEnum.WATER) {
                    damage = attackingPokemon.specialAttack()
                            + attacker.getCharacter().getSpecialPower().getExtraDamage() + 10; // special attack pokemon özel gücü fonksiyonu
                    // karakterin special hakkı 1 azaldı
                    attacker.getCharacter().getSpecialPower().setRemainRight(charRemainRight - 1);
                } else if (currentWeather == WeatherTypeEnum.SNOWY && attackingPokemon.getType() == TypeEnum.ICE) {
                    damage = attackingPokemon.specialAttack()
                            + attacker.getCharacter().getSpecialPower().getExtraDamage() + 10; // special attack pokemon özel gücü fonksiyonu
                    // karakterin special hakkı 1 azaldı
                    attacker.getCharacter().getSpecialPower().setRemainRight(charRemainRight - 1);
                } else {
                    damage = attackingPokemon.specialAttack()
                            + attacker.getCharacter().getSpecialPower().getExtraDamage(); // special attack pokemon özel gücü fonksiyonu
                    // karakterin special hakkı 1 azaldı
                    attacker.getCharacter().getSpecialPower().setRemainRight(charRemainRight - 1);
                }

            } else if (isPokeSpecialAttack) {
                if (currentWeather == WeatherTypeEnum.SUNNY && attackingPokemon.getType() == TypeEnum.FIRE) {
                    damage = attackingPokemon.specialAttack() + 10;
                } else if (currentWeather == WeatherTypeEnum.RAINY && attackingPokemon.getType() == TypeEnum.WATER) {
                    damage = attackingPokemon.specialAttack() + 10;
                } else if (currentWeather == WeatherTypeEnum.SNOWY && attackingPokemon.getType() == TypeEnum.ICE) {
                    damage = attackingPokemon.specialAttack() + 10;
                } else {
                    damage = attackingPokemon.specialAttack();
                }

            } else if (isCharSpecialAttack) {
                if (currentWeather == WeatherTypeEnum.SUNNY && attackingPokemon.getType() == TypeEnum.FIRE) {
                    damage = attackingPokemon.getDamage()
                            + attacker.getCharacter().getSpecialPower().getExtraDamage() + 10;
                    attacker.getCharacter().getSpecialPower().setRemainRight(charRemainRight - 1);
                } else if (currentWeather == WeatherTypeEnum.RAINY && attackingPokemon.getType() == TypeEnum.WATER) {
                    damage = attackingPokemon.getDamage()
                            + attacker.getCharacter().getSpecialPower().getExtraDamage() + 10;
                    attacker.getCharacter().getSpecialPower().setRemainRight(charRemainRight - 1);
                } else if (currentWeather == WeatherTypeEnum.SNOWY && attackingPokemon.getType() == TypeEnum.ICE) {
                    damage = attackingPokemon.getDamage()
                            + attacker.getCharacter().getSpecialPower().getExtraDamage() + 10;
                    attacker.getCharacter().getSpecialPower().setRemainRight(charRemainRight - 1);
                } else {
                    damage = attackingPokemon.getDamage()
                            + attacker.getCharacter().getSpecialPower().getExtraDamage();
                    attacker.getCharacter().getSpecialPower().setRemainRight(charRemainRight - 1);
                }

            }
        } else {
            if (isPokeSpecialAttack || isCharSpecialAttack) {
                System.out.println("Iskaladın");
            } else {
                if (currentWeather == WeatherTypeEnum.SUNNY && attackingPokemon.getType() == TypeEnum.FIRE) {
                    damage = attackingPokemon.getDamage() + 10;
                } else if (currentWeather == WeatherTypeEnum.RAINY && attackingPokemon.getType() == TypeEnum.WATER) {
                    damage = attackingPokemon.getDamage() + 10;
                } else if (currentWeather == WeatherTypeEnum.SNOWY && attackingPokemon.getType() == TypeEnum.ICE) {
                    damage = attackingPokemon.getDamage() + 10;
                } else {
                    damage = attackingPokemon.getDamage();
                }

            }
        }

        defendingPokemon.setHealth(defendingPokemon.getHealth() - damage);
    }

    // her turda saldırıya uğrayan pokemonun sağlığının 0 veya 0'ın altına düşüp düşmediğini kontrol eden
    // ve can durumuna göre logic işlemlerini yapan metot.
    public boolean isAlivePokemon(Player defendPlayer, int i) {
        if (defendPlayer.getCharacter().getPokemonList().get(defendPlayer.getActivePokemonIndex()).getHealth() > 0) {
            System.out.println(defendPlayer.getName() + ":"
                    + defendPlayer.getCharacter().getPokemonList().get(defendPlayer.getActivePokemonIndex()).getHealth() + "Health");
            System.out.println("Oyun devam ediyor");
            return true;
        } else {
            if (i == 1) {
                if (defendPlayer.getCharacter().getPokemonList().size()>1){
                    int nextPokemonIndex = (defendPlayer.getActivePokemonIndex() + 1) % defendPlayer.getCharacter()
                            .getPokemonList().size();
                    defendPlayer.setActivePokemonIndex(nextPokemonIndex);
                    System.out.println(defendPlayer.getName() + " isimli oyuncunun pokemonu bayıldı.");
                    System.out.println("Yeni pokemonu: " + defendPlayer.getCharacter()
                            .getPokemonList().get(nextPokemonIndex));
                    return true;
                }
                return false;
            }
            return false;
        }
    }


    // 2. level'a geçerken kazanan oyuncuya kaybeden oyuncunun pokemonunu ekleyip, kaybeden oyuncunun listesinden
    // pokemonunu silen yani kazanan oyuncuyla kaybeden oyuncu arasında pokemonları swapleyen metot
    private void swapPokemon(Player losingPlayer, Player winningPlayer, List<Pokemon> pokemonList) {
        Pokemon defeatedPokemon = losingPlayer.getCharacter().getPokemonList().get(0);
        System.out.println(losingPlayer.getName() + " 1. level'i kaybetti");
        System.out.println(defeatedPokemon + " pokemonu " + winningPlayer.getName()
                + " isimli kazanan oyuncunun çantasına eklendi!");
        winningPlayer.getCharacter().getPokemonList().add(defeatedPokemon);
        losingPlayer.getCharacter().getPokemonList().remove(0);
        losingPlayer.getCharacter().getPokemonList().add(getLowestAttackPokemon(defeatedPokemon, pokemonList));
        defeatedPokemon.setHealth(100);
    }

    // 2. levelda kaybeden oyuncuya pokemon listesinden saldırı gücü en düşük olan pokemonu veren metot.
    private Pokemon getLowestAttackPokemon(Pokemon defeatedPokemon, List<Pokemon> pokemonList) {
        List<Pokemon> tempList = new ArrayList<>(pokemonList);
        tempList.remove(defeatedPokemon);
        Pokemon lowestAttackPokemon = tempList.get(0);
        for (Pokemon pokemon : tempList) {
            if (pokemon.getDamage() < lowestAttackPokemon.getDamage()) {
                lowestAttackPokemon = pokemon;
            }
        }
        return lowestAttackPokemon;
    }
}
