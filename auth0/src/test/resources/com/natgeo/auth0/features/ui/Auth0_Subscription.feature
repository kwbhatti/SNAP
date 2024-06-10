Feature: Auth0 Subscription 

@ui @gonzalo 
Scenario: Create a new user through playground page 
	Given I open a browser to playground 
	When I click on LogIn button 
	And I click on Join button 
	And I fill the chart with random information 
	Then I should see a confirmation page 
	When I check the inbox for the recently created profile and validate the account 
	Given I open a browser to playground 
	When I click on LogIn button 
	And I logIn with the recently created account 
	Then I should see the user page 
	Given I am on the page "profiles services login page" 
	When I login to profile service with admin credentials 
	And I click on the option change in the model profiles into the module profiles 
	Then I verify the recently created profile is created 
	When I go to the home page 
	And I click on the option change in the model subscriptions into the module subscriptions 
	Then I verify the recently created profile is subscribed to vendor Auth0-native 
	When I go to the home page 
	And I click on the option change in the model profiles into the module profiles 
	When I click on the recently created profile 
	And I delete the profile I am watching 
	