Feature: Brand Search Functionality
  @BrandSearchFunctionality @Regressiongit
  Scenario Outline: As a user I should be able to click on brand name and see all products with that brand name listed
    Given User on Home Page
    And User Clicks on Shop For
    And User Clicks on "<L1Text>" Menu
    And User Clicks on "<L2Text>" Menu
    And User Click on a random product
    And User Clicks on brand name and verifies all products has expected brand name

    Examples:
      |L1Text          |L2Text                             |
      |Lawn & Garden   |Gardening                          |
      |Tools           |Compressors                        |
      |Sports & Outdoor|Camping Tents                      |
      |Outdoor Living  |Grills, Smokers & Grill Accessories|
