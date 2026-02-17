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


@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentService departmentService,DepartmentRepository departmentRepository) {
        this.departmentService = departmentService;
        this.departmentRepository = departmentRepository;
    }
    @GetMapping
    public List<DepartmentModel> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
    @PostMapping
    public DepartmentModel save(@RequestBody DepartmentModel department) {
        return departmentService.save(department);
    }
}
