Feature: Proceed To CheckOut feature

  Scenario Outline: TID-T154073 - The CHECKOUT button
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User navigates to TravelPacks and taken to Checkout screen
   And User navigates to Train Pass and taken to Checkout screen
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   