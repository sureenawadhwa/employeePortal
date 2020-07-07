package com.sureena_wadhwa.employeePortal.requests;

import com.sureena_wadhwa.employeePortal.commands.CreateEmployeeCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

    private String firstName;

    public CreateEmployeeCommand toCommand() {
        return CreateEmployeeCommand.builder()
                .firstName(firstName)
                .build();
    }

}
