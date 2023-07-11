package model;

import java.util.List;

public class Film {
    private String name;
    private int year;
    private String director;
    private double imdb;
    private List<Category> categoryArray;
    private String time;
    private List<Platform> platformList;

    public Film() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getImdb() {
        return this.imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public List<Category> getCategoryArray() {
        return this.categoryArray;
    }

    public void setCategoryArray(Category categoryArray) {
        // this.categoryArray = categoryArray;
        this.categoryArray.add(categoryArray);

    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Platform> getPlatformList() {
        return this.platformList;
    }

    public void setPlatformList(List<Platform> platformList) {
        this.platformList = platformList;
    }

}
