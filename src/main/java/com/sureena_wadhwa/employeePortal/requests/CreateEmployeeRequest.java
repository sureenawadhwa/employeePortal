package com.sureena_wadhwa.employeePortal.requests;

import com.sureena_wadhwa.employeePortal.GenderEnum;
import com.sureena_wadhwa.employeePortal.commands.CreateEmployeeCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

    private String firstName;
    private String lastName;
    private GenderEnum gender;
    private String department;
    private String dateOfBirth;

    public CreateEmployeeCommand toCommand() {
        return CreateEmployeeCommand.builder()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .department(department)
                .dateOfBirth(dateOfBirth.length() != 0 ? LocalDate.parse(dateOfBirth) : null)
                .build();
    }

}
