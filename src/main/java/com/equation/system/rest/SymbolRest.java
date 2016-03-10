package com.equation.system.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.equation.system.model.Symbol;
import com.equation.system.rep.SymbolRep;

@Component
@Path("/symbols")
public class SymbolRest {
	
	private final static Logger log = LoggerFactory.getLogger(SymbolRest.class);
	
	@Inject
	SymbolRep symbolRep;
	
	@GET
	@Path("{symbol}")
	public Symbol getSymbol(@PathParam("symbol") String symbol) {
		log.debug("Looking for symbol {}", symbol);
		return new Symbol("symbol", "sss", "ffefe");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response addSymbol(Symbol symbol) {
		log.debug("Symbol to consume received: {}", symbol.getSymbol());
		try {
			symbolRep.save(symbol);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			log.error("There was an error storing symbol {} :: {}", symbol.getSymbol(), e);
			// maybe this is not best option, but this is just an example
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

}
