Feature: Contacts Page

  Scenario: Default page number
    Given the user is on the login page
    And the user enter the sales manager information
    When the user navigates "Customers" "Contacts"
    Then default page number should be 1

  Scenario: verify Calendar events
    Given the user is on the login page
    And the user enter the sales manager information
    When the user navigates "Fleet" "Vehicles"

  @wip
  Scenario: Menu options
    Given the user logged in as a "driver"
    Then the user should see following menu options
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |

