Feature: Check That The Application Is Up And Running

  Scenario: Get A 200 Response Code From A Get Http Request
    Given That the Endpoint is Up and Running
    When I make a GET Request for the Property Owner with TIN "123456789"
    Then I Get a response that contains the Details of the Property Owner with TIN "123456789"