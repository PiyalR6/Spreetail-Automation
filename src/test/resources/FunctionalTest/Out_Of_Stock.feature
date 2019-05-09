

Feature: Out Of Stock

@Out_Of_Stock
Scenario: Home Page is Loading All 
Given User on Home Page
And User Clicks on Shop For  
And User Clicks on "Outdoor Living" Menu 
And User Clicks on "Grills and Grill Accessories" Menu 
And User Clicks on "Grills" Menu 
And User clicks on first product
Then User Verify Product Quantity 
And Click on add to cart
