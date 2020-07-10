package com.sureena_wadhwa.employeePortal.commands;

import com.sureena_wadhwa.employeePortal.GenderEnum;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CreateEmployeeCommand {

    private String firstName;
    private String lastName;
    private GenderEnum gender;
    private String department;
    private LocalDate dateOfBirth;



}
