package com.employee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entities.Employee;
import com.employee.exceptions.NotFoundException;
import com.employee.repositories.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo empRepo;

    @Override
    public Employee save(Employee emp) {
        return empRepo.save(emp);
    }

    @Override
    public Employee update(Employee emp, Integer empId) {
        Optional<Employee> optionalEmployee = empRepo.findById(empId);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            emp.setId(existingEmployee.getId());
            return empRepo.save(emp);
        } else {
            throw new NotFoundException("Employee with ID " + empId + " not found");
        }
    }

    @Override
    public List<Employee> view() {
        return empRepo.findAll();
    }
}
