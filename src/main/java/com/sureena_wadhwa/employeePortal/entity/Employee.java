package com.sureena_wadhwa.employeePortal.entity;

import com.sureena_wadhwa.employeePortal.GenderEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    private String firstName;
    private String lastName;
    private GenderEnum gender;
    private String department;
    private LocalDate dateOfBirth;

    @Id
    @GeneratedValue
    private Long employeeId;

    public Employee(String firstName,String lastName,GenderEnum gender,String department,LocalDate dateOfBirth)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
    }
}
