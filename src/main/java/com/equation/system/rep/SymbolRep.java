package com.equation.system.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.equation.system.model.Symbol;

public interface SymbolRep extends CrudRepository<Symbol, Long> {
	
	List<Symbol> findBySymbol(String symbol);
	
}
