Feature: To create an employee
    As a user
    I should be able to Register an employee and employee details

    Scenario: Create an Employee
        Given a user Sureena created an employee
        When he saves the employee
        Then the employee should be created
