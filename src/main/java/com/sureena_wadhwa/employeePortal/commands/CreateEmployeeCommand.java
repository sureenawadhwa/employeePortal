package com.sureena_wadhwa.employeePortal.commands;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateEmployeeCommand {

    private String firstName;
    private String lastName;
    private String gender;
    private String department;

}
