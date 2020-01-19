Feature: Contacts Page
  @wip
  Scenario: Default page number
    Given the user is on the login page
    And the user enter the sales manager information
    When the user navigates "Customers" "Contacts"
    Then default page number should be 1

    Scenario: verify Calendar events
      Given the user is on the login page
      And the user enter the sales manager information
      When the user navigates "Activities" "Calls"
