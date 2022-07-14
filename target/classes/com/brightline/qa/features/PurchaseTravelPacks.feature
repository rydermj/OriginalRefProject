Feature: Purchase Travel Packs feature

  Scenario Outline: Validate "Travel Packs" option
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then I validate Travel Packs metadata
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T154063 - Validate ADD TO CART functionality
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to Add Travel Pack to cart
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T93181 - Travel pack for Refund
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Verify Travel Pack Eligibility for Refund

    Examples:
   |SheetName|RowNumber|
   |login|0|
   
  @Sanity
  Scenario Outline: TID-C7915 - Verify whether User is able to buy Pack
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to buy the Packs
   
   Examples:
   |SheetName|RowNumber|
   |login|0|  
   
  @Sanity
  Scenario: TID-C7962 - Verify whether the user is able to buy pass and pack
   When I am on the BL home page
   Then Guest user buys pass and checkes error message
   And Guest user buys packs and checkes error message
   
  @Sanity
  Scenario Outline: TID-C7919 - Verify whether user is able to get Refund for Pack
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to buy the Packs
   And Verify Refund in BL wallet credit
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  @Sanity
  Scenario Outline: TID-C7917 - Verify the purchase history under the Pack used
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to View the Purchase history of the Packs
   
    Examples:
   |SheetName|RowNumber|
   |login|0| 
   
  @Sanity
  Scenario Outline: TID-C7916 - Booking a Trip with purchased Pack
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to buy the Packs
   And In checkout page purchased Pack should be applied and booking should be successful
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  @Sanity
  Scenario Outline: TID-C7918 - Verify the Pack count On cancelling Trip
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to buy the Packs and Books a Trip
   And User cancels the trip and amount should get Refund and the packs count should get increased
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
   