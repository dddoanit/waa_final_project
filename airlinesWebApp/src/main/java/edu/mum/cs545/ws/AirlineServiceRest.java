package edu.mum.cs545.ws;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;

@Named
@Path("/airline")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class AirlineServiceRest {

	@Inject
	private AirlineService airlineService;

	@POST
	@Path("/create")
	public void create(Airline airport) {
		airlineService.create(airport);
	}

	@POST
	@Path("/delete")
	public void delete(Airline airport) {
		airlineService.delete(airport);
	}

	@POST
	@Path("/update")
	public Airline update(Airline airport) {
		return airlineService.update(airport);
	}

	@POST
	@Path("/find")
	public Airline find(Airline airport) {
		return airlineService.find(airport);
	}

	@GET
	@Path("/findByName")
	public Airline findByName(@QueryParam("name") String name) {
		return airlineService.findByName(name);
	}

	@POST
	@Path("/findByFlight")
	public List<Airline> findByFlight(Flight flight) {
		return airlineService.findByFlight(flight);
	}

	@GET
	@Path("/findAll")
	public List<Airline> findAll() {
		return airlineService.findAll();
	}
}
