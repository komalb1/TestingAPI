Feature: Get Bike Location
  This Feature is to validate all the location requests

  @get
  Scenario: Get Bike Location
    Given City Bike API is up and running
    When API returns the response with status code
    Then I search product with location city as "Frankfurt"
    And Validate id is displayed as "visa-frankfurt"
    And Validate type is href as "/v2/networks/visa-frankfurt"