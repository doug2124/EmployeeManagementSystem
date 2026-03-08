package dev.employeeManagement.employeeRegister.dto;

public class DepartmentPatchDto {
    private String name;
    private Integer employeeCount;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getEmployeeCount() {
        return employeeCount;
    }
    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }
}
