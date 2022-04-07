Feature: Signup

  Scenario Outline: Signup Successfully
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

    Examples:
      | firstName | lastName | password     |
      | cornel    | dorel    | Password123! |

  Scenario: Link opens in a separate tab
    Given I open the landing page
    And I click on Terms and Conditions link
    And I wait 5 seconds
    Then The Terms and Conditions page opens in a separate tab
