package com.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entities.Employee;
import com.employee.repositories.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo empRepo;

	@Override
	public Employee save(Employee emp) {
		Employee save = empRepo.save(emp);
		return save;
	}

	@Override
	public Employee update(Employee emp, Integer empId) {
		Employee employee = empRepo.findById(empId).get();
		emp.setId(employee.getId());
		Employee save = empRepo.save(emp);

		return save;
	}

	@Override
	public List<Employee> view() {

		List<Employee> all = empRepo.findAll();
		return all;
	}

}
