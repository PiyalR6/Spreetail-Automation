Feature: Grill Names Shown 

@GrillNames
Scenario: User can see All Grill Accessories Product 
Given User on Home Page
And User Clicks on Shop For 
And User Clicks on "Outdoor Living" Menu 
And User Clicks on "Grills and Grill Accessories" Menu 
And User Clicks on "Grills" Menu 
Then Click on Grills
Then User Verify product loaded for Grill Accessories
And Close Browser