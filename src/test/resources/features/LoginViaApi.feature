Feature: Testing a REST API


Scenario: Can send POST request and get response

When I send a POST request to the address

Then I get a response



Scenario: Login with correct credentials

Given the following URL

When I enter username and password

Then I login



Scenario: Login with incorrect credentials

Given the following URL

When I enter username and password

Then I have an error message that some data is incorrect