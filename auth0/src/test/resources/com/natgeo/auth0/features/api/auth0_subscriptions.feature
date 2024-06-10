@examples
Feature: API Auth0 Subscriptions

@tripservices @api
Scenario: Verify subscriptions endpoint status code for auth0 vendor 
When I send a POST service request with default header to https://natgeo-preprod-staging.apigee.net/tripservices/custom-trip-requests/ and body {}
Then I will receive HTTP code 400 as service response
