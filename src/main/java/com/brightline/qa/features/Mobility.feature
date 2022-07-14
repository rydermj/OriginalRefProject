Feature: Mobility feature

  Scenario Outline: TID-T154085 - Add to Trip button(First Mile)
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to add private ride as Frist Mile to the trip
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T154077 - Add to Trip button(Last Mile)
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to add private as Last Mile ride to the trip
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T165140 - From/To Station information
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Verify Shared Ride From and To fields metadata
   
   Examples:
   |SheetName|RowNumber|
   |login|0|

  Scenario Outline: TID-T165157 - Guest user Shared ride
   Given I am on the BL home page
   When Guest user adds the shared ride in Extras as First mile and Last mile "<SheetName>" and rownumber <RowNumber>
   Then Ride should be added "<SheetNam>" and rownumber <RowNumbe>
   
    Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |userdetails|0|addcard_address|0|
   
  Scenario Outline: TID-T165158 - Wheelchair Assistance : Check/uncheck
   Given I am on the BL home page
   When Guest user adds the shared ride in Extras as First mile and Last mile "<SheetName>" and rownumber <RowNumber>
   Then User CheckorUncheck Wheelchair Assistance
   And Ride should be added "<SheetNam>" and rownumber <RowNumbe>
   
    Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |userdetails|0|addcard_address|0|
   
  Scenario Outline: TID-T165141 - CHECK AVAIL CTA: Departure/Arrival check 
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Appropriate search results should be carried out
   
    Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T154086 - Multi passenger Ride for First mile
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book a ticket with multiple passengers and include private ride "<SheetNam>" and rownumber <RowNumbe>
   And Booking should be successful and the Private ride should be added for multiple passengers
   
    Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|0|passengers|0|
   
  Scenario Outline: TID-T154084 - Private ride service for Premium bookings
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Private ride should be restricted for Smart bookings
  
    Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T154087 - Adding a service 
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User adds Shared Ride to trip 
   
    Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T165146 - Shared ride to be available for smart/Premium
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User adds Shared Ride to trip and delete the Ride
   
    Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T165147 - First mile/Last mile Shared ride option with checkbox
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Verify Shared Ride From and To fields metadata
   
    Examples:
   |SheetName|RowNumber|
   |login|0|
   
  Scenario Outline: TID-T154076 - Adding Private ride to the Train reservation 
   Given I am on the BL home page
   When  Guest user adds the private ride in Extras as First mile and Last mile "<SheetName>" and rownumber <RowNumber>
   Then Ride should be added "<SheetNam>" and rownumber <RowNumbe>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |userdetails|0|addcard_address|0|
  