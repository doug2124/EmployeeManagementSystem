package dev.employeeManagement.employeeRegister.services;

import java.util.List;

import org.springframework.stereotype.Service;
import dev.employeeManagement.employeeRegister.repositories.*;
import dev.employeeManagement.employeeRegister.models.*;
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
}
