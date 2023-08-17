package model;

public class Player {
    private String name;
    private Character character;
    private boolean isWinner;
    private int activePokemonIndex = 0;
    private boolean isTurn;

    public Player(String name, Character character) {
        this.name = name;
        this.character = character;
        this.isWinner = false;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public int getActivePokemonIndex() {
        return activePokemonIndex;
    }

    public void setActivePokemonIndex(int activePokemonIndex) {
        this.activePokemonIndex = activePokemonIndex;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", character=" + character +
                ", isWinner=" + isWinner +
                ", activePokemonIndex=" + activePokemonIndex +
                ", isTurn=" + isTurn +
                '}';
    }
}
