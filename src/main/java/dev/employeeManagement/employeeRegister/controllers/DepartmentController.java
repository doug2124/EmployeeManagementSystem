package dev.employeeManagement.employeeRegister.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.employeeManagement.employeeRegister.models.DepartmentModel;
import dev.employeeManagement.employeeRegister.repositories.DepartmentRepository;
import dev.employeeManagement.employeeRegister.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;
import dev.employeeManagement.employeeRegister.models.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public List<DepartmentModel> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
    @PostMapping
    public DepartmentModel save(@RequestBody DepartmentModel department) {
        return departmentService.save(department);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        departmentService.delete(id);
    }
}
