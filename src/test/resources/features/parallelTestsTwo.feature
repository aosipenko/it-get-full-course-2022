Feature: my test cucumber

  Scenario: generate and search for person
    Given I get user with "FirstName" = "Camila" from DB as "person_1"
    Given I load google page
    When I search for person with alias "person_1"
    Then I see a person "person_1" in search results

#  Scenario: user count test
#    Given I create set of 10 persons as "crowd_1"
#    Given I create set of 30 persons as "crowd_2"
#    Then User set "crowd_1" contains 10 persons
#    Then User set "crowd_2" contains 30 persons
#
#  Scenario: user count test 2
#    Given I create set of 10 persons as "crowd_1"
#    Given I create set of 20 persons as "crowd_2"
#    Then User set "crowd_1" contains 10 persons
#    Then User set "crowd_2" contains 20 persons