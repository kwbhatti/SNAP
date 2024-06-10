@did-you-know
Feature: Did You Know Component

@gui @animals @prod
Scenario: AEM-8419: Validate Animal Profile Did You Know
  Given I am on the page "arctic fox profile"
  Then I should see the component "did you know"
  Then I should see the did you know fact
  And I should see count "1" in the pagination
  When I scroll the pagination
  Then I should see the did you know fact
  And I should see the twitter button
  And I should see count "2" in the pagination
  