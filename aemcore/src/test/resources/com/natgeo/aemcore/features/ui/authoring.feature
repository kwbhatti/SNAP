Feature: As an editor I should be able to go to the authoring tool and curate pages and articles that will be part of our digital landscape

  @pierreauthtestcreate  @authtest
  Scenario Outline: New Homepage Creation and Deletion
    Given I log into the authoring site
    When I create a new homepage with "<templatetype>" template
    And I see page created with "<templatetype>" template 
   
   Examples:
   |templatetype| 
   |Immersive Lead (Article)| 
   |Image Lead (Article)| 
   |Video Lead (Article)| 

  @pierreauthtestopen  @authtest
  Scenario: Open Homepage and Verify
    Given I log into the authoring site
    When I open the new template created
    And all the required components are available
    
  @briantest @smoke
  Scenario: Create a page or something
    Given I log into the authoring site
    When I open the new homepage
    # And Navigate tree Websites @ News @ Landing Page @ Automation
    And I click on New toolbar
    And I write on input 'Title' the value 'Serenity Create and Delete'
    And I write on input 'Name' the value 'Serenity Automation'
    And I click on 'Create' button
