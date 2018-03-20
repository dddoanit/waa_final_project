package edu.mum.cs545.ws;

import java.net.HttpURLConnection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;

@Stateless
@Path("/airport")
public class AirportRest {
	@Inject
	private AirportService airportService;

	JsonArrayBuilder builder = Json.createArrayBuilder();

	// Get all list of airports
	@GET
	public Response getAllAirports() {
		List<Airport> airports = airportService.findAll();
		GenericEntity<List<Airport>> airportWrapper = new GenericEntity<List<Airport>>(airports) {};
		return Response.ok(airportWrapper).build();
	}
	// Get airport by id
	@GET
	@Path("/{id}")
	public Response getAirport(@PathParam("id") long id) {
		Airport airport = new Airport();
		airport.setId(id);
		Airport resultAirport = airportService.find(airport);
		if (resultAirport != null) {
			return Response.ok(airport).build();
		} else {
			return Response.noContent().build();
		}
	}
	// Get airport by name
	@GET
	@Path("/name/{name}")
	public Response getAirportbyName(@PathParam("name") String name) {
		if (name == null) {
			throw new WebApplicationException(
					Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity("Name is required.").build());
		}
		List<Airport> airports = airportService.findByName(name);
		if (!airports.isEmpty()) {
			GenericEntity<List<Airport>> airportWrapper = new GenericEntity<List<Airport>>(airports) {};
			return Response.ok(airportWrapper).build();
		} else {
			return Response.noContent().build();
		}
	}
	// Get airport by city
	@GET
	@Path("/city/{city}")
	public Response getAirportbyCity(@PathParam("city") String city) {
		if (city == null) {
			throw new WebApplicationException(
					Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity("City is required.").build());
		}
		List<Airport> airports = airportService.findByCity(city);
		if (!airports.isEmpty()) {
			GenericEntity<List<Airport>> airportWrapper = new GenericEntity<List<Airport>>(airports) {};
			return Response.ok(airportWrapper).build();
		} else {
			return Response.noContent().build();
		}
	}
	// Create a new port
	@POST
	public Response saveAirport(final Airport airport) {
		airportService.create(airport);
		return Response.ok(airport).build();
	}

}
