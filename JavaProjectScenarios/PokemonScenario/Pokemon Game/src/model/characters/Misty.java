package model.characters;

import model.Character;
import model.Pokemon;
import model.SpecialPower;

import java.util.List;

public class Misty extends Character {
    public Misty(String name, SpecialPower specialPower, List<Pokemon> pokemonList) {
        super(name, specialPower, pokemonList);
    }

    public Misty(String name, SpecialPower specialPower) {
        super(name, specialPower);
    }
}
