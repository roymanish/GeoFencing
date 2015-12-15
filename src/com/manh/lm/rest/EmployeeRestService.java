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

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.manh.lm.dao.EmployeeService;
import com.manh.lm.domain.Employee;
import com.manh.lm.exception.NoEmployeeFoundException;

@Path("/employeews")
public class EmployeeRestService {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {

		System.out.println("sayHTMLHello");

		return "<html> " + "<title>" + "Hello Employee" + "</title>"
		+ "<body><h1>" + "Hello Employee" + "</body></h1>" + "</html> ";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String saveData(String data) {

		System.out.println("POST saveData: -"+data+",");
		return "{}";

		
	}
	
	public static void main(String[] args) throws ParseException, JSONException {
		String str="{\"altitudeAccuracy\":null,\"id\":\"ext-record-7\",\"latitude\":12.9727097,\"altitude\":null,\"accuracy\":45,\"timestamp\":1406294377797,\"heading\":null,\"speed\":null,\"longitude\":77.7189504,\"description\":null,\"syncedWithServer\":null}";
		System.out.println(str);
		JSONObject json = (JSONObject)new JSONParser().parse(str);
		System.out.println(json.get("latitude"));
	}





	@Path("/getDetails/{emailAddress}")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes(MediaType.TEXT_PLAIN)
	public Employee getEmployee(@PathParam("emailAddress")String emailAddress) throws NoEmployeeFoundException {


		return new EmployeeService().getEmployeeDetails(emailAddress);
	}


	@Path("/addEmployee")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_XML)
	public Employee addEmployee(@QueryParam("employee")Employee employee) {

		System.out.println(employee.getName());
		new EmployeeService().addEmployee(employee);
		return employee;
	}


	@Path("/getList")
	@GET
	@Produces({MediaType.APPLICATION_JSON })
	public List<Employee> getEmployees()
	{

		return new EmployeeService().getEmployees();
	}
}
