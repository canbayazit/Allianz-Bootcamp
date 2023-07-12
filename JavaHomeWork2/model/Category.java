package model;

public class Category {
    private String name;
    private int filmCount;

    public String getName() {
        return this.name;
    }

    public int getFilmCount() {
        return this.filmCount;
    }

    public void setFilmCount() {
        this.filmCount++;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

}
