@examples @ExampleNotification
Feature: Scrolling Example

@ui @scrolltest
Scenario: Scroll to the bottom of a page and wait
    Given I open a browser to google
    And type Lima Beans
    And I scroll to the bottom

@ui @scrolltest
Scenario: Scroll to the bottom of a page and wait
    Given I open a browser to a wide page
    And I scroll by amount 100,100
