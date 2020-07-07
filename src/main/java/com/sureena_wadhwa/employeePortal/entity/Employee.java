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

    @Id
    @GeneratedValue
    private Long employeeId;

    public Employee(String firstName)
    {
        this.firstName = firstName;
    }
}
