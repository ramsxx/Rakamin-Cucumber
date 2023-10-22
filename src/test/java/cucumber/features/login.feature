  Feature: Login + add to chart + checkout

    @Regression @Positive
    Scenario: Succes Login
      Given user launch the website
      Then user input a registered user
      And user input registered password
      And user click login button
      Then Home Page Should be displayed

    @Regression @Negative
    Scenario: Failed Login
      Given user launch the website
      Then user input a registered user
      And user input wrong password
      And user click login button
      Then user get error massage



    @TDD
    Scenario Outline: User login to Swag Labs
      Given user launch the website
      When user input <email> as email
      And user input <password> as password
      And user click login button
      Then user verify <status> login result

      Examples:
        |email         |password     |status |
        |standard_user |secret_sauce |Success|
        |standard_user |secret_sauce1|Failed |


