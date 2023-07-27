package model;

// kurs branşı ( tango, salsa gibi)
public class Branch {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                '}';
    }
}
