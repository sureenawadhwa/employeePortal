package com.sureena_wadhwa.employeePortal;

import com.sureena_wadhwa.employeePortal.commands.CreateEmployeeCommand;
import com.sureena_wadhwa.employeePortal.controllers.EmployeeController;
import com.sureena_wadhwa.employeePortal.entity.Employee;
import com.sureena_wadhwa.employeePortal.repository.EmployeeRepository;
import com.sureena_wadhwa.employeePortal.requests.CreateEmployeeRequest;
import com.sureena_wadhwa.employeePortal.service.EmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {

    private EmployeeService employeeService = mock(EmployeeService.class);

    private EmployeeController controller = new EmployeeController(employeeService);

    @Test
    public void should_call_service_test(){
        CreateEmployeeRequest request = mock(CreateEmployeeRequest.class);
        CreateEmployeeCommand command = mock(CreateEmployeeCommand.class);
        Employee employee = new Employee("Sureena","Wadhwa","Female","Technical");

        doReturn(command).when(request).toCommand();
        doReturn(employee).when(employeeService).saveEmployeeData(command);

        Employee created = controller.createEmployeeRecord(request);

        verify(employeeService, times(1)).saveEmployeeData(command);

    }

}

