Feature: Property Owner Registers A Property And Requests A Repair For It

  Scenario: Register A Property
    Given I am Logged-In as a Property Owner
    When I click the Register New Property Button
    And I fill out the form of the info of that Property by entering the Property IN "123456789"
    And I enter the Address "Tyxaia Dieythynsi 51"
    And I enter the Year Of Construction "2014"
    And I enter the Property Owner ID "21"
    And I enter a Picture "spiti.png"
    And I enter the Type Of That Property "MAISONETTE"
    And I click the Register A Property Button
    Then The New Property is Registered

  Scenario: Requests A Repair For A Property
    Given I am located in My Profile Page
    When I click the Create New Repair Button
    And I fill out the form of the info of that Repair by entering the Type Of Repair "INSULATION"
    And I enter the Description "Application of insulation to the rooftop"
    And I enter the Repair Date "28-05-2024"
    And I enter the Property ID "3"
    And I click the Create New Repair Button
    Then The New Repair is Registered