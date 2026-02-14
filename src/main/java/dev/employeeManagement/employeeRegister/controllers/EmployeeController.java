package dev.employeeManagement.employeeRegister.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import dev.employeeManagement.employeeRegister.models.*;
import dev.employeeManagement.employeeRegister.repositories.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import dev.employeeManagement.employeeRegister.services.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @PostMapping
    public EmployeeModel save(@RequestBody EmployeeModel employee) {
        return employeeService.save(employee);
    }
}
    

