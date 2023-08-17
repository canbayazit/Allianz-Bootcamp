package service;

import model.Character;
import model.Pokemon;
import model.SpecialPower;
import model.TypeEnum;
import model.characters.Ash;
import model.characters.Brock;
import model.characters.Misty;
import model.pokemon.*;
import model.specialPowers.characterSpecialPower.AshPower;
import model.specialPowers.characterSpecialPower.BrockPower;
import model.specialPowers.characterSpecialPower.MistyPower;
import model.specialPowers.pokemonSpecialPower.*;
import service.interfaces.ILoadService;

import java.util.ArrayList;
import java.util.List;

public class LoadService implements ILoadService {

    @Override
    public List<Character> loadCharacters() {
        SpecialPower strategyAsh = new AshPower("Strategy Ash", 10, 1);
        SpecialPower strategyBrock = new BrockPower("Strategy Brock", 8, 1);
        SpecialPower strategyMisty = new MistyPower("Strategy Misty", 7, 1);
        Character ash = new Ash("Ash", strategyAsh);
        Character brock = new Brock("Brock", strategyBrock);
        Character misty = new Misty("Misty", strategyMisty);

        List<Character> characterList = new ArrayList<>();
        characterList.add(ash);
        characterList.add(brock);
        characterList.add(misty);

        return characterList;
    }

    @Override
    public List<Pokemon> loadPokemons() {
        SpecialPower electricityPower = new ElectricityPower("Electric", 10, 1);
        SpecialPower firePower = new FirePower("Fire", 12, 1);
        SpecialPower dragonPower = new DragonPower("Dragon", 15, 1);
        SpecialPower waterPower = new WaterPower("Water", 8, 1);
        SpecialPower grassPower = new GrassPower("Grass", 9, 1);
        SpecialPower icePower = new IcePower("Ice", 11, 1);
        SpecialPower psychicPower = new PsychicPower("Psychic", 20, 1);


        Pokemon pikachu = new Pikachu("Pikachu", 100, 7, TypeEnum.ELECTRIC, electricityPower);
        Pokemon dragonite = new Dragonite("Dragonite", 100, 17, TypeEnum.DRAGON, dragonPower);
        Pokemon articuno = new Articuno("Articuno", 100, 15, TypeEnum.ICE, icePower);
        Pokemon bulbasaur = new Bulbasaur("Bulbasaur", 100, 6, TypeEnum.GRASS, grassPower);
        Pokemon charizard = new Charizard("Charizard", 100, 11, TypeEnum.FIRE, firePower);
        Pokemon mew = new Mew("Mew", 100, 12, TypeEnum.PSYCHIC, psychicPower);
        Pokemon mewtwo = new Mewtwo("Mewtwo", 100, 20, TypeEnum.PSYCHIC, psychicPower);
        Pokemon moltres = new Moltres("Moltres", 100, 16, TypeEnum.FIRE, firePower);
        Pokemon squirtle = new Squirtle("Squirtle", 100, 5, TypeEnum.WATER, waterPower);
        Pokemon zapdos = new Zapdos("Zapdos", 100, 17, TypeEnum.ELECTRIC, electricityPower);

        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pikachu);
        pokemonList.add(dragonite);
        pokemonList.add(articuno);
        pokemonList.add(bulbasaur);
        pokemonList.add(charizard);
        pokemonList.add(mew);
        pokemonList.add(mewtwo);
        pokemonList.add(moltres);
        pokemonList.add(squirtle);
        pokemonList.add(zapdos);

        return pokemonList;
    }
}
