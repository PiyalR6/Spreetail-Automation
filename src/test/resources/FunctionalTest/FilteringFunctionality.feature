Feature: Filtering Functionality

 @PriceSortFilteringFunctionality @Regression
 Scenario Outline: As a user I should be able to sort products by Price: Low to High/High to Low  and without going back to homepage and Price: High to Low/Low to High
    Given User on Home Page
    Then User Clicks on Shop For
    And User Clicks on "<L1Text>" Menu
    And User Clicks on "<L2Text>" Menu
    Then User Clicks on "Sort By" from filter menu
    And User Clicks on "<sortingType>" from filter
    And Verify all products sorted "<verifyingType1>"
    Then User Clicks on "<sortingType2>" from filter
    And Verify all products sorted "<verifyingType2>"

    Examples:
    |L1Text          |L2Text                             |sortingType|verifyingType1|sortingType2|verifyingType2|
    |Outdoor Living  |Grills, Smokers & Grill Accessories|High to Low|High to Low|Low to High |Low to High|
    |Lawn & Garden   |Gardening                          |High to Low|High to Low|Low to High |Low to High|
    |Tools           |Compressors                        |High to Low|High to Low|Low to High |Low to High|
    |Sports & Outdoor|Camping Tents                      |High to Low|High to Low|Low to High |Low to High|



   @PriceSortFilteringFunctionality @Regression
    Scenario Outline: As a user I should be able to sort products by Price: Low to High and Price: High to Low
     Given User on Home Page
     Then User Clicks on Shop For
     And User Clicks on "<L1Text>" Menu
     And User Clicks on "<L2Text>" Menuv
     Then User Clicks on "Sort By" from filter menu
     Then User Clicks on "<sortingType>" from filter
     And Verify all products sorted "<verifyingType>"

      Examples:
        |L1Text          |L2Text                             |sortingType|verifyingType|
        |Outdoor Living  |Grills, Smokers & Grill Accessories|High to Low|High to Low  |
        |Outdoor Living  |Grills, Smokers & Grill Accessories|Low to High|Low to High  |
        |Lawn & Garden   |Gardening                          |High to Low|High to Low  |
        |Lawn & Garden   |Gardening                          |Low to High|Low to High  |
        |Tools           |Compressors                        |High to Low|High to Low  |
        |Tools           |Compressors                        |Low to High|Low to High  |
        |Sports & Outdoor|Camping Tents                      |High to Low|High to Low  |
        |Sports & Outdoor|Camping Tents                      |Low to High|Low to High  |


  @BrandFilteringFunctionality @Regression
  Scenario Outline: As a user I should be able to select single product brand and results must show me only selected brands
    Given User on Home Page
    Then User Clicks on Shop For
    And User Clicks on "<L1Text>" Menu
    And User Clicks on "<L2Text>" Menu
    Then User Clicks on "Brand" from filter menu
    And User selects random brand from filter
    Then Verify all products are selected brand

    Examples:
      |L1Text          |L2Text                             |
      |Outdoor Living  |Grills, Smokers & Grill Accessories|
      |Outdoor Living  |Outdoor Storage                    |
      |Lawn & Garden   |Gardening                          |
      |Lawn & Garden   |Lawn Mowers                        |
      |Tools           |Compressors                        |
      |Tools           |Generators                         |
      |Sports & Outdoor|Camping Tents                      |
      |Sports & Outdoor|Coolers                            |


  @BrandFilteringFunctionality @Regression
  Scenario Outline: As a user I should be able to select two product brands and results must show me only selected brands
    Given User on Home Page
    Then User Clicks on Shop For
    And User Clicks on "<L1Text>" Menu
    And User Clicks on "<L2Text>" Menu
    Then User Clicks on "Brand" from filter menu
    And User selects random brand from filter
    And User selects random brand from filter
    Then Verify all products are selected brand

    Examples:
      |L1Text          |L2Text                             |
      |Outdoor Living  |Grills, Smokers & Grill Accessories|
      |Outdoor Living  |Outdoor Storage                    |
      |Lawn & Garden   |Gardening                          |
      |Lawn & Garden   |Lawn Mowers                        |
      |Tools           |Compressors                        |
      |Tools           |Generators                         |
      |Sports & Outdoor|Camping Tents                      |
      |Sports & Outdoor|Coolers                            |

  @BrandFilteringFunctionality @Regression
  Scenario Outline: As a user I should be able to select three product brands and results must show me only selected brands
    Given User on Home Page
    Then User Clicks on Shop For
    And User Clicks on "<L1Text>" Menu
    And User Clicks on "<L2Text>" Menu
    Then User Clicks on "Brand" from filter menu
    And User selects random brand from filter
    And User selects random brand from filter
    And User selects random brand from filter
    Then Verify all products are selected brand

    Examples:
      |L1Text          |L2Text                             |
      |Outdoor Living  |Grills, Smokers & Grill Accessories|
      |Lawn & Garden   |Gardening                          |
      |Lawn & Garden   |Lawn Mowers                        |
      |Tools           |Compressors                        |
      |Tools           |Generators                         |
      |Sports & Outdoor|Camping Tents                      |
      |Sports & Outdoor|Coolers                            |

  @BrandFilteringFunctionality2 @Regression
  Scenario Outline: As a user I should be able to select two product brands and results must show me only selected brands(Combo)
    Given User on Home Page
    Then User Clicks on Shop For
    And User Clicks on "<L1Text>" Menu
    And User Clicks on "<L2Text>" Menu
    And User Clicks on "<L3Text>" Menu
    Then User Clicks on "Brand" from filter menu
    And User selects random brand from filter
    And User selects random brand from filter
    Then Verify all products are selected brand

    Examples:
      |L1Text          |L2Text                   |L3Text                  |
      |Outdoor Living  |Fountains & Ponds        |Ponds                   |
      |Outdoor Living  |Fountains & Ponds        |Pumps & Filters         |
      |Outdoor Living  |Outdoor Play Equipment   |Inflatable Bouncers     |
      |Lawn & Garden   |Outdoor Power Equipment  |Weed Trimmers           |
      |Tools           |Saws                     |Handheld Circular Saws  |
      |Kitchen         |Coffee, Tea & Espresso   |Coffee Makers           |


