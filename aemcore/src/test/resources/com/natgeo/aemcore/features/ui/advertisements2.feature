@advertisements
Feature: AEM Advertisements

@gui @photo-gallery @photography 
Scenario: AEM-9042: Validate that advertisement loads with photo gallery pagination
    Given I am on the page "adventure photo gallery template page" with ads enabled
    And I paginate through the photo presentation gallery and verify advertisements load

