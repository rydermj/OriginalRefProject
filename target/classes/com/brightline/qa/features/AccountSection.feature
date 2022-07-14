Feature: Account Section feature

Background:
 Given I am on the BL home page


  @Sanity
  Scenario Outline: TID -C7998 - Verify whether user is able to add Cards under Saved cards
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to add a new card details "<SheetNam>" and rownumber <RowNumbe>
   And User should be able to Delete Added card successfully
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|0|addcard|0|
  
  
  Scenario Outline: TID-T154064 - Add Traveler
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then I verify Add Travelers metadata
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
   
  @Sanity
  Scenario Outline: TID-C7999 - Verify whether user is able to add Co-passenger Under Saved Travellers
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to Add the CoPassenger successfully "<SheetNam>" and rownumber <RowNumbe>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|0|copassenger|0| 
   
   @Sanity
  Scenario Outline: TID-C8000 - Verify Manage Profile
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to modify only First name Last name and Mobile number "<SheetNam>" and rownumber <RowNumbe>
   
    Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|0|profile|1|
   
  @Regression
  Scenario Outline: TID-C8887 - Verify add traveller with valid details(infants,kid,adult)
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to add the Infant/Kid and An adult "<SheetNam>" and rownumber <RowNumbe>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|0|copassenger|1|
   |login|0|copassenger|2|
   
   
   @Regression
  Scenario Outline: TID-C8890 - Verify whether user able to add traveller without first name and last name ---> nagative
                    TID-C8888 - Verify add traveller with invalid details ---> nagative
                    TID-C8889 - Verify close button in add traveller window
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should not be able to add passenger without FN and LN
   And User should navigate back to bl wallet page after clicking on close button
   And User should not be able to add passenger "<SheetNam>" and rownumber <RowNumbe>
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|0|copassenger|3|
   
   @Regression
  Scenario Outline: TID-C8891 - Verify whether user able to remove saved traveller
                    TID-C8895 - Verify whether user able to click on view all link
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then User should be able to Add the CoPassenger successfully "<SheetNam>" and rownumber <RowNumbe>
   And User should be able delete saved traveller successfully
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|5|copassenger|0| 
   
   
   @Regression
  Scenario Outline: TID-C8892 - Verify whether user able to see saved traveller in passenegr details page
                    TID-C8893 - Verify whether user able to see removed saved traveller in passenegr details page ----> nagative
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then Verify whether user able to see saved traveller in passenegr details page "<SheetNam>" and rownumber <RowNumbe>
   And Verify removed saved traveller shouldn't be displayed in passenegr details page
   
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |login|5|copassenger|0|
   