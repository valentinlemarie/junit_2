package dev.diginamic.pizza;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.services.AuRevoirService;

public class testAuRevoirService {



	@Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	
	
	@Test
	public void testAurevoirService() {
		IPizzaDao pizza = new PizzaMemDao();
		AuRevoirService auRevoirService = new AuRevoirService();
		auRevoirService.executeUC(new Scanner(System.in), pizza);
		assertTrue(systemOutRule.getLog().equals("Au revoir\r\n"));

	}

}
