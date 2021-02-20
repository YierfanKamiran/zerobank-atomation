Feature: Navigating to specific accounts in Accounts Activity

  @wip
  Scenario Outline: Savings account redirect
    Given the user is logged in
    When the user clicks on "<linkType>" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "<selectedType>" selected

    Examples:
    |linkType|selectedType|
    |Savings|Savings|
    |Brokerage|Brokerage|
    |Checking|Checking|
    |Credit Card|Credit Card|
    |Loan|Loan|
