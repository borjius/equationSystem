package com.equation.system.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.equation.system.model.Equation;

public interface EquationRep extends CrudRepository<Equation, Long>  {
	
	List<Equation> findByAuthor(String author);

}
