package com.equation.system.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="symbology")
@Entity
public class Symbol {
	
	@Id
	@XmlElement
	private String symbol;
	@XmlElement
	private String operator;
	@XmlElement
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
