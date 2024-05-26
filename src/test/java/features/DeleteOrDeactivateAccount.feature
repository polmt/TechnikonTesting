Feature: Deletion And Deactivation Of Property Owner Account Distinction

  Scenario: Property Owner Deletes Account Connected To No Properties
    Given I am Logged-In as a Property Owner and I want to Delete my Account that has no Properties related to it
    When I select to View My Profile
    And I click the Delete Property Owner Account Button
    And I confirm that I want to Delete that Property Owner Account
    Then The Property Owner Account is Deleted

  Scenario: Property Owner Deletes Account Connected To At Least One Property
    Given I am Logged-In as a Property Owner and I want to Delete my Account that has at least one Property related to it
    When I select to View My Profile
    And I click the Delete Property Owner Account Button
    And I confirm that I want to Delete that Property Owner Account
    Then The Property Owner Account is Deactivated