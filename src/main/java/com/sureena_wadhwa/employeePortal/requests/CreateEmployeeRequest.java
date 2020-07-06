package com.sureena_wadhwa.employeePortal.requests;

import com.sureena_wadhwa.employeePortal.commands.CreateEmployeeCommand;
import lombok.Getter;

@Getter
public class CreateEmployeeRequest {

    private String firstName;

    public CreateEmployeeCommand toCommand() {
        return CreateEmployeeCommand.builder()
                .firstName(firstName)
                .build();
    }

}
