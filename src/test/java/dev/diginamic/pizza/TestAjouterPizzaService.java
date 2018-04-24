package dev.diginamic.pizza;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.services.AjouterPizzaService;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.util.Scanner;

public class TestAjouterPizzaService {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test
	public void testAjoutPizzaService() {
		
		IPizzaDao pizza = new PizzaMemDao();
		Pizza testPizza = new Pizza("TES", "piment", 10);
		systemInMock.provideLines("TES","piment","10");
		AjouterPizzaService ajouterPizzaService = new AjouterPizzaService();
		ajouterPizzaService.executeUC(new Scanner(System.in),pizza);
		assertTrue(pizza.findAllPizzas().contains(testPizza) );
	}

}
