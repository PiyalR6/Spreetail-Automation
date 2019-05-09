Feature: Search Product And Checkout 

@Search_Checkout
Scenario: Home Page is Loading All 
Given User on Home Page
Then User Search for "char-broil"Product 
And User Click on a random product
And Click on add to cart
And Click on Checkout
And Enter an email address
And Click on Continue Button
And Add Let's make an account for
And Enter Shipping Address information, Save & Continue 
And Enter Credit Card information, Save & Continue
Then Click on Place Order
Then Verify Thank you page and Order Number
And Close Browser