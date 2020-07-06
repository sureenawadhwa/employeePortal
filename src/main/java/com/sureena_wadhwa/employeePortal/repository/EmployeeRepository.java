package com.sureena_wadhwa.employeePortal.repository;

import com.sureena_wadhwa.employeePortal.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {


}
