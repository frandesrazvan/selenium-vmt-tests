Feature: Signup

  Scenario Outline: VMT-W--01 - Landing page - right side - SignUp
    Given I open the landing page
    And I type my "<firstName>" in the first name input
    And I type my "<lastName>" in the last name input
    And I type my email address in the email address input
    And I type my "<password>" in the password input
    And I type my "<password>" again in the confirm password input
    And I accept terms and conditions
    And I press Enter
    And I wait 5 seconds
    Then I am on the confirmation link page
    And I click the Sign in button
    And I wait two seconds
    Then I am on the main page again

    Examples:
      | firstName | lastName | password     |
      | cornel    | dorel    | Password123! |

  Scenario: VMT-W--05 - Terms and Conditions
    Given I open the landing page
    And I click on Terms and Conditions link
    And I wait 5 seconds
    Then The Terms and Conditions page opens in a separate tab

  Scenario Outline: VMT-W--06- Sign In - Wrong Email
    Given I open the landing page
    And I click on Sign In then wait 2 seconds
    And I type an incorrect "<emailAddress>" in the email address input then i press enter
    And I wait 1 second
    Then I should see the message: Email pattern is invalid

    Examples:
      | emailAddress         |
      | fsdfsfsdf@.com       |
      | @gmail.com           |
      | gmail.com@razvan     |
      | @@@gmail@@@          |
      | @.                   |
      | @gmail.com@gmail.com |
      | a@a.c                |

  Scenario Outline: VMT-W--08 - Sign In - Forgot Password
    Given I open the landing page
    And I click on Sign In then wait 2 seconds
    And I click on forgot password
    And I wait "<1 second>"
    And I fill my "<email>"
    And I click the Continue button
    And I wait "<5 seconds>"
    Then I see a pop-up saying Success
    And I wait "<5 seconds>"
    Then I go to my email
    And I type my "<email>" then press Enter
    And I wait "<2 seconds>"
    And I type my password then press Enter
    And I wait "<5 seconds>"
    Then I click on the mail
    And I wait "<5 seconds>"
    And I click on Reset password link
    And I wait "<3 seconds>"
    Then I should be on the reset password page

    Examples:
      | email                            | 1 second | 2 seconds | 3 seconds | 4 seconds | 5 seconds | 6 seconds | 7 seconds |
      | corneldorelcorneldorel@gmail.com | 1        | 2         | 3         | 4         | 5         | 6         | 7         |


