Feature: Booking Flow One Way feature


 @Sanity
  Scenario Outline: TID-C7904 - Verify one way trip with single passenger having Smart class with private ride + Pet ,sports and parking
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should allow to add Extras into trip but Private Ride should not be allow to Add into Trip
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
 @Sanity
  Scenario Outline: TID-C7934 - Verify Single passenger one way trip without any extras
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Booking should be successful
   
   Examples:
   |SheetName|RowNumber|
   |login|5|  
   
  @Sanity
  Scenario Outline: TID-C7935 - Verify Multi Passenger(Adult+Kid+Infant) One way Trip Without any Extra
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Booking should be successful with Multi Passenger without Extras "<SheetNam>" and rownumber <RowNumbe>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|0|passengers|0|  
   
 
  @Sanity
  Scenario Outline: TID-C7922 - Verify one way trip with Multi passenger having Smart class with Shared ride+ Pet ,sports and parking
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book tickets with Multi Passenger for Smart Class with Extras "<SheetNam>" and rownumber <RowNumbe>
   And Complete booking with Add cards functionality "<SheetNa>" and rownumber <RowNumb>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|SheetNa|RowNumb|
   |login|5|passengers|0|addcard_address|0|
   
   
 @Sanity
  Scenario Outline: TID-C7905 - Verify one way trip with single passenger having Premium class with private ride + Pet ,sports and parking
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book tickets with private ride and Extras
   And Complete booking with Add cards functionality "<SheetNa>" and rownumber <RowNumb>
   
    Examples:
   |SheetName|RowNumber|SheetNa|RowNumb|
   |login|0|addcard_address|0|
   
  @Sanity
  Scenario Outline: TID-C7959 - Verify one way trip with Single passenger having smart class with Shared ride + Pet ,sports and parking
   Given I am on the BL home page
   When Guest user adds tickets with Smart Class with Extras "<SheetName>" and rownumber <RowNumber>
   Then Ride should be added "<SheetNam>" and rownumber <RowNumbe>
   
    Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |userdetails|0|addcard_address|0|
   
  @Sanity
  Scenario Outline: TID-C7925 - Verify one way trip with Multi passenger having Premium class with Shared ride + Pet ,sports and parking
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book tickets with Multi Passenger for Premium Class with Extras "<SheetNam>" and rownumber <RowNumbe>
   And Complete booking with Add cards functionality "<SheetNa>" and rownumber <RowNumb>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|SheetNa|RowNumb|
   |login|5|passengers|0|addcard_address|0|
   
   
  @Sanity
  Scenario Outline: TID-C8125 - BL user - Verify wrong card details in checkout
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book tickets with Multi Passengers for Smart Class with Extras "<SheetNam>" and rownumber <RowNumbe>
   And Complete booking with Add cards functionality "<SheetNa>" and rownumber <RowNumb>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|SheetNa|RowNumb|
   |login|0|passengers|0|addcard_address|1|
   
 @Sanity
  Scenario Outline: TID-C8126 - Guest User verify wrong card details in checkout
   Given I am on the BL home page
   When Book tickets with shared ride and Extras for One Way "<SheetNam>" and rownumber <RowNumbe>
   Then Guest user should be able to book the ticket using debit or credit card "<SheetName>" and rownumber <RowNumber>
   
    Examples:
   |SheetNam|RowNumbe|SheetName|RowNumber|
   |guestpassengers|0|addcard_address|1|
   
 @Sanity
  Scenario Outline: TID-C8039 - Verify Remove cart
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to Remove items from the Cart "<SheetNam>" and rownumber <RowNumbe>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|5|passengers|0| 
   
  @Sanityy
  Scenario Outline: TID-C8130 - Verify trip booking using all wallet and other payment options
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book tickets with Multi Passenger for Smart Class with Extras for wallet "<SheetNam>" and rownumber <RowNumbe>
   And Verify passes packs corp rides credits and cards amount to be detected
  
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|0|passengers|0|