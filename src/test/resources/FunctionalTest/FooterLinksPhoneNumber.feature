Feature: User Is Directed to proper page with links

@LinksVerification
Scenario Outline:Home Page is Loading All 
Given User on Home Page
Then User Clicks on "<links>"
And  Verify User is on the right page with correct "<Page Title>"
And Close Browser

Examples:
|links									|Page Title|
|Shipping & Return Policy			|Shipping & Return Policy— Spreetail|
|FAQs												|FAQs- Spreetail|
|About Us										|About Us- Spreetail|
|Community Impact					|Community Impact — Spreetail|
|Careers										|Careers- Spreetail|	
|Suppliers										|Suppliers- Spreetail|	
			

@PhoneCallVerification 
Scenario: Home Page is Loading All 
Given User on Home Page
And Verify and close Alert Pop Up
And Close Browser