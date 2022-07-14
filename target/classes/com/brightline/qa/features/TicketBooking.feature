Feature: Train Booking feature

@sanity
  Scenario Outline: TID-T93176 - User search for Avaialble Trains
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User searches for Trains
   
    Examples:
   |SheetName|RowNumber|
   |login|0|
   
@sanity
  Scenario Outline: TID-T154075 - Add a Train reservation to the cart 
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User searches for Trains
   And User completes booking a train
   
    Examples:
   |SheetName|RowNumber|
   |login|0| 
   
   @week3
  Scenario: TID-T164881 - Click on Cart icon 
   Given I am on the BL home page
   When User adds TravelPacks and Verify Cart page metadata
   Then User adds TrainPass and Verify Cart page metadata
   
  @week4
  Scenario Outline: TID-T164883 - Verify Whether extras getting cleared for edit trip as guest user (Round trip)-On changing location
   Given I am on the BL home page
   When Guest user selects a Train with valid Email id "<SheetNam>" and rownumber <RowNumbe>
   Then Guest user should be able to book the ticket using debit or credit card "<SheetName>" and rownumber <RowNumber>
   And User edits Trip and verifies Extras data
   
   Examples:
   |SheetNam|RowNumbe|SheetName|RowNumber|
   |userdetails|0|addcard_address|0|
   
   