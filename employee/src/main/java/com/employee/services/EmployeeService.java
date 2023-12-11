package com.employee.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.entities.Employee;

public interface EmployeeService {
	Employee save(Employee emp);
	Employee update(Employee emp,Integer empId);
	List<Employee> view();
	
	

}
