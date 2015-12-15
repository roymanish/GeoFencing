package com.manh.lm.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.manh.lm.domain.Employee;





@Path("/hello")
public class Hello {


	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {

		return "Hello Jersey - Plain" + new Date();
	}
	@GET
	@Path("/map")
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

/*
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}*/

	
	

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey HTML- " +new Date()+ "</body></h1>" + "</html> ";
	}


	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Employee getEmployee() {

		Employee employee=new Employee(1, "ravi shekhar", "rshekhar");
		return employee;
	}

} 