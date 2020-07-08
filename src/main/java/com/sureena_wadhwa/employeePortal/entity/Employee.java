package com.sureena_wadhwa.employeePortal.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    private String firstName;
    private String lastName;
    private String gender;
    private String department;

    @Id
    @GeneratedValue
    private Long employeeId;

    public Employee(String firstName,String lastName,String gender,String department)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.department = department;
    }
}
