Feature: AlertsFrameWindows

 Background: 
    Given User is on demo QA site
    When User clicks on "ALERTSFRAMEWINDOWS" st category card
   
  @smoke
  Scenario: Browser Windows
    And User click on "Browser Windows" tab
    And User click on new "tabButton"
    Then User validate new tab is opened
    And User click on new "windowButton"
    Then User validate new window is opened

  @regression
  Scenario: Frames
    When User scroll down to frames tab
    When User click on Frames tab
    And User switch to psrent frame
    And User switch to child frame
  @smoke
  Scenario: Nested Frames
    When User scroll down to frames tab
    And User click on "Nested Frames" tab
    And User moves from parent to child frame

  @regression
  Scenario: Modal dialogs
    When User scroll down to frames tab
    And User click on "Modal Dialogs" tab
    And User clicks on "showSmallModal" modal button
    And User verify small modal pop up is opened
    And User clicks on "showLargeModal" modal button
    And User verify large modal pop up is opened
