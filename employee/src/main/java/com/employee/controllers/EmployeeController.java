package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.employee.entities.Employee;
import com.employee.services.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.employee.entities.Employee;
import com.employee.services.EmployeeService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/employee")
@ResponseBody
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @PostMapping("/register")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee emp) {
        Employee savedEmployee = empService.save(emp);
        return ResponseEntity.ok(savedEmployee);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Employee> update(@Valid @RequestBody Employee emp, @PathVariable("id") int empId) {
        Employee updatedEmployee = empService.update(emp, empId);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> view() {
        List<Employee> employees = empService.view();
        return ResponseEntity.ok(employees);
    }
}

