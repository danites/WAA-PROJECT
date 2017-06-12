package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
@Path("/airline")
public class AirlineWebService {
	
	@Inject
	private AirlineService airlineService;

	@POST
	@Path("/create")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public void create(Airline airport) {
		airlineService.create(airport);
	}
	@DELETE
	@Path("/{deleteId}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public void delete(@PathParam("deleteId") long deleteId, Airline airport) {
		airport.setId(deleteId);
		airlineService.delete(airport);
	}
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Airline update(Airline airport) {
		return airlineService.update(airport);
	}
	@GET
	@Path("/find")
	@Produces({MediaType.APPLICATION_JSON})
	public Airline find(Airline airline) {
		return airlineService.find(airline);
	}
	
	@GET
	@Path("findbyname")
	@Produces({MediaType.APPLICATION_JSON})
	public Airline findByName(@QueryParam("findbyname") String findbyname) {
		return airlineService.findByName(findbyname);
	}
	@GET
	@Path("/findbyflight")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Airline> findByFlight(Flight flight) {
		return airlineService.findByFlight(flight);
	}
	@GET
	@Path("/findall")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Airline> findAll() {
		return airlineService.findAll();
	}
}
