Feature: WriteService

  Scenario: Test pass for example name
    Given I create new write service
    When I pass example name
    Then result is correct

  Scenario: I get correct message for multiple names
    Given I create new write service
    When I pass example names
    Then result for multiple names is correct