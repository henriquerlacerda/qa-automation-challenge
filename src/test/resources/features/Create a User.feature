Feature: API Testing

  Validate that it is possible to add a new user with a job
  Validate that it is possible to delete a user
  Validate that is not possible to submit a register without password

  @Regression
  Scenario: Validate adding new user with job (POST)
    Given Reqres address correct
    And Adding the context "name" and value "Toy"
    And Adding the context "job" and value "Singer"
    When Submitting the POST request
    Then The response code will be "201"
    #And Submitting a GET request to validate it's content

  @Regression
  Scenario: Validate deleting a user with job (DELETE)
    Given Adding new user was successful and the Reqres address correct
    When Submitting the DELETE request
    Then The response code will be "204"

  @Regression
  Scenario:
    Given Reqres register adress is correct
    And Adding the context "email" and value "challenge@automation.com"
    When Submitting the POST request
    Then The response code will be "400"