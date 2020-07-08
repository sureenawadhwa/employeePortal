Feature: To get all Employee Data
  As a user
  I should be able to see all the employee details
  in ascending order by first name

  Scenario: Get all employees data
    Given there is employee data in database
    When list of employee data is fetched
    Then list of Employees should be fetched