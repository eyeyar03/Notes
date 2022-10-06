@featureTagExample
Feature: Shopping Basket
As a customer I want to be able to edit the contents of my shopping basket, so that I can amend my purchase before checking out

Background:
  Given I have the following data:
  | Product | Stock | Basket |
  | 1       | 2     | 0      |
  | 2       | 0     | 0      |
  | 3       | 2     | 1      |

Scenario Outline: Testing functionality of the basket
Given I am on the product detail page of product <product>
When I click the Add to Basket button
Then the quantities are
| Stock   | Basket   |
| <stock> | <basket> |
And a message <message> is displayed to the user

Examples:
| Description           | Product | Stock | Basket | Message               |
| In Stock              | 1       | 1     | 1      | 'Added to the basket' |
| Not in Stock          | 2       | 0     | 0      | 'Not in stock'        |
| Already in the basket | 3       | 2     | 1      | 'Limited to one only' |

Scenario: As a customer I can add an item to my shopping basket
Given I am on the product detail page of product "1"
When I click the Add to Basket button
Then product "1" has the following quantities:
| Stock | Basket |
| 1     | 1      |
And a message is displayed to the user

# Product is not in the stock and not in the basket (Challenge)
Scenario: As a customer I am unable to add an item to my shopping basket if not in stock
Given I am on the product detail page of product "2"
When I click the Add to Basket button
Then product "2" has the following quantities:
| Stock | Basket |
| 0     | 0      |
And a message is displayed to the user

# Product is in stock and in the basket (Challenge)
Scenario: As a customer I am unable to add an item to my shopping basket if it's already in the basket
Given I am on the product detail page of product "3"
When I click the Add to Basket button
Then product "3" has the following quantities:
| Stock | Basket |
| 2     | 1      |
And a message is displayed to the user

Scenario: As a customer I can add an item to my shopping basket
Given I am on the product detail page
And the product is in stock
And this product is currently not in the basket
When I click the Add to Basket button
Then the product is added to the basket
And a message is displayed to the user
And the stock level is reduced by one

# Product is not in the stock and not in the basket
Scenario: As a customer I am unable to add an item to my shopping basket if not in stock
Given I am on the product detail page
And the product is not in stock
And this product is currently not in the basket
When I click the Add to Basket button
Then a message is displayed to the user
And the product is not added to the basket
And the stock level is not changed


# Product is in stock and in the basket
Scenario: As a customer I am unable to add an item to my shopping basket if it's already in the basket
Given I am on the product detail page
And the product is in stock
And this product is currently in the basket
When I click the Add to Basket button
Then a message is displayed to the user
And the product is not added to the basket
And the stock level is not changed



Scenario: As a customer I can remove an item from my shopping basket
Given I am on the basket page
When I click the Remove button
Then the product is removed from the basket

Scenario: As a customer I can view the items of my shopping basket
Given I am on the home page
When I click the shopping basket icon
Then I see a list of shopping items

Scenario: As a customer I can checkout from the shopping basket
Given I am on the basket page
When I click the Checkout button
Then I should be taken to the checkout page

@scenarioTagExample
Scenario: As a user I should be able to login to my account using my credentials
Given I am on the Login page
And the Signin button is displayed
When I enter my username
* I enter my password
* I click the Signin button
Then I should be authenticated
And I should be on the Account page

# As a customer I can create a new account if I enter my username/password and click the register and I will be sent to account page
Scenario: As a new user, I should be able to create an account using my credentials
Given I am on the Register Account page
And the Register button is displayed
When I enter my username
And I enter my password
And click the Register button
Then my account should be created
And I should be on the Account page
And I should see a message that my account registration is successful.