Feature: Verifying the Layout API 

@api
Scenario Outline:
Given:  I  reach the <base_url>
And I reach this <path>
And perform the <action>
When I provide the <parameters>
Then I am getting the <output>

Examples:
|BaseURL|Path|Endpoint|Action|Parameters|Output|
|https://thisendpoint|GET|layout_id=1|xxxxxxxxxxxxxxxxxxxxxxx|||
|https://thisendpoint|GET|layout_id=2|xxxxxxxxxxxxxxxxxxxxxxx|||
|https://thisendpoint|GET|layout_id=1|xxxxxxxxxxxxxxxxxxxxxxx|||
|https://thisendpoint|GET|layout_id=1|xxxxxxxxxxxxxxxxxxxxxxx|||