package com.sureena_wadhwa.employeePortal.repository;

import com.sureena_wadhwa.employeePortal.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    public Employee save(Employee employee);

    public List<Employee> findAllByOrderByFirstNameAsc();

}
