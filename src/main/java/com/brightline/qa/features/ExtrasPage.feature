Feature: Extras Page feature


  Scenario Outline: Verify "Add Extras" landing page
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then I verify Add Extras metadata
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T154065 - Garage Parking - ADD button
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should able to add the Garage parking as Extras to the ticket
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T154066 - Pet - Add button
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should able to add Pet details as Extras to the ticket
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T154067 - Sports Equipment - Add button 
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should able to add Sports Equipment details as extras to the ticket
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   