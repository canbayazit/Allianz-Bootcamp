package model.pokemon;

import model.Pokemon;
import model.SpecialPower;
import model.TypeEnum;

public class Charizard extends Pokemon {
    public Charizard(String name, int health, int damage, TypeEnum type, SpecialPower specialPower) {
        super(name, health, damage, type, specialPower);
    }
}
