package dev.employeeManagement.employeeRegister.services;
import dev.employeeManagement.employeeRegister.repositories.*;
import org.springframework.stereotype.*;
import java.util.*;
import dev.employeeManagement.employeeRegister.models.*;
@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentModel>getAllDepartments(){
        return departmentRepository.findAll();
    }
    public DepartmentModel save(DepartmentModel department){
        return departmentRepository.save(department);
    }
}
