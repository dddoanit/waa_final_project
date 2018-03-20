package cs545.airline.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;
import java.io.Serializable;
import java.util.List;

@Named("listAirlineBean")
@SessionScoped
public class ListAirlineBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AirlineService airlineService;

	public List<Airline> getAirlines() {
		return airlineService.findAll();
	}

}
