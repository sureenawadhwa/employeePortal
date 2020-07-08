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
import jdk.nashorn.internal.parser.JSONParser;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    private String jsonResponse;

    @Given("^a user Sureena created an employee$")
    public void a_user_Sureena_created_an_employee() throws IOException {
        File file = ResourceUtils.getFile("classpath:templates/createEmployeeRequest.json");
        jsonRequestBody =  new String(Files.readAllBytes(file.toPath()));
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
        assertThat(maybeEmployee.get().getFirstName()).isEqualToIgnoringCase("Frank");
        assertThat(maybeEmployee.get().getLastName()).isEqualToIgnoringCase("Kelly");
        assertThat(maybeEmployee.get().getGender()).isEqualByComparingTo(GenderEnum.MALE);
        assertThat(maybeEmployee.get().getDepartment()).isEqualToIgnoringCase("Technical");

    }

    @Given("^there is employee data in database$")
    public void thereIsEmployeeDataInDatabase() {
        Employee employee1 = new Employee("Frank","Kelly",GenderEnum.MALE,"Technical",LocalDate.parse("1997-10-18"));
        Employee employee2 = new Employee("Rachel","Smith",GenderEnum.FEMALE,"Asset Management",LocalDate.parse("1990-10-09"));
        repository.save(employee1);
        repository.save(employee2);
    }

    @When("^list of employee data is fetched$")
    public void listOfEmployeeDataIsFetched() throws Exception {
        RequestBuilder request = get("/employee");
         jsonResponse = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Then("^list of Employees should be fetched$")
    public void listOfEmployeesShouldBeFetched() throws IOException, JSONException {
        File file = ResourceUtils.getFile("classpath:templates/allEmployeeDataResponse.json");
        String jsonRequest =  new String(Files.readAllBytes(file.toPath()));
        JSONAssert.assertEquals(jsonResponse,jsonRequest,true);

    }
}
