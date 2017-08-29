Feature: WriteService

  Scenario: Test pass for example name
    Given I create new write service
    When I pass example name
    Then result is correct

  Scenario: I get correct message for multiple names
    Given I create new write service
    When I pass example names
    Then result for multiple names is correct

  Scenario: I get correct message for given name
    Given I create new write service
    When I pass name Adam
    Then result for defined name Adam is correct

  Scenario: I get correct message for given name
    Given I create new write service
    When I pass name Adam, Anna, Beata
    Then result for defined name Adam, Anna and Beata is correct

  Scenario Outline: I get correct message for given name
    Given I create new write service
    When I pass name <name>
    Then result for name <name> is <expectedResult>
    Examples:
    | name | expectedResult |
    | Bartek | Hello, Bartek |
    | Bartek, Beata, Aneta | Hello, Bartek, Beata and Aneta |
    | JOHN | HELLO, JOHN! |
