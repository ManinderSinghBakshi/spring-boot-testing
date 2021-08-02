package com.ongrid.nexusTesting.service;

import com.ongrid.nexusTesting.model.Employee;
import com.ongrid.nexusTesting.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if(employeeRepository.checkEmailExists(employee.getEmail()))
            throw new RuntimeException("Email " + employee.getEmail() + " taken");
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        if(!employeeRepository.existsById(employeeId))
            throw new RuntimeException("No employee found with this Id");
        employeeRepository.deleteById(employeeId);
    }
}
