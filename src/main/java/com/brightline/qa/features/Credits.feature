Feature: Credits feature

  Scenario Outline: TID-T154083 - Cancel a train ticket booked with credits, check if credits are refunded back
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Cancel the booking which was paid through credits
   And Credits should be refunded back
  
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T154081 - User should be able to edit the credits in checkout 
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to edit credits and the credits edited should be applied properly
  
   Examples:
   |SheetName|RowNumber|
   |login|0|  
   
   @Sanityy
  Scenario Outline: TID-C8131 - Verify trip booking using all wallet and other payment options(BUG)
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book tickets with Multi Passenger for Smart Class Round Trip with Extras for wallet "<SheetNam>" and rownumber <RowNumbe>
   And Verify passes packs corp rides credits and cards amount to be detected
   And Verify Refund should happen in to primary passenger account
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|0|passengers|0|