package com.equation.system.rest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.equation.system.EquationSystem;
import com.equation.system.model.Symbol;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EquationSystem.class)
@WebAppConfiguration
@IntegrationTest({"server.port=8080"}) // random port to start tomcat
public class SymbolRestIT {
	
	@Test
	public void postASymbol() {
		given().contentType("application/xml").body(new Symbol("Symbol", "Operator", "Descriptor2")).expect().statusCode(200).when().post("/symbols");
	}
	
	@Test
	public void getASymbol() {
		// include one symbol and find it
		postASymbol();
		given().pathParameter("symbol", "Symbol").expect().body(containsString("Descriptor2")).when().get("/symbols/{symbol}");
	}

}
