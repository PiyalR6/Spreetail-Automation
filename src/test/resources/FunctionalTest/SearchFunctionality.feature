

Feature: Search Functionality
  @SearchFunctionality @Regression
  Scenario Outline: As a user I should be able to search items and pick items from dropdown and get results related to my search
    Given User on Home Page
    Then User types "<searchText>" in searchbox
    Then User should see dropdown menu after typing four letters
    Then Verify when randomly one element is clicked, results match with selected dropdown


    Examples:
    |searchText|
    |swim      |
    |swimming pool |
    |pool      |
    |cooler    |
    |air       |
    |kit       |

  @SearchFunctionality @Regression
  Scenario Outline: As a user I should be able to search items and get results related to my search
      Given User on Home Page
      When User Search for "<searchText>", result must match with user's input

      Examples:
      |searchText|
      |swimming pool|
      |grill        |
      |coffee       |
      |brush        |
      |air          |
      |chair        |
      |wood         |
      |mug          |


  @SearchFunctionality @Regression
  Scenario Outline: As a user I should see an error message when item I search does not exist.
    Given User on Home Page
    When User Search for "<searchText>"
    Then User must see an error
    Examples:
    |searchText|
    |asdasdasd |
    |1231231231|
    |123asdasda|
    |aaaaaaaaaa|
