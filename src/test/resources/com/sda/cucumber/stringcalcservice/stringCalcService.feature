Feature: StringCalcService

  Scenario: Test pass for digits in given name
    Given I create new string calc service
    When I pass example string with 5;3 digits
    And i pass 8 result for example string with digits
    Then result is correct

  Scenario Outline: Test pass for digits in given names from list
    Given I create new string calc service
    When I pass example string with <givenString> digits
    And i pass <givenResult> result for example string with digits
    Then result is correct
    Examples:
    | givenString | givenResult |
    | 5;3 | 8 |
    | 15;13 | 28 |
    | 22;32;2;6;8 | 70 |

