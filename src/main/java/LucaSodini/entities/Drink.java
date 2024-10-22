package LucaSodini.entities;

public class Drink implements MenuItem {
    private String name;
    private double price;
    private int calories;

    public Drink(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return name + " - €" + price;
    }

}
