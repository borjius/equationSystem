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
import com.equation.system.model.Equation;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EquationSystem.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
public class EquationRepIT {
	
	@Autowired
	private EquationRep equationRep;
	
	@Test
	public void testFindByAuthor() throws Exception {
		Equation equation = new Equation("Jon", "3 mult 2");
		Equation equation2 = new Equation("James", "3 div 2");
		equationRep.save(equation);
		equationRep.save(equation2);
		assertEquals("Number of elements in db incorrect", 2, equationRep.count());
		List<Equation> equationsByJon = equationRep.findByAuthor("Jon");
		assertEquals("Number of equations by Jon incorrect", 1, equationsByJon.size());
		assertEquals("Element extracted by author incorrect", "3 mult 2", equationsByJon.get(0).getDescription());
		List<Equation> equationsByJames = equationRep.findByAuthor("James");
		assertEquals("Number of equations by James incorrect", 1, equationsByJames.size());
		assertEquals("Element extracted by author incorrect", "3 div 2", equationsByJames.get(0).getDescription());
	}

}
