package cs545.airline.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

@Named("listFlightBean")
@SessionScoped
public class ListFlightBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FlightService flightService;
	
	public List<Flight> getFlights() {
		return flightService.findAll();
	}
}
