package cs545.airline.beans;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

@Named
public class ListFlightBean {
	@Inject
	private FlightService flightService;
	
	public List<Flight> getFlights() {
		return flightService.findAll();
	}
}
