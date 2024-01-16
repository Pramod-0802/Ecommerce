#Author: patil.08@gmail.com

Feature: Search product and add to checkout page

@PlaceOrder
Scenario Outline: Search a product on the Home page and add items to checkout 

Given user is on Home page
When user searched with shortname <Name> and extract the product name
And added <Quantity> quantities of selected product to the cart
Then user proceeds to Checkout and validate the <Name> items in checkout page 
And verify user has ability to enter promo code and place the order

Examples:
|	Name	|	Quantity |
|	Tom			|	3							|