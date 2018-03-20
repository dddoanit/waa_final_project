package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.QueryParam;

import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirportService;

@Named
@Path("/airport")
public class AirportRest {
	@Inject
	private AirportService airportService;

	// Create a new port
	@POST
	@Path("/create")
	public Airport create(Airport airport) {
		airportService.create(airport);
		return airport;
	}

	// Delete airport
	@POST
	@Path("/delete")
	public void delete(Airport airport) {
		airportService.delete(airport);
	}

	// update airport
	@POST
	@Path("/update")
	public Airport update(Airport airport) {
		return airportService.update(airport);
	}

	// Find
	@POST
	@Path("/find")
	public Airport find(Airport airport) {
		return airportService.find(airport);

	}

	// Get airport by code
	@GET
	@Path("/findByCode")
	public Airport findByCode(@QueryParam("airportcode") String airportcode) {
		return airportService.findByCode(airportcode);
	}

	// Get all list of airports by arrival flight
	@POST
	@Path("/findByArrival")
	public List<Airport> findByArrival(Flight flight) {
		return airportService.findByArrival(flight);

	}

	// Get all list of airports by departure flight
	@POST
	@Path("/findByDeparture")
	public List<Airport> findByDeparture(Flight flight) {
		return airportService.findByDeparture(flight);

	}
	
	// Get list of airports by city
	@GET
	@Path("/findByCity")
	public List<Airport> findByCity(@QueryParam("city") String city) {
		return airportService.findByCity(city);
	}

	// Get list of airports by country
	@GET
	@Path("/findByCountry")
	public List<Airport> findByCountry(@QueryParam("country") String country) {
		return airportService.findByCountry(country);
	}

	// Get list of airport by name
	@GET
	@Path("/findByName")
	public List<Airport> findByName(@QueryParam("name") String name) {
		return airportService.findByName(name);
	}

	// Get list of airports
	@GET
	@Path("/findall")
	public List<Airport> findAll() {
		return airportService.findAll();

	}
}
