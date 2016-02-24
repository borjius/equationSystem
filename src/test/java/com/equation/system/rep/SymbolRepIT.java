package com.equation.system.rep;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.equation.system.EquationSystem;
import com.equation.system.model.Symbol;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EquationSystem.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
public class SymbolRepIT {
	
	@Autowired
	private SymbolRep symbolRep;
	
	@Test
	public void testFindBySymbol() throws Exception {
		Symbol symbol = new Symbol("test", "test", "test");
		symbolRep.save(symbol);
		assertEquals("Element was not correctly saved", 1, symbolRep.count());
		List<Symbol> symbolRetrieved = symbolRep.findBySymbol("test");
		assertEquals("Element was not correctly saved", 1, symbolRetrieved.size());
		assertEquals("Element was not correctly saved", "test", symbolRetrieved.get(0).getSymbol());
	}

}
