Feature: Signup

#  Scenario Outline: Signup Successfully
#    Given I open the landing page
#    And I type my "<firstName>" in the first name input
#    And I type my "<lastName>" in the last name input
#    And I type my email address in the email address input
#    And I type my "<password>" in the password input
#    And I type my "<password>" again in the confirm password input
#    And I accept terms and conditions
#    And I press Enter
#    And I wait 5 seconds
#    Then I am on the confirmation link page
#
#    Examples:
#      | firstName | lastName | password     |
#      | cornel    | dorel    | Password123! |

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


