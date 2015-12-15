package com.manh.lm.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import com.manh.lm.domain.Coordinates;

import com.manh.lm.dao.CoordinatelistService;


@Path("/coordinates")
public class CoordinatesRestService {
	
	@Path("/getcoordinatelist")
	@GET
	@Produces({MediaType.APPLICATION_JSON })
	public List<Coordinates> getcoordinates()
	{
		
		return new CoordinatelistService().getcoordinates();
	}
	
	@Path("/getFacilitycoordinatelist")
	@GET
	@Produces({MediaType.APPLICATION_JSON })
	public Coordinates getFacilitycoordinates(String facilityName)
	{
		System.out.println("Hello");
		return new CoordinatelistService().getFacilityCoordinatesList(facilityName);
	}

}
