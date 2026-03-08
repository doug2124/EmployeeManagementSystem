package dev.employeeManagement.employeeRegister.services;

import org.springframework.stereotype.Service;
import dev.employeeManagement.employeeRegister.repositories.*;
import dev.employeeManagement.employeeRegister.models.*;
import java.util.*;
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
    public EmployeeModel patch(long id, EmployeeUpdateDto fields){
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
    public EmployeeModel update(Long id, EmployeeModel entity){
        return employeeRepository.findById(id).map(employee->{
            employee.setFirstName(employee.getFirstName());
            employee.setLastName(employee.getLastName());
            employee.setEmail(employee.getEmail());
            employee.setPassword(employee.getPassword());
            employee.setRole(employee.getRole());
            employee.setPhoneNumber(employee.getPhoneNumber());
            employee.setAge(employee.getAge());
            employee.setDepartment(employee.getDepartment());
            employee.setSalary(employee.getSalary());
            return employeeRepository.save(entity);
        }).orElseGet(()->{
            entity.setId(id);
            return employeeRepository.save(entity);
        });
    }
}
