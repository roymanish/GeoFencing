package com.manh.lm.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;





@Path("/map")
public class MapWS {


	
	@GET
	
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Map<String, String> getMap()
	{
		Map<String, String> selectedParameterMap=new HashMap<String, String>();
		selectedParameterMap.put("Key1", "Value1");
		selectedParameterMap.put("Key2", "Value2");
		selectedParameterMap.put("Key3", "Value3");
		selectedParameterMap.put("Key4", "Value4");
		
		
		return selectedParameterMap;
	}


} 