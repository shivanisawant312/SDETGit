Feature: Login page Automation of RIS

Scenario Outline: Check login is successful with valid creds
Given user is on login page
When user enters valid "<username>" and "<password>"
And clicks on Login Button
Then User is navigated to Home Page
And Close the browser


Examples:
| username | password |
| admin | admin1 |
| shivaniii | admin1 |