Feature: Purchase Train Pass feature

  Scenario Outline: Verify Train Passes page opening
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to view the train passes page
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T154068 - Verify Train Passes page - ADD TO CART 
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User navigates to Train Pass and taken to Checkout screen
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario: Enable/Disable Auto renewal toggle button 
   Given I am on the BL home page
   When User should be able to view the train passes page
   Then User should be able to enabledisable the auto renewal button

  Scenario Outline: Verify turn on auto renewal - Train Pass/Parking Pass 
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User navigates to train pass page from walletsection and checks AutoRenewal functionality
   And User navigates to parking pass page from walletsection and checks AutoRenewal functionality
   
    Examples:
   |SheetName|RowNumber|
   |login|0|

  Scenario Outline: TID-T93180 - Train Pass for Refund 
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Verify Train Pass Eligibility for Refund
   
    Examples:
   |SheetName|RowNumber|
   |login|0|
   
  @Sanity
  Scenario Outline: TID-C7913 - Verify whether user able to Book a trip using Purchased Pass
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User books a Train Ticket with existing Train Pass from Wallet
   
    Examples:
   |SheetName|RowNumber|
   |login|0|
   
  @Sanity
  Scenario Outline: TID-C8122 - Verify whether user is allowed to purchase duplicate passes
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should get error message while purchasing duplicate passes
   
    Examples:
   |SheetName|RowNumber|
   |login|0|
   
  @Sanity
  Scenario Outline: TID-C7912 - Verify whether User able to buy a pass and Auto renew it
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to buy and Auto Renew the Passes
   
    Examples:
   |SheetName|RowNumber|
   |login|0| 
   
  @Sanity
  Scenario Outline: TID-C7914 - Verify Purchase history under the pass used
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to View the Purchase history of the Train Passes
   
    Examples:
   |SheetName|RowNumber|
   |login|0|    
   