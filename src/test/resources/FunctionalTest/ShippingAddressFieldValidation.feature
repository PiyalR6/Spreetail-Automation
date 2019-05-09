Feature: Shipping Address Fields Validation 

@Shipping_Address_Field_Validation 
Scenario: Home Page is Loading All 
Given User on Home Page
And User Clicks on "Outdoor Living" Menu 
And User Clicks on "Grills and Grill Accessories" Menu 
And User Clicks on "Grills" Menu 
And User Click on a random product
And Click on add to cart
And Click on Checkout
And Enter an email address
And Click on Continue Button
And Add Let's make an account for
And User enters invalid shipping information Save & Continue 
Then User Verifies Shipping Address Error message
#Then User Verifies Error Message
And Close Browser