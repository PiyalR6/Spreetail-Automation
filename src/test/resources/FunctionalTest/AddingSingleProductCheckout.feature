Feature: Single  Product Loading & Check Out 

@AddingSingleProductCheckout
Scenario: Home Page is Loading All 
Given User on Home Page
And User Clicks on Shop For 
And User Clicks on "Outdoor Living" Menu 
And User Clicks on "Grills, Smokers & Grill Accessories" Menu
And User clicks on first product
And Click on add to cart
And Click on Checkout
And Sign In 
And Enter Shipping Address information, Save & Continue 
And Enter Credit Card information, Save & Continue
Then Click on Place Order
Then Verify Thank you page and Order Number


