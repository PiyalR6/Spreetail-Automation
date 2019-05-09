Feature: Dynamic Product Loading & Check Out

@AddingDynamicCheckout
Scenario: As a user I should be able to add an item to card and checkout, then verify I get the order number
Given User on Home Page
And User Clicks on Shop For 
And User Clicks on "Outdoor Living" Menu 
And User Clicks on "Grills, Smokers & Grill Accessories" Menu
And User Click on a random product
And Click on add to cart
And Click on Checkout
And Sign In 
And Add Payment Method
#And Enter Shipping Address information, Save & Continue 
#And Enter Credit Card information, Save & Continue
Then Click on Place Order
Then Verify Thank you page and Order Number
And Close Browser


