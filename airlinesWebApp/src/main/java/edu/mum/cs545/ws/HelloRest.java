package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;

@Named
@Path("hello")
public class HelloRest {

	@Inject
	private AirlineService airlineService;

	@GET
	public String helloWorld(@DefaultValue("Gorgeous") @QueryParam("name") String name) {
		return "Hello " + name + "!";
	}


	
	@Path("airline")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Airline getAirlineTest() {
		String result = "Nil!";
		Airline airline = airlineService.findByName("SkyTeam");
		if (airline != null) {
			//result = "This is an airline: " + airline.getId()+"  "+ airline.getName();
			//result = "This is an airline: " + airline.getName();
		}
		return airline;
	}
	


}
