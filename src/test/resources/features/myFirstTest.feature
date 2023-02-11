Feature: my test cucumber

  Scenario Outline: generate and search for person with params
    Given I create a random person with gender "<gender>" as "person_1"
    Given I start my browser
    Given I load google page
    When I search for person with alias "person_1"
    Then I see a person "person_1" in search results
    Examples:
      | gender |
      | male   |
      | female |

  Scenario: generate and search for person
    Given I create a random person with gender "male" as "person_1"
    Given I create a random person with gender "female" as "person_2"
    Given I start my browser
    Given I load google page
    When I search for person with alias "person_1"
    Then I see a person "person_1" in search results
    Given I load google page
    When I search for person with alias "person_2"
    Then I see a person "person_2" in search results

  Scenario: string to enum
    Given I click GOOGLE_SEARCH_INPUT
    Given I click GOOGLE_SEARCH_INPUT_2