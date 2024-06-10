@examples
Feature: API Example - Search Countries

@demo @api
Scenario: Verify That We Can Find the United States Of America Using The Code US
Given the REST endpoint named "country" is used with the "US" arguments
When the REST endpoint is succesfully excuted
Then the returned JSON should contain the country "United States of America"

Scenario: Verify That We Can Find the India Using The Code IN
Given the REST endpoint named "country" is used with the "IN" arguments
When the REST endpoint is succesfully excuted
Then the returned JSON should contain the country "India"

Scenario: Verify That We Can Find the Brazil Using The Code BR
Given the REST endpoint named "country" is used with the "BR" arguments
When the REST endpoint is succesfully excuted
Then the returned JSON should contain the country "Brazil"
