package com.sureena_wadhwa.employeePortal.config;

import com.sureena_wadhwa.employeePortal.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public EmployeeService employeeService(){
        return new EmployeeService();
    }
}
