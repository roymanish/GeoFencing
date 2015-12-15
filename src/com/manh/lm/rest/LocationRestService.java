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


import com.manh.lm.domain.Location;
import com.manh.lm.dao.LocationlistService;
@Path("/location")
public class LocationRestService {
	
	@Path("/getLList")
	@GET
	@Produces({MediaType.APPLICATION_JSON })
	public List<Location> getlocations()
	{
		
		return new LocationlistService().getlocations();
	}

}
