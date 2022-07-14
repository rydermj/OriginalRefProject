Feature: Payments Method feature

  Scenario Outline: TID-T93279 - Verify payment flow using saved cards
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to book trip using saved cards
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T93277 - Verify the payment flow using passes via cards
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to book the pass using cards
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T164884/T154072 - Verify the payment flow using debit/credit card for guest user in round way trip with extras
   Given I am on the BL home page
   When Guest user selects a Train with valid Email id "<SheetNam>" and rownumber <RowNumbe>
   Then Guest user should be able to book the ticket using debit or credit card "<SheetName>" and rownumber <RowNumber>
   
   Examples:
   |SheetNam|RowNumbe|SheetName|RowNumber|
   |userdetails|0|addcard_address|0|
   
  Scenario Outline: TID-T164885 - Verify trip cancelation and refund amount
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to cancel the trip and amount should refund in form of credits
   
   Examples:
   |SheetName|RowNumber|
   |login|0|  
   