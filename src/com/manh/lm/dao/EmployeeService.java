package com.manh.lm.dao;

import java.util.ArrayList;
import java.util.List;

import com.manh.lm.domain.Employee;
import com.manh.lm.exception.NoEmployeeFoundException;

public class EmployeeService {

	private static List<Employee> employeeList=new ArrayList<Employee>();

	static
	{
		Employee employee=new Employee(1, "Ravi Shekhar", "rshekhar");
		employeeList.add(employee);

		employee=new Employee(1, "Manish", "maroy");
		employeeList.add(employee);


		employee=new Employee(2, "Gangina", "gaprasad");
		employeeList.add(employee);


		employee=new Employee(3, "Suresh", "suresh");
		employeeList.add(employee);


		employee=new Employee(4, "Rahul", "rdev");
		employeeList.add(employee);
	}


	public List<Employee> getEmployees()
	{
		System.out.println("getEmployees Called");
		return employeeList;
	}

	public void addEmployee(Employee employee) {

		System.out.println("Adding ..."+employee.getName());
		employeeList.add(employee);
	}

	public Employee getEmployeeDetails(String emailAddress) throws NoEmployeeFoundException {

		System.out.println("Finding employee with email = "+emailAddress);

		for(Employee e:employeeList)
		{
			if(e.getEmail()!=null && e.getEmail().equalsIgnoreCase(emailAddress))
				return e;
		}
		System.out.println("No employee found");
		throw new NoEmployeeFoundException("No employee found with email = "+emailAddress);
	}


}
