@UI
Feature: Sign up new user in facebook using BDD
#As a user I want to register in this web so that I can connect with my friends
#-------------------------------------------------------------------------------
#Create new user
  Scenario: Create new user in facebook Website
    Given User navigate to facebook web
    When Click on Create new account button
    And User Fill the required fields with valid data
      | Just a | Test | Just_test@gmail.com | Just_test@gmail.com | 12345Test@ |
    Then the text of enter the code will be displayed
