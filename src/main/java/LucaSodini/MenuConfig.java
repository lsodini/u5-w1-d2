package LucaSodini;

import LucaSodini.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class MenuConfig {

    private static final Logger logger = LoggerFactory.getLogger(MenuConfig.class);

    @Bean
    public Topping prosciutto() {
        return new Topping("Prosciutto", 2.0, 100);
    }

    @Bean
    public Topping ananas() {
        return new Topping("Ananas", 1.5, 50);
    }

    @Bean
    public Topping funghi() {
        return new Topping("Funghi", 1.0, 40);
    }

    @Bean
    public Pizza margherita() {
        Pizza pizza = new Pizza("Margherita", 5.0, 600);
        return pizza;
    }

    @Bean
    public Pizza hawaiianPizza() {
        Pizza pizza = new Pizza("Hawaiian", 5.0, 600);
        pizza.addTopping(prosciutto());
        pizza.addTopping(ananas());
        return pizza;
    }

    @Bean
    public Drink cola() {
        return new Drink("Cola", 2.0, 150);
    }

    @Bean
    public Drink acqua() {
        return new Drink("Acqua", 1.0, 0);
    }

    @Bean
    public Menu menu() {
        List<Pizza> pizzas = Arrays.asList(margherita(), hawaiianPizza());
        List<Drink> drinks = Arrays.asList(cola(), acqua());
        List<Topping> toppings = Arrays.asList(prosciutto(), ananas(), funghi());
        return new Menu(pizzas, drinks, toppings);
    }


    @Bean
    public CommandLineRunner runner(Menu menu) {
        return args -> {

            logger.info("Pizzeria Menu:");
            menu.stampaMenu();

            Tavolo tavolo1 = new Tavolo(1, 4, true); // Tavolo occupato
            Ordine ordine = new Ordine(tavolo1, 4, 1.5); // numero coperti e costo coperto

            ordine.aggiungiItem(menu.getPizzas().get(1)); // Hawaiian Pizza
            ordine.aggiungiItem(menu.getDrinks().get(0)); // Cola

            double importoTotale = ordine.calcolaTotale();
            logger.info("Ordine creato: \n" + ordine);
            logger.info("Importo totale dell'ordine: €" + importoTotale);
        };
    }
}
