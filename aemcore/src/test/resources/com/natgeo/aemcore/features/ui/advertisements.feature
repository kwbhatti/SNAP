@advertisements
Feature: AEM Advertisements

@gui @homepage
Scenario Outline: AEM-8480: Verify an advertisement is displayed on the page
    Given I am on the page "<Pages>" with ads enabled
    Then I should be able to see all advertisements on the page
    And I should see a total of "<count>" advertisements on the page

    Examples:
      | Pages            | count |
      | home page        | 0     |
