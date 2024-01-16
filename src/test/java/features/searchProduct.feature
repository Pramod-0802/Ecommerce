#Author: patil.08@gmail.com

Feature: Search and place the order for products

@SearchProduct
Scenario Outline: Search experience for product search in both Home page and Offers page

Given user is on Home page
When user searched with shortname <Name> and extract the product name
Then user searched with same shortname <Name> on Offers page
And validate the product name matches with that on the Home page

Examples:
|	Name	|
|	Pot			|
|	Beet		|