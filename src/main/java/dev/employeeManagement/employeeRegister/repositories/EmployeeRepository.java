package dev.employeeManagement.employeeRegister.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.employeeManagement.employeeRegister.models.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
}
