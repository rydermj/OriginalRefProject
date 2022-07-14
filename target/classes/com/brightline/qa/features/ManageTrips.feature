Feature: Manage Trips feature

  
  Scenario: TID-T165137 - Manage Trips flow
   Given I am on the BL home page
   When I Click on the Manage Trips menu under Ticket and Travels Navigator menu
   Then Manage Trips page should open
   
   
 @Sanity
  Scenario Outline: TID-C8226 - Verify Guest user cancellation and Refund
   Given I am on the BL home page
   When Guest user selects a Train with valid Email id "<SheetNam>" and rownumber <RowNumbe>
   Then Guest user should be able to book the ticket using debit or credit card "<SheetName>" and rownumber <RowNumber>
   And User should be able to cancel the ticket successfully
   
    Examples:
   |SheetNam|RowNumbe|SheetName|RowNumber|
   |userdetails|0|addcard_address|0|
   
  @Sanity
  Scenario Outline: TID-C8002 -  Verify whether User is able to Add passenger
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should allow to add Extras into trip but Private Ride should not be allow to Add into Trip
   And User should be able to add Passenger succesully
   
   Examples:
   |SheetName|RowNumber|
   |login|5| 
 
  @Sanity
  Scenario Outline: TID-C8005 - Verify whether user is able to edit the Trip--> Change Date
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should allow to add Extras into round trip but Private Ride should not be allow to Add into Trip
   And User should be able to Modify his/her ticket/ride with Change in trip date
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
  
  @Sanity
  Scenario Outline: TID-C8001 - Verify whether user is able to edit the Round Trip-->Change Time
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should allow to add Extras into round trip but Private Ride should not be allow to Add into Trip
   And User should be able to Modify his/her ticket/ride with Change in trip timing
   
   Examples:
   |SheetName|RowNumber|
   |login|5|
   
  @Sanity
  Scenario Outline: TID-C8247 - Verify whether the Primary Guest user is allowed to edit or remove or cancel the primary passenger
   Given I am on the BL home page
   When Book tickets with private ride and Extras for Round Trip "<SheetNam>" and rownumber <RowNumbe>
   Then Guest user should be able to book the ticket using debit or credit card "<SheetName>" and rownumber <RowNumber>
   And Primary passenger of Guest user is allowed to make any changes to the Co passenger
   
    Examples:
   |SheetNam|RowNumbe|SheetName|RowNumber|
   |guestpassengers|0|addcard_address|0|
   
  @Sanity
  Scenario Outline: TID-C8003 - Verify whether User is able to Cancel the Already Added passenger
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book tickets with Multi Passenger for Smart Class Round Trip with Extras "<SheetNam>" and rownumber <RowNumbe>
   And Complete booking with Add cards functionality "<SheetNa>" and rownumber <RowNumb>
   And user should be able to Cancel the passenger successfully and Refund should get reflected in BL wallet in Credit section
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|SheetNa|RowNumb|
   |login|0|passengers|0|addcard_address|0|
       
  @Sanity
  Scenario Outline: TID-C8247 - Verify whether the Primary Guest user is allowed to edit or remove or cancel the primary passenger
   Given I am on the BL home page
   When Book tickets with private ride and Extras for Round Trip "<SheetNam>" and rownumber <RowNumbe>
   Then Guest user should be able to book the ticket using debit or credit card "<SheetName>" and rownumber <RowNumber>
   And User should be able to Cancel the passenger successfully
   
    Examples:
   |SheetNam|RowNumbe|SheetName|RowNumber|
   |guestpassengers|0|addcard_address|0|
   
  @Sanity
  Scenario Outline: TID-C8241 - Verify whether primary passenger is allowed to edit, add or remove the co passengers or extras from the trip
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Book tickets with Multi Passenger for Smart Class Round Trip with Extras "<SheetNam>" and rownumber <RowNumbe>
   And Complete booking with Add cards functionality "<SheetNa>" and rownumber <RowNumb>
   And Primary passenger is allowed to Edit, Add or Remove co passenger and Edit extras to the trip
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|SheetNa|RowNumb|
   |login|5|passengers|0|addcard_address|0|
   
 @Sanity
  Scenario Outline: TID-C8004 - Verify whether user is able to Change name of a Passenger
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should allow to add Extras into round trip but Private Ride should not be allow to Add into Trip
   And Primary Passenger Should not be able to Updated/Modify his/Her details.
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
   @Sanity
  Scenario Outline: TID-C8006 - Verify Whether Extra Pack will consume on changing name / changing Seat
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should allow to add Extras into round trip but Private Ride should not be allow to Add into Trip
   And On changing name or changing seat user shouldn't be able to consume packs
   
   Examples:
   |SheetName|RowNumber|
   |login|5|