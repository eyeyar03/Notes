# Challenge number 2
Feature: Fix my Gherkin

# Challenge
Given I have an author record with field firstname set to bob
And surname with value jones
And the author record is active
When I click the Save button
Then the record is updated

# Solution number 1
Given I have an "author" record
And The field "firstname" has a value of "bob"
And The field "surname" has a value of "jones"
And The field "active" has a value of "true"
When I click the Save button
Then The record is updated

# Solution number 1
Given I have an "author" record
And the field <Field> has a value of <Value>
| Field     | Value |
| firstname | bob   |
| surname   | jones |
| active    | true  |
When I click the Save button
Then The record is updated

