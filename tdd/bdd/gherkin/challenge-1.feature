# Challenge number 1
Feature: Fix my Gherkin

# Challenge
Given I am logged in as a customer service agent
Given I am on the author record detail page
Given The record is in edit mode
Given I change the first name field to 'test1'
When I click the Save button
Then the record is updated

# Solution number 1
Scenario: As a customer service agent I should be able to update the record
Given I am logged in as a customer service agent
And I am on the author record detail page
And The record is in edit mode
And I change the first name field to 'test1'
When I click the Save button
Then the record is updated

# Solution number 2
Scenario: As a customer service agent I should be able to update the record
Given I am logged in as a customer service agent
* I am on the author record detail page
* The record is in edit mode
* I change the first name field to 'test1'
When I click the Save button
Then the record is updated