@Elements
Feature: Elements

  Background: 
    Given User is on demo QA site
    When User clicks on "ELEMENTS" st category card
  @smoke
  Scenario: Elements - Excel data
    And User click on "Text Box" tab
    And User valiadtes the header
    And User gets the form data from excel

  @regression
  Scenario: Elements - Check Box
    And User click on "Check Box" tab
    And User valiadtes the header
    And User expands the Home toggle
    And User expands the desktop toggle
    And User clicks on Commands check box
    And User expands Documents and Office
    And User clicks on General toggle
    And User expands the Downloads toggle
    And User clicks on Excelfile.doc
    Then User validates the seleted "commands" message

  @smoke
  Scenario: Elements - Radio button
    And User click on "Radio Button" tab
    And User clicks on "yesRadio" button
    Then User validates the seleted "Yes" message
    And User clicks on "impressiveRadio" button
    Then User validates the seleted "Impressive" message
    Then User validates the noRadio button

  @regression
  Scenario: Elements - Web Tables
    And User click on "Web Tables" tab
    And User clicks on Add button in registration form
    And User enters "firstName" as "Jackie" in text field
    And User enters "lastName" as "Ram" in text field
    And User enters "userEmail" as "ramkumardkr@gmail.com" in text field
    And User enters "age" as "40" in text field
    And User enters "salary" as "50000" in text field
    And User enters "department" as "IT" in text field
    And User clicks on submit button
    Then User is successfully "Jackie" added in the Web table
  @smoke
  Scenario: Elements - Upload and Download
    And User scroll down to links tab
    And User click on "Upload and Download" tab
    And User clicks on choose file
    And User selects the selenium image file
    Then User validate the image got succssfully uploaded
    And User clicks on download button
    And User set the path to download the image
    And User verify the image got successfully downloaded

  @regression
  Scenario: Elements - Dynamic Properties
    And User scroll down to links tab
    And User click on "Dynamic Properties" tab
    And User validate color changed or not
    And User validate the Will enable five seconds button enabled or not
    And User valiadte visible after five seconds button is present
