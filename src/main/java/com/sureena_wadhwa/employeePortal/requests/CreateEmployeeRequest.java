package com.sureena_wadhwa.employeePortal.requests;

import com.sureena_wadhwa.employeePortal.GenderEnum;
import com.sureena_wadhwa.employeePortal.commands.CreateEmployeeCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

    private String firstName;
    private String lastName;
    private GenderEnum gender;
    private String department;

    public CreateEmployeeCommand toCommand() {
        return CreateEmployeeCommand.builder()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .department(department)
                .build();
    }

}
