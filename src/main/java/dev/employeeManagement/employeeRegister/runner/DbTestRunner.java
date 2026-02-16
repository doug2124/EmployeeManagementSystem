package dev.employeeManagement.employeeRegister.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import dev.employeeManagement.employeeRegister.repositories.*;

@Component
public class DbTestRunner implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Testing connnection to DB...");

        employeeRepository.findAll().forEach(e -> {
            System.out.println(e.getFirstName() + " " + e.getLastName());
        });
    }
}
