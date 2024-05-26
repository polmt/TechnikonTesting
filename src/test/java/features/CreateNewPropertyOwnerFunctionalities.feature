Feature: Property Owner Functionalities

  Scenario: Validate New Property Owner's Form
    Given I am at the Create Property Owner Page
    Then The New Property Owner Form is displayed
    And The form contains the field: Name
    And The form contains the field: Surname
    And The form contains the field: Address
    And The form contains the field: Phone Number
    And The form contains the field: TIN number
    And The form contains the field: Email
    And The form contains the field: Username
    And The form contains the field: password

  Scenario: New Property Owner Registration
    Given The Create New Property Owner Form is displayed
    Then I fill out the form by entering the Name "Manolis"
    And I enter the Surname "Manolopoulos"
    And I enter the Address "Manolopoulou 9, Chalandri, 11111"
    And I enter the Phone Number "6912345678"
    And I enter the TIN number "147258369"
    And I enter the Email "manol.manolop@example.com"
    And I enter the Username "rnd(uname3)"
    And I enter the Password "qwerty3"