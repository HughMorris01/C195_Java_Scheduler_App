package model;

public class Country {
    // Instance Variables
    private int id;
    private String name;

    // Constructor
    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }
    // Getter Functions
    public int getId() { return id; }
    public String getName() { return name; }
}
