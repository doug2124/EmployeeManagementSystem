package dev.employeeManagement.employeeRegister.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.employeeManagement.employeeRegister.models.DepartmentModel;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {
    
}
