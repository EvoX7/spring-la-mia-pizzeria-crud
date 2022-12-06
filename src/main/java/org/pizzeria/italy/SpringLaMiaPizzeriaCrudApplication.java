package org.pizzeria.italy;

import org.pizzeria.italy.pojo.Drink;
import org.pizzeria.italy.pojo.Pizza;
import org.pizzeria.italy.service.PizzaService;
import org.pizzeria.italy.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private DrinkService drinkService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Pizza p1 = new Pizza("Margherita", "Pizza classica", 7);
		Pizza p2 = new Pizza("4 formaggi", "La più buona", 10);
		Pizza p3 = new Pizza("Napoletana", "Per gli amanti", 8);
		Pizza p4 = new Pizza("Calzone", "Ripieno classico", 9);
		Pizza p5 = new Pizza("Bismark", "La tedesca", 11);

		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		pizzaService.save(p5);

		Drink d1 = new Drink("Negroni", "Un classico", 7);
		Drink d2 = new Drink("Manhattan", "Quello glamour", 10);
		Drink d3 = new Drink("Moscow Mule", "Per i temerari", 8);
		Drink d4 = new Drink("Mojito", "Aria esotica", 7);
		Drink d5 = new Drink("Gin Tonic", "Leggero", 4);

		drinkService.save(d1);
		drinkService.save(d2);
		drinkService.save(d3);
		drinkService.save(d4);
		drinkService.save(d5);

	}

}
