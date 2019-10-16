Feature: Search in google

  Scenario Outline: Search and get result count
    Given I visit google
    And I search for "<searchString>"
    Then I should see search results
    Examples:
      | searchString                                                            |
      | banana                                                                  |
      | sahana                                                                  |
      | ggffghgfgfhfghfghfghfghfghfghfghfghgfhgfhfghfgh sdfsfwefwefwe werewrwer |