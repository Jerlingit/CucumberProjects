Feature: Facebook login verification

  Scenario Outline: Facebook login credentials verification
    Given user is on facebook login page
    When user should enter "<username>" and "<password>"
    And user should click the login button
    Then user should verify the success message

    Examples: 
      | username | password   |
      | Jerlin   | Jerlin@123 |
      | Jeyam    | Jerlin@123 |
