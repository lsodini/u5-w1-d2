package LucaSodini.entities;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements MenuItem {
    private String name;
    private double price;
    private int calories;
    private List<Topping> toppings;

    public Pizza(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
        this.price += topping.getPrice();
        this.calories += topping.getCalories();
    }

    public String getToppingsAsString() {
        if (toppings.isEmpty()) {
            return "No toppings";
        }
        StringBuilder toppingsStr = new StringBuilder();
        for (Topping topping : toppings) {
            toppingsStr.append(topping.getName()).append(", ");
        }
        return toppingsStr.substring(0, toppingsStr.length() - 2);
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
        return name + " (" + getToppingsAsString() + ") - €" + price;
    }

}
