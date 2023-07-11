package model;

public class Film {
    private String name;
    private int year;
    private String director;
    private double imdb;
    private Category[] categoryArray;
    private String time;
    private Platform[] platformList;

    public Film(String name, int year, String director, double imdb, Category[] categoryArray, String time,
            Platform[] platformList) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.imdb = imdb;
        this.categoryArray = categoryArray;
        this.time = time;
        this.platformList = platformList;
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

    public Category[] getCategoryArray() {
        return this.categoryArray;
    }

    public void setCategoryArray(Category[] categoryArray) {
        this.categoryArray = categoryArray;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Platform[] getPlatformList() {
        return this.platformList;
    }

    public void setPlatformList(Platform[] platformList) {
        this.platformList = platformList;
    }

}
