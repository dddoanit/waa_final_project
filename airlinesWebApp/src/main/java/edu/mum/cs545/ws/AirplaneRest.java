package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import cs545.airline.model.Airplane;
import cs545.airline.model.Flight;
import cs545.airline.service.AirplaneService;

@Named
@Path("airplane")
public class AirplaneRest {

	@Inject
	private AirplaneService airplaneService;

	@Path("create")
	@POST
	public void create(Airplane airplane) {
		airplaneService.create(airplane);
	}

	@Path("delete")
	@POST
	public void delete(Airplane airplane) {
		airplaneService.delete(airplane);
	}

	@Path("update")
	@POST
	public Airplane update(Airplane airplane) {
		return airplaneService.update(airplane);
	}

	@Path("find")
	@POST
	public Airplane find(Airplane airplane) {
		return airplaneService.find(airplane);
	}

	@Path("findBySrlnr")
	@GET
	public Airplane findBySrlnr(@QueryParam("serialno") String serialno) {
		return airplaneService.findBySrlnr(serialno);
	}

	@Path("findByFlight")
	@POST
	public List<Airplane> findByFlight(Flight flight) {
		return airplaneService.findByFlight(flight);
	}

	@Path("findByModel")
	@GET
	public List<Airplane> findByModel(@QueryParam("model") String model) {
		return airplaneService.findByModel(model);
	}

	@Path("findAll")
	@GET
	public List<Airplane> findAll() {
		return airplaneService.findAll();
	}
}
