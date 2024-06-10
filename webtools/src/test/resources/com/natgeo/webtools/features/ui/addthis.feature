@add-this
Feature: AddThis

@gui @magazine
Scenario: AEM-5095: Validate that the Add This component sticks on magazine
    Given I am on the page "magazine components page"
    Then the element "addthis" should not be in the viewport
    When I scroll down 2
    Then the element "addthis" should be in the viewport
    When I scroll down 1
    Then the element "addthis" should be in the viewport
    When I scroll down 3
    Then the element "addthis" should not be in the viewport
    When I scroll down 5
    Then the element "addthis" should be in the viewport
    And I check the number of icons displayed when I use the addthis expander button
    When I scroll to the end
    Then the element "addthis" should not be in the viewport

@gui @travel
Scenario: AEM-5096: Validate that the Add This component sticks on travel
    Given I am on the page "travel top ten"
    Then I should see the element "addthis"
    And the element "addthis" should be in the viewport
    When I scroll down 2
    Then the element "addthis" should be in the viewport
    When I scroll down 1
    Then the element "addthis" should be in the viewport
    When I scroll down 2
    Then the element "addthis" should be in the viewport
    When I scroll down 3
    Then the element "addthis" should be in the viewport
    And I check the number of icons displayed when I use the addthis expander button
    When I scroll to the end
    Then the element "addthis" should not be in the viewport
