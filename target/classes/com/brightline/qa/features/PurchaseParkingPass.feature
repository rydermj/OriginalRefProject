Feature: Purchase Parking Pass feature

  Scenario: Verify the Search for Parking Passes 
   When I am on the BL home page
   Then I navigate to Parking Pass page and verify Parking Pass metadata
   
  Scenario Outline: Auto Renewal toggle button for Parking Pass 
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to see the toggle button
   
    Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T93182 - Parking Pass for Refund 
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Verify Parking Pass Eligibility for refund
   
    Examples:
   |SheetName|RowNumber|
   |login|0|
   
  @Sanity
  Scenario Outline: TID-C8123 - Verify whether user is allowed to purchase parking without License plate number
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Validation message to be displayed
   
    Examples:
   |SheetName|RowNumber|
   |login|0|   
   
   @Sanity
  Scenario Outline: TID-C7920 - Verify whether user is able to buy Parking Pass and Auto Renew it
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able buy and Auto Renew the Parking pass 
   
    Examples:
   |SheetName|RowNumber|
   |login|0| 
   
   @Sanity
  Scenario Outline: TID-C7921 - Verify whether purchased Parking pass will Auto select for every Trip
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to book a ticket/ride with purchased parking pass 
   
    Examples:
   |SheetName|RowNumber|
   |login|5|
 