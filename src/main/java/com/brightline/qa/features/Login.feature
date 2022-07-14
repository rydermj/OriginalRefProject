Feature: login feature

 @Sanity
  Scenario Outline: TID-C7900 - Verify Login Scenarios
   Given I am on the BL home page
   When I login with valid provider "<SheetName>" and rownumber <RowNumber>
   Then I verify Sign Out button then verify Sign Out
   
   Examples:
   |SheetName|RowNumber|
   |login|5|
   
  
  Scenario Outline: TID-C804 - Forgot password flow
   Given I am on the BL home page
   When User clicks on Forgot Password link "<SheetName>" and rownumber <RowNumber>
   Then Forgot Password screen should open 
   
   Examples:
   |SheetName|RowNumber|
   |login|0|
  
  Scenario Outline: TID-T154079 - All the Critical Sign up Functionalities to be valdiated
   Given I am on the BL home page
   When Sign up as a new user and verify success message "<SheetName>" and rownumber <RowNumber>
   Then Sign up as a Minor user and verify success message "<SheetNam>" and rownumber <RowNumbe>
     
   Examples:
   |SheetName|RowNumber|SheetNam|RowNumbe|
   |signup|0|minor|0|
   
  @Sanity
  Scenario Outline: TID-C8120 - Verify whether user is able to login with Invalid Credentials
   When I am on the BL home page
   Then I Verify Login With Invalid Credentials "<SheetName>" and rownumber <RowNumber>
   
    Examples:
   |SheetName|RowNumber|
   |login|1|
   |login|2|
   |login|3|
   
  @Sanity
  Scenario Outline: TID-T154080 - Check all critical scenarios for Packs and Passes 
   Given I am on the BL home page
   And  I login with valid provider "<SheetName>" and rownumber <RowNumber>
   When For Passes User should not be able to buy duplicate passes
   Then For Packs User should be able to buy duplicate Packs
   
    Examples:
   |SheetName|RowNumber|
   |login|0|
   
  @Sanity
  Scenario Outline: TID-C8121/C804 - Verify whether user can update New password same as previous one
   When I am on the BL home page
   Then I Verify whether user can login with updated password "<SheetName>" and rownumber <RowNumber>
   And I Verify whether user can update New password same as previous one
   
    Examples:
   |SheetName|RowNumber|
   |login|6|