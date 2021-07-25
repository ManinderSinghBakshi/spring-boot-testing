package com.ongrid.nexusTesting.service;

import com.ongrid.nexusTesting.model.Employee;
import com.ongrid.nexusTesting.repository.EmployeeRepository;
import com.ongrid.nexusTesting.service.object.AddEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(AddEmployeeRequest request) {
        if(employeeRepository.checkEmailExists(request.getEmail()))
            throw new RuntimeException("Email already taken");
        Employee employee = new Employee(request.getName(), request.getEmail(), request.getGender());
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
