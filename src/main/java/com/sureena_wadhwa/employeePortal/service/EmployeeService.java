package com.sureena_wadhwa.employeePortal.service;

import com.sureena_wadhwa.employeePortal.commands.CreateEmployeeCommand;
import com.sureena_wadhwa.employeePortal.entity.Employee;
import com.sureena_wadhwa.employeePortal.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployeeData(CreateEmployeeCommand command) {
        log.info("EmployeeService [start]");
        Employee employee = new Employee(command.getFirstName(),command.getLastName(),command.getGender(),command.getDepartment());
        Employee newEmployee = employeeRepository.save(employee);
        log.info("EmployeeService [end]");
        return newEmployee;
    }

}
