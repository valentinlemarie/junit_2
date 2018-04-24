package dev.diginamic.pizza;
import static org.junit.Assert.*;

import java.awt.image.DataBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class TestPizzaMenDao {

	PizzaMemDao data;
	@Before
	public void setUp(){
		data = new PizzaMemDao();
	}

	@Test
	public void testfindAllPizzas1() {
		assertTrue(data.findAllPizzas().size() == 8);
	}
	
	@Test
	public void testsaveNewPizza() {
		int taille_courante  = data.findAllPizzas().size();
		Pizza pizza = new Pizza("TES" , "pizzaTest", 5.0d);
		data.saveNewPizza(pizza);
		assertTrue( data.findAllPizzas().size() == taille_courante+1);
	}
	
	@Test
	public void testupdatePizza() {
		Pizza pizza = new Pizza("TES" , "change", 5.0d);
		data.updatePizza("PEP", pizza);
		assertTrue(data.findAllPizzas().contains(pizza));
	}
	
	@Test
	public void testdeletePizza(){
		Pizza pizza = new Pizza("TES" , "pizzaTest", 5.0d);
		data.saveNewPizza(pizza);
		int taille_courante  = data.findAllPizzas().size();
		data.deletePizza("TES");
		assertTrue( data.findAllPizzas().size() == taille_courante-1);
	}
	

}
