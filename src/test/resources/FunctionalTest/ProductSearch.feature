Feature: Product Search

#No Need to Run this for now 
@Search
Scenario: User can search for Product
Given User on Home Page
When User Search for Product
Then User Verify product title displayed  in product detail page

#This is the demo Page 
@MultiSearch
Scenario Outline: User Can Search for Multiple Products 
Given User on Home Page
When User Search for "<product>"
Then User verify product
And Close Browser

Examples:
|product|
|Lawn|
|Grill|

#Change URL to Dev 
@ProductDescription
Scenario:
Given User on Home Page
And User clicks on Grills
When User click first product
Then User Verify product title displayed  in product detail page
And Close Browser

 




