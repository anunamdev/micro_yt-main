package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.entities.Employee;
import com.employee.services.EmployeeService;

@Controller
@RequestMapping("/employee")
@ResponseBody
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	@PostMapping("/register")
	public Employee save(Employee emp) {
		Employee save = empService.save(emp);
		return save;
	}

	@PostMapping("/edit/{id}")
	public Employee update(Employee emp, @RequestParam int empId) {
		Employee update = empService.update(emp, empId);
		return update;
	}

	@GetMapping("/list")
	public List<Employee> view() {
		List<Employee> view = empService.view();
		return view;
	}

}
