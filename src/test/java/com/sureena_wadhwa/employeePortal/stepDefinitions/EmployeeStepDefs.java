package com.sureena_wadhwa.employeePortal.stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sureena_wadhwa.employeePortal.GenderEnum;
import com.sureena_wadhwa.employeePortal.entity.Employee;
import com.sureena_wadhwa.employeePortal.repository.EmployeeRepository;
import com.sureena_wadhwa.employeePortal.requests.CreateEmployeeRequest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
@Slf4j
public class EmployeeStepDefs {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository repository;

    private String jsonRequestBody;

    @Given("^a user Sureena created an employee$")
    public void a_user_Sureena_created_an_employee() throws JsonProcessingException {
        CreateEmployeeRequest employeeRequest = new CreateEmployeeRequest("Sureena","Wadhwa", GenderEnum.FEMALE,"Technical", "18-10-97");
        jsonRequestBody = mapper.writeValueAsString(employeeRequest);
    }

    @When("^he saves the employee$")
    public void heSavesTheEmployee() throws Exception {
        RequestBuilder request = post("/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestBody);

        mockMvc.perform(request)
            .andExpect(status().isOk());
    }

    @Then("^the employee should be created$")
    public void theEmployeeShouldBeCreated() {
        Optional<Employee> maybeEmployee = repository.findById(1L);
        assertThat(maybeEmployee).isNotEmpty();
        assertThat(maybeEmployee.get().getFirstName()).isEqualToIgnoringCase("Sureena");
        assertThat(maybeEmployee.get().getLastName()).isEqualToIgnoringCase("Wadhwa");
        assertThat(maybeEmployee.get().getGender()).isEqualByComparingTo(GenderEnum.FEMALE);
        assertThat(maybeEmployee.get().getDepartment()).isEqualToIgnoringCase("Technical");

    }
}
