Feature: Get Pet data
  @regression
  Scenario Outline: Verify if pet data is retrieved successfully
    Given Add pet payload with "<name>" "<status>"
    When user calls "AddpetAPI" with "POST" http request
    Then API call got success with status code 200
    And "status" in response body is "Available"
    #And "scope" in response body is "APP"

  Examples:
    |name | status |
    |Leopard |Available|
    |Thar    |Available|


  @regression1
    Scenario: Verify if delete pet is working
      Given DeletePayload Payload
      When user calls "deletePetAPI" with "DELETE" http request
      Then API call got success with status code 200
      And "status" in response body is "OK"