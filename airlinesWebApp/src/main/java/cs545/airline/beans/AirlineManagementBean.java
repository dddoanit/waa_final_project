package cs545.airline.beans;

//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

@Named
@SessionScoped
public class AirlineManagementBean {
	
	@Inject
	private AirlineService airlineService;
	
	private Airline airline;

	public AirlineManagementBean() {}
	
	public String create() {
		this.airlineService.create(airline);
		return "success";
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

}
