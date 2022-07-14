package com.brightline.qa.stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.AccountDashboard;
import com.brightline.qa.pages.AccountSection;
import com.brightline.qa.pages.MobilityRide;
import com.brightline.qa.util.ExcelReader;

import cucumber.api.java.en.Then;

public class Account_Section extends BaseClass {
	
	AccountSection accountsection = new AccountSection();
	ExcelReader reader = new ExcelReader();
	String sheetnam = "addcard";
	AccountDashboard accountdashboard = new AccountDashboard();
	MobilityRide mobilityride = new MobilityRide();
	

	@Then("User should be able to add a new card details {string} and rownumber {int}")
	public void User_should_be_able_to_add_a_new_card_details(String sheetNam, Integer rowNumbe)throws InterruptedException, InvalidFormatException, IOException {
		
		accountsection.accountWalletSection();
		
		List<Map<String, String>> testdata = reader.getData(".//src/main/java/com/brightline/qa/testdata/excel_testdata.xlsx",
				sheetNam);
		String cardnumber = testdata.get(rowNumbe).get("cardnumber");
		String cardname = testdata.get(rowNumbe).get("cardname");
		String expdate = testdata.get(rowNumbe).get("expdate");
		String cvv = testdata.get(rowNumbe).get("cvv");

		accountsection.addCard(cardnumber,cardname,expdate,cvv);

	}
	@Then("I verify Add Travelers metadata")
	public void I_verify_Add_Travelers_metadata() throws InterruptedException {
		accountsection.accountAddTraveler();
	}
	
	@Then("User should be able to Add the CoPassenger successfully {string} and rownumber {int}")
	public void user_should_be_able_to_Add_the_Passenger_successfully(String sheetNam, Integer rowNumbe) throws InvalidFormatException, IOException, InterruptedException {
			List<Map<String, String>> testdata = reader.getData(".//src/main/java/com/brightline/qa/testdata/excel_testdata.xlsx",
					sheetNam);
			String frstname = testdata.get(rowNumbe).get("firstname");
			String lstname = testdata.get(rowNumbe).get("lastname");
			String  dob= testdata.get(rowNumbe).get("dob");
			accountsection.accountAddCoPassenger(frstname,lstname,dob);
	}
	
	@Then("User should be able to modify only First name Last name and Mobile number {string} and rownumber {int}")
	public void user_should_be_able_to_modify_only_First_name_Last_name_and_Mobile_number(String sheetNam, Integer rowNumbe) throws InterruptedException, InvalidFormatException, IOException {
		List<Map<String, String>> testdata = reader.getData(".//src/main/java/com/brightline/qa/testdata/excel_testdata.xlsx",
				sheetNam);
		String frstname = testdata.get(rowNumbe).get("firstname");
		String lstname = testdata.get(rowNumbe).get("lastname");
		String phnumber = testdata.get(rowNumbe).get("phnumber");
		accountsection.accountManageProfile(frstname,lstname,phnumber);
	}
	
	@Then("User should be able to add the Infant\\/Kid and An adult {string} and rownumber {int}")
	public void user_should_be_able_to_add_the_Infant_Kid_and_An_adult_and_rownumber(String sheetNam, Integer rowNumbe) throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> testdata = reader.getData(".//src/main/java/com/brightline/qa/testdata/excel_testdata.xlsx",
				sheetNam);
		String frstname = testdata.get(rowNumbe).get("firstname");
		String lstname = testdata.get(rowNumbe).get("lastname");
		String dob = testdata.get(rowNumbe).get("dob");
		accountsection.accountAddCoPassenger(frstname,lstname,dob);
	}
	
	@Then("User should not be able to add passenger {string} and rownumber {int}")
	public void user_should_not_be_able_to_add_passenger_and_rownumber(String sheetNam, Integer rowNumbe) throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> testdata = reader.getData(".//src/main/java/com/brightline/qa/testdata/excel_testdata.xlsx",
				sheetNam);
		String frstname = testdata.get(rowNumbe).get("firstname");
		String lstname = testdata.get(rowNumbe).get("lastname");
		String dob = testdata.get(rowNumbe).get("dob");
		accountsection.accountAddCoPassenger(frstname,lstname,dob);
	}
	
	@Then("User should navigate back to bl wallet page after clicking on close button")
	public void user_should_navigate_back_to_bl_wallet_page_after_clicking_on_close_button() throws InterruptedException {
		accountsection.accountAddCoPassengerCancelbtn();
	}
	
	@Then("User should not be able to add passenger without FN and LN")
	public void user_should_not_be_able_to_add_passenger_without_FN_and_LN() throws InterruptedException {
		accountsection.accountAddCoPassengerWithoutFirstNameLastName();
	}
	
	@Then("User should be able delete saved traveller successfully")
	public void user_should_be_able_delete_saved_traveller_successfully() throws InterruptedException {
		accountsection.viewAndDeleteTraveler();
	}
	
	
	@Then("Verify whether user able to see saved traveller in passenegr details page {string} and rownumber {int}")
	public void verify_whether_user_able_to_see_saved_traveller_in_passenegr_details_page_and_rownumber(String sheetNam, Integer rowNumbe) throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> testdata = reader.getData(".//src/main/java/com/brightline/qa/testdata/excel_testdata.xlsx",
				sheetNam);
		String frstname = testdata.get(rowNumbe).get("firstname");
		String lstname = testdata.get(rowNumbe).get("lastname");
		String  dob= testdata.get(rowNumbe).get("dob");
		accountsection.accountAddCoPassenger(frstname,lstname,dob);
		mobilityride.oneWayTripWithMultiPassengers("May","31");
		mobilityride.oneWaySmartTicket();
		mobilityride.verifyPassengerValue();
	}
	
	@Then("Verify removed saved traveller shouldn't be displayed in passenegr details page")
	public void verify_removed_saved_traveller_shouldn_t_be_displayed_in_passenegr_details_page() throws InterruptedException {
		accountsection.viewAndDeleteTraveler();
		mobilityride.oneWayTripWithMultiPassengers("May","31");
		mobilityride.oneWaySmartTicket();
		mobilityride.verifyPassengerValue();
	}
	
	@Then("User should be able to Delete Added card successfully")
	public void user_should_be_able_to_Delete_Added_card_successfully() throws InterruptedException {
		accountsection.deletAddedCard();
	}

}
