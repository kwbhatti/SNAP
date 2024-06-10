@advertisements
Feature: AEM Advertisements

@gui @photo-gallery @photography
Scenario: AEM-9043: Validate that advertisement loads with photo gallery pagination
    Given I am on the page "yourshot gallery page" with ads enabled
    And I paginate through the photo presentation gallery and verify advertisements load

  