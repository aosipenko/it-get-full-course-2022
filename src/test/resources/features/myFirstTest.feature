Feature: my test cucumber

#  Scenario Outline: generate and search for person with params
#    Given I create a random person with gender "<gender>" as "person_1"
#    Given I start my browser
#    Given I load google page
#    When I search for person with alias "person_1"
#    Then I see a person "person_1" in search results
#    Examples:
#      | gender |
#      | male   |
#      | female |
#
#  Scenario: generate and search for person
#    Given I create a random person with gender "male" as "person_1"
#    Given I start my browser
#    Given I load google page
#    When I search for person with alias "person_1"
#    Then I see a person "person_1" in search results

#  Scenario: string to enum
#    Given I create multiple persons
#      | person_1 | male |
#      | person_2 | male |
#      | person_3 | male |
#      | person_4 | male |
#    Given I save users to DB
#      | person_1 |
#      | person_2 |
#      | person_3 |
#      | person_4 |
#    When I print all users in DB with "Gender" = "female"
#    When I print all users in DB with "Gender" = "male"

  Scenario: user count test
    Given I create set of 10 persons as "crowd_1"
    Given I create set of 30 persons as "crowd_2"
    Then User set "crowd_1" contains 10 persons
    Then User set "crowd_2" contains 30 persons

  Scenario: user count test 2
    Given I create set of 10 persons as "crowd_1"
    Given I create set of 20 persons as "crowd_2"
    Then User set "crowd_1" contains 10 persons
    Then User set "crowd_2" contains 20 persons