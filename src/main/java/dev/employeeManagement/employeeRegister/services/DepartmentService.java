package dev.employeeManagement.employeeRegister.services;
import dev.employeeManagement.employeeRegister.repositories.*;
import org.springframework.stereotype.*;
import java.util.*;
import dev.employeeManagement.employeeRegister.models.*;
import dev.employeeManagement.employeeRegister.dto.*;
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
    public void delete(Long id){
        departmentRepository.deleteById(id);
    }
    public DepartmentModel patch(Long id, DepartmentPatchDto entity){
        DepartmentModel department= departmentRepository
        .findById(id).orElseThrow(()-> new RuntimeException("Department not found"));
        if(entity.getName()!=null){
            department.setName(entity.getName());
        }if(entity.getEmployeeCount()!=null){
            department.setEmployeeCount(entity.getEmployeeCount());
        }
        return departmentRepository.save(department);
    }
}
