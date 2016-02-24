package com.equation.system.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Symbol {
	
	@Id
	private String symbol;
	private String operator;
	private String description;
	
	protected Symbol() {}
	
	public Symbol(String symbol, String operator, String description) {
		this.symbol = symbol;
		this.operator = operator;
		this.description = description;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getOperator() {
		return operator;
	}

	public String getDescription() {
		return description;
	}
	

}
