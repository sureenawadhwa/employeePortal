package com.sureena_wadhwa.employeePortal.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Employee {

    private String firstName;

    @Id
    @GeneratedValue
    private Long id;

    public Employee(String firstName){
        this.firstName = firstName;
    }
}
