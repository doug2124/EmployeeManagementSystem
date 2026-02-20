package dev.employeeManagement.employeeRegister.services;

import org.springframework.stereotype.Service;
import dev.employeeManagement.employeeRegister.repositories.*;
import dev.employeeManagement.employeeRegister.models.*;
import java.util.*;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import dev.employeeManagement.employeeRegister.dto.*;
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public EmployeeModel save(EmployeeModel employee) {
        return employeeRepository.save(employee);
    }
    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
    public EmployeeModel update(long id, EmployeeUpdateDto fields){
        EmployeeModel employee=employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found with id "+id));
        if(fields.getFirstName()!=null){
            employee.setFirstName(fields.getFirstName());
        }
        if(fields.getLastName()!=null){
            employee.setLastName(fields.getLastName());
        }
        if(fields.getEmail()!=null){
            employee.setEmail(fields.getEmail());
        }
        if(fields.getPassword()!=null){
            employee.setPassword(fields.getPassword());
        }
        if(fields.getRole()!=null){
            employee.setRole(fields.getRole());
        }
        if(fields.getPhoneNumber()!=null){
            employee.setPhoneNumber(fields.getPhoneNumber());
        }
        if(fields.getAge()!=null){
            employee.setAge(fields.getAge());
        }
        if(fields.getDepartment()!=null){
            employee.setDepartment(fields.getDepartment());
        }
        if(fields.getSalary()!=null){
            employee.setSalary(fields.getSalary());
        }
        employeeRepository.findById(id).ifPresent((emp)->{
            employeeRepository.save(employee);
    });
    return employeeRepository.save(employee);
    }
}
