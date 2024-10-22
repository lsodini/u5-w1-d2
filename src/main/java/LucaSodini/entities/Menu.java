package LucaSodini.entities;

import java.util.List;

public class Menu {
    private List<Pizza> pizzas;
    private List<Drink> drinks;
    private List<Topping> toppings;

    public Menu(List<Pizza> pizzas, List<Drink> drinks, List<Topping> toppings) {
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.toppings = toppings;
    }

    public void stampaMenu() {

        System.out.println("Pizzas:");
        for (Pizza pizza : pizzas) {
            System.out.println(pizza + " (" + pizza.getCalories() + " kcal)");
        }

        System.out.println("\nDrinks:");
        for (Drink drink : drinks) {
            System.out.println(drink + " (" + drink.getCalories() + " kcal)");
        }

        System.out.println("\nAvailable Toppings:");
        for (Topping topping : toppings) {
            System.out.println(topping.getName() + " - €" + topping.getPrice() + " (" + topping.getCalories() + " kcal)");
        }
    }

    // Getter e setter
    public List<Pizza> getPizzas() { return pizzas; }
    public List<Drink> getDrinks() { return drinks; }
    public List<Topping> getToppings() { return toppings; }

    public void setPizzas(List<Pizza> pizzas) { this.pizzas = pizzas; }
    public void setDrinks(List<Drink> drinks) { this.drinks = drinks; }
    public void setToppings(List<Topping> toppings) { this.toppings = toppings; }
}
