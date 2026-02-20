package dev.employeeManagement.employeeRegister.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import dev.employeeManagement.employeeRegister.models.*;
import dev.employeeManagement.employeeRegister.repositories.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import dev.employeeManagement.employeeRegister.services.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import dev.employeeManagement.employeeRegister.models.*;
import dev.employeeManagement.employeeRegister.dto.*;
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @PostMapping
    public EmployeeModel save(@RequestBody EmployeeModel employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        employeeService.delete(id);
    }
    @PatchMapping("/{id}")
    public EmployeeModel update(@PathVariable Long id,@RequestBody EmployeeUpdateDto fields){
        return employeeService.update(id,fields);
    }
}
    

