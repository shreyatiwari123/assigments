@UI
Feature: Website front end testing

  @tag1
  Scenario: user is able to login into application
    Given user open the browser
    And user navigate to url
    When user enter username as john and password as demo and click on login button
    Then user is able to login in the application

  @tag2
  Scenario: open new account
    Given user open the browser
    And user navigate to url
    When user enter username as john and password as demo and click on login button
    Then user click on open new account
    And user select account type as Saving
    When user click on open new account button
    Then user will verify that new account is opened

  @tag3
  Scenario: transfer funds
    Given user open the browser
    And user navigate to url
    When user enter username as john and password as demo and click on login button
    Then user click on transfer funds
    Then user will click on ammount to be tranfer
    When user will select from account and to account
    Then user will click on transfer button
    Then user will verify that tranfer is completed
