Feature: User Registration 


@Guest_User_Order
Scenario: Home Page is Loading All 
Given User on Home Page
When User clicks on Grills
And User clicks on first product
And Click on add to cart
And Click on Checkout
And Enter an email address
And Click on Continue Button
And Add Let's make an account for
And Enter Shipping Address information, Save & Continue 
Then Click on Place Order
Then Verify Thank you page and Order Number
And Close Browser






