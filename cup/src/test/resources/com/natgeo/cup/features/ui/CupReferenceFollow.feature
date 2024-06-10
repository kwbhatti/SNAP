Feature: As a User I want to be able to follow other users and see their content under Following

Background:
	Given a user is at Natgeo Reference Site, user: "alberto.copado+2@wizeline.com", password: "Manager@1995"
	
@RFollow
Scenario: Follow a User from Home
    When I Follow a User
    Then I see his/her content under Following
	