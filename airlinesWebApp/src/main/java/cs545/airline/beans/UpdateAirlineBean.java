package cs545.airline.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;
import java.io.Serializable;

@Named("updateAirlineBean")
@SessionScoped
public class UpdateAirlineBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AirlineService airlineService;
	
	private Airline airline;
	
	private String name;

	
	public String create() {
		airline = new Airline();
		airline.setName(name);
		this.airlineService.create(airline);
		return "airlineList";
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String editAirline(long id) {
		airline = new Airline();
		airline.setId(id);
		
		airline = airlineService.find(airline);
		return "3";
	}

	
}
