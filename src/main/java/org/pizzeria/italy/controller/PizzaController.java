package org.pizzeria.italy.controller;

import java.util.List;
import java.util.Optional;

import org.pizzeria.italy.pojo.Pizza;
import org.pizzeria.italy.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class PizzaController {

	@Autowired
	public PizzaService pizzaService;

	@GetMapping
	public String getPizzas(Model model) {

		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas", pizzas);

		return "index";
	}

	@GetMapping("/pizza/create")
	public String createNewPizza(Model model) {

		Pizza pizza = new Pizza();
		model.addAttribute("pizza", pizza);

		return "pizza-create";
	}

	@PostMapping("/pizza/create")
	public String storePizza(@Valid @ModelAttribute("pizza") Pizza pizza) {

		pizzaService.save(pizza);

		return "redirect:/";
	}

	@GetMapping("/pizza/edit/{id}")
	public String editPizza(@PathVariable("id") int id, Model model) {

		Optional<Pizza> optPizza = pizzaService.findPizzaById(id);
		Pizza pizza = optPizza.get();

		model.addAttribute("pizza", pizza);

		return "pizza-update";
	}

	@PostMapping("/pizza/edit")
	public String updatePizza(@Valid Pizza pizza) {

		pizzaService.save(pizza);

		return "redirect:/";
	}

	@GetMapping("/pizza/delete/{id}")
	public String deletePizza(@PathVariable("id") int id) {

		pizzaService.deleteById(id);

		return "redirect:/";
	}
}