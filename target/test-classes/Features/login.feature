Feature: Hotel app login page

  Scenario Outline: Hotel login details verification
    Given User is on the hotel login page
    When User must enter "<username>" and "<password>"
    And User should click login button
    Then User login verified

    Examples: 
      | username   | password |
      | JerlinTest | 1B157R   |
      | Jeyam      | Test@123 |
