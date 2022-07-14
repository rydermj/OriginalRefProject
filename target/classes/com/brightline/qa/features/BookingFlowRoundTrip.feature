Feature: Booking Flow Round Trip feature

  @Sanity
  Scenario Outline: TID-C7961 - Verify whether user is able to search the ticket in Manage trip
   Given I am on the BL home page
   When Guest user selects a Train with valid Email id "<SheetNam>" and rownumber <RowNumbe>
   Then Guest user should be able to book the ticket using debit or credit card "<SheetName>" and rownumber <RowNumber>
   And User should be able to view the ticket successfully "<SheetNa>" and rownumber <RowNumb>
   
    Examples:
   |SheetNam|RowNumbe|SheetName|RowNumber|SheetNa|RowNumb|
   |userdetails|0|addcard_address|0|search|0|

  @Sanity
  Scenario Outline: TID-C7940 - Verify Single passenger Round Trip without any extras
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Booking should be successful for Single passenger Round Trip without any extras "<SheetNam>" and rownumber <RowNumbe>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|5|userdetails|0|
   
  @Sanity
  Scenario Outline: TID-C7941 - Verify Multi Passenger round Trip Without any Extra
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Booking should be successful for Multi passenger Round Trip without any extras "<SheetNam>" and rownumber <RowNumbe>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|0|passengers|0|  
   
   
  @Sanity
  Scenario Outline: TID-C7936 - Verify round trip with single passenger having Smart class with private ride + Pet ,sports and parking
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should allow to add Extras into round trip but Private Ride should not be allow to Add into Trip
   
   Examples:
   |SheetName|RowNumber|
   |login|5|
   
 @Sanity
  Scenario Outline: TID-C8129 - Guest User verify wrong card details in checkout
   Given I am on the BL home page
   When Book tickets with shared ride and Extras for Round Trip "<SheetNam>" and rownumber <RowNumbe>
   Then Guest user should be able to book the ticket using debit or credit card "<SheetName>" and rownumber <RowNumber>
   
    Examples:
   |SheetNam|RowNumbe|SheetName|RowNumber|
   |guestpassengers|0|addcard_address|1|
   
  @Sanity
  Scenario Outline: TID-C7938 - Verify round trip with Multi passenger having Smart class with Shared ride+ Pet ,sports and parking
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book tickets with Multi Passenger for Smart Class Round Trip with Extras "<SheetNam>" and rownumber <RowNumbe>
   And Complete booking with Add cards functionality "<SheetNa>" and rownumber <RowNumb>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|SheetNa|RowNumb|
   |login|0|passengers|0|addcard_address|0|
   
  @Sanity
  Scenario Outline: TID-C7937 - Verify round trip with single passenger having Premium class with private ride + Pet ,sports and parking
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book tickets with private ride and Extras for Round Trip
   And Complete booking with Add cards functionality "<SheetNa>" and rownumber <RowNumb>
   
    Examples:
   |SheetName|RowNumber|SheetNa|RowNumb|
   |login|5|addcard_address|0|
   
   
  @Sanity
  Scenario Outline: TID-C7939 - Verify round trip with Multi passenger having Premium class and Smart classwith Shared ride + Pet ,sports and parking
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book tickets with premium class with shared ride and Extras for Round Trip "<SheetNam>" and rownumber <RowNumbe>
   And Complete booking with Add cards functionality "<SheetNa>" and rownumber <RowNumb>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|SheetNa|RowNumb|
   |login|0|passengers|0|addcard_address|0|
   
  @Sanity
  Scenario Outline: TID-C7960 - Verify Round trip with Multi passenger having premium class with private ride + Pet ,sports and parking
   Given I am on the BL home page
   When Book tickets with private ride and Extras for Round Trip "<SheetNam>" and rownumber <RowNumbe>
   Then Guest user should be able to book the ticket using debit or credit card "<SheetName>" and rownumber <RowNumber>
   
    Examples:
   |SheetNam|RowNumbe|SheetName|RowNumber|
   |guestpassengers|0|addcard_address|0|
   
  
  @Sanity
  Scenario Outline: TID-C8128 - Verify wrong card details in checkout
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book tickets with Multi Passengers for Smart Class Round Trip with Extras "<SheetNam>" and rownumber <RowNumbe>
   And Complete booking with Add cards functionality "<SheetNa>" and rownumber <RowNumb>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|SheetNa|RowNumb|
   |login|5|passengers|0|addcard_address|1| 
   
   
  @Sanityy
  Scenario Outline: TID-C8131 - Verify trip booking using all wallet and other payment options
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book tickets with Multi Passenger for Smart Class Round Trip with Extras for wallet "<SheetNam>" and rownumber <RowNumbe>
   And Verify passes packs corp rides credits and cards amount to be detected
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|0|passengers|0|
     