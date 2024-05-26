Feature: Property Owner Search Functionalities

  Scenario: Property Owner Performs Search by TIN
    Given I am Logged-In as a Property Owner
    When The Search Button is Visible
    And I click on the Search Button
    Then I can Perform a Search by TIN number

  Scenario: Property Owner Performs Search by Email
    Given I am Logged-In as a Property Owner
    When The Search Button is Visible
    And I click on the Search Button
    Then I can Perform a Search by Email

  Scenario: Property Owner Performs Search by Name
    Given I am Logged-In as a Property Owner
    When The Search Button is Visible
    And I click on the Search Button
    Then I can Perform a Search by Name