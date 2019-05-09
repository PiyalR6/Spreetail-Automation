Feature: Mobile Grill Names Shown 


@MobileGrillNames
Scenario: User can see All Grill Accessories Product 
Given User on Home Page
And User Clicks on Hamburger Menu
And User is able to see all Menu Items 
And User Clicks on "Outdoor Living" Menu 
And User Clicks on "Grills and Grill Accessories" Menu 
And User Clicks on "Grills" Menu 
When User Clicks on Outdoor Grill Accessories
Then User Verify product loaded for Grill Accessories
And Close Browser