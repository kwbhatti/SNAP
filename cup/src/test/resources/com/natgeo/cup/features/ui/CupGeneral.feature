Feature: Sign in, Login, Log out

Background:
	Given a user open the Member Center Staging Login Page and log in with credentials: "alberto.copado+1@wizeline.com", "Testaccount@1995"
	
@CupGeneralFeatures @CupRegression
Scenario: As a registered user I want to be able to login through Member Center Staging
	Then The user logs in to the page
	
@CupGeneralFeatures @CupRegression
Scenario: As a logged in user, I want to be able to Log out
	When I log out
	Then I should be redirected to the Member Center Login Page