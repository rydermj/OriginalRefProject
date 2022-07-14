Feature: Account Dashboard feature

  Scenario Outline: TID-T93187 - Verify Brightline Wallet section on the Account Dashboard
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then I should be able to see the Brightline Wallet section on the Account Dashboard
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   

  Scenario Outline: Verify summary displayed on BL wallet section
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then I should be able to see a summary of My Active Packs and Passes
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
   @Sanity
  Scenario Outline: TID -C7963 - Verify credit refund on cancelling trip booked using credits/Cards
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Booking should be successful
   And I verify credit refund on cancelling trip
   
   Examples:
   |SheetName|RowNumber|
   |login|5|  
   