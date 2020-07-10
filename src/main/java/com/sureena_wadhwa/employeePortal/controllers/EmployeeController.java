package com.sureena_wadhwa.employeePortal.controllers;

import com.sureena_wadhwa.employeePortal.commands.CreateEmployeeCommand;
import com.sureena_wadhwa.employeePortal.entity.Employee;
import com.sureena_wadhwa.employeePortal.requests.CreateEmployeeRequest;
import com.sureena_wadhwa.employeePortal.service.EmployeeService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeController {

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    private EmployeeService employeeService;

    @PostMapping(consumes = "application/json")
    public Employee createEmployeeRecord(@RequestBody CreateEmployeeRequest request) {
        log.info("Employee Controller [start]");
        Employee newEmployee = employeeService.saveEmployeeData(request.toCommand());
        log.info("Employee Controller [end]");
        return newEmployee;
    }

    @GetMapping()
    public List<Employee> getEmployeeList() {
        log.info("Employee Controller [start]");
        List<Employee> employeeList = employeeService.getAllEmployeeData();
        log.info("Employee Controller [end]");
        return employeeList;
    }
}
