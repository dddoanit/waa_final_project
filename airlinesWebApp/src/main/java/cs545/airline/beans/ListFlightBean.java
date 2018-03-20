package cs545.airline.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;

@Named("listFlightBean")
@SessionScoped
public class ListFlightBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long airlineId;
	
	private Date departureDate;
	private Date departureTime;
	
	private long destinationId;
	
	@Inject
	private FlightService flightService;
	
	@Inject
	private AirplaneService airplaneService;
	
	@Inject
	private AirportService airportService;
	
	@Inject
	private AirlineService airlineService;
	
	public List<Flight> getFlights() {
		return flightService.findAll();
	}
	
	public List<Airline> getAirlines() {
		return airlineService.findAll();
	}
	
	public List<Airport> getAirports() {
		return airportService.findAll();
	}

	public long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(long airlineId) {
		this.airlineId = airlineId;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public long getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(long destinationId) {
		this.destinationId = destinationId;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	
	public void search() {
		System.out.println(this.departureDate);
		System.out.println(this.departureTime);
		System.out.println("ListFlightBean.search()");
	}
	
	public void clear() {
		System.out.println("ListFlightBean.clear()");
	}
	
}
