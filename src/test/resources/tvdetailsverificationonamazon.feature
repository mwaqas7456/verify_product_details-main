Feature: Verify user can view the television details on amazon

  Scenario: Verify user can view the television details
    Given user visits the website
    When user clicks on hamburger menu
    And clicks on TV, Appliances and Electronics
    And clicks on Televisions
    And filter by brand name Samsung
    And sort by price High to Low
    And clicks on the second highest priced item
    Then verify About this item section is visible