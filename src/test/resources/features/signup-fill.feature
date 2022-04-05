Feature: Signup fill

  Scenario Outline: Signup Successfully
    Given I open the landing page
    And I type my "<firstName>" in the first name input
    And I type my "<lastName>" in the last name input
    And I type my "<emailAddress>" in the email address input
    And I type my "<password>" in the password input
    And I type my "<password>" again in the confirm password input
    And I accept terms and conditions
    And I press Enter
    And I wait 5 seconds
    Then I am on the confirmation link page

    Examples:
      | firstName | lastName | emailAddress              | password     |
      | cornel    | dorel    | cornel12234423dorel@gmail.com     | Password123! |
