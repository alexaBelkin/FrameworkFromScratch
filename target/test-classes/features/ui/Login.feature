@smoke @regression
Feature: Testing login Functionality for OpenMrs
  Scenario: Positive Login Functionality(Happy path)
    Given User provides username and password with 'Inpatient Ward'
    Then User validates the 'Home' and 'http://codefish.ninja/openmrs/referenceapplication/home.page'

    Scenario Outline: Negative Login Functionality
      Given User provides '<username>' and '<password>' with '<location>'
      Then User validates 'Invalid username/password. Please try again.'

      Examples:
        | username | password | location          |
        | admin    | 112      | Inpatient Ward    |
        | oleg     | Admin123 | Outpatient Clinic |
        |          |          | Registration Desk |
        | ^$#$#$   | ^$#$#$   | Pharmacy          |
        | ADMIN    | ADMIN123 | Outpatient Clinic |
        |          |          | Pharmacy          |










