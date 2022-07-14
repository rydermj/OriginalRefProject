package com.brightline.qa.stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.AccountDashboard;
import com.brightline.qa.pages.ExtrasPage;
import com.brightline.qa.pages.HomePage;
import com.brightline.qa.pages.ManageTrips;
import com.brightline.qa.pages.MobilityRide;
import com.brightline.qa.pages.PurchaseTrainPass;
import com.brightline.qa.pages.PurchaseTravelPacks;
import com.brightline.qa.pages.TrainTicketsBookingPage;
import com.brightline.qa.util.ExcelReader;

import cucumber.api.java.en.Then;

public class Payments_Methods extends BaseClass {
	TrainTicketsBookingPage ticket_booking = new TrainTicketsBookingPage();
	PurchaseTravelPacks purchasetravelpacks = new PurchaseTravelPacks();
	PurchaseTrainPass purchasetrainpass = new PurchaseTrainPass();
	AccountDashboard bashboard = new AccountDashboard();
	MobilityRide mobilityride = new MobilityRide();
	ExtrasPage extrapage = new ExtrasPage();
	ExcelReader reader = new ExcelReader();
	ManageTrips managetrips = new ManageTrips();
	HomePage homepage = new HomePage();

	@Then("User should be able to book trip using saved cards")
	public void User_should_be_able_to_book_trip_using_saved_cards() throws InterruptedException {

		mobilityride.trainTicketBooking(getMonth(),getDay());
		//ticket_booking.ticketPriceSelection(firstname,lastname,dob,email,mobile);
		ticket_booking.ticketBookingSummary();
		ticket_booking.chekOutPage("WithSavedCards");

	}
	
	@Then("User should be able to book the pass using cards")
	public void User_should_be_able_to_book_the_pass_using_cards() throws InterruptedException {
		purchasetrainpass.trainPassToCheckout();
		purchasetravelpacks.viewCartToCheckout();
		ticket_booking.chekOutPage("WithSavedCards");
		

	}
	
	
	@Then("Guest user selects a Train with valid Email id {string} and rownumber {int}")
	public void Guest_user_selects_a_Train_with_valid_Email_id(String sheetNam, Integer rowNumbe) throws InterruptedException, InvalidFormatException, IOException {
		mobilityride.trainTicketBooking(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String firstname = testdata.get(rowNumbe).get("firstname");
		String lastname = testdata.get(rowNumbe).get("lastname");
		String dob = testdata.get(rowNumbe).get("dob");
		String email = testdata.get(rowNumbe).get("email");
	    String mobile = testdata.get(rowNumbe).get("mobile");
		ticket_booking.ticketPriceSelection(firstname,lastname,dob,mobile);
		extrapage.parkingAddSection();
		extrapage.petsAddSection();
		ticket_booking.guestCartContinueButton();
	}
	
	@Then("Guest user should be able to book the ticket using debit or credit card {string} and rownumber {int}")
	public void Guest_user_should_be_able_to_book_the_ticket_using_debit_or_credit_card(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		
		List<Map<String, String>>testdata=homepage.testData(sheetName);
		String cardnumber = testdata.get(rowNumber).get("cardnumber");
		String cardname = testdata.get(rowNumber).get("cardname");
		String expdate = testdata.get(rowNumber).get("expdate");
		String cvv = testdata.get(rowNumber).get("cvv");
	    String address1 = testdata.get(rowNumber).get("address1");
	    String address2 = testdata.get(rowNumber).get("address2");
	    String city = testdata.get(rowNumber).get("city");
	    String zipcode = testdata.get(rowNumber).get("zipcode");
		ticket_booking.GuestUserAddCard(cardnumber,cardname,expdate,cvv,address1,address2,city,zipcode);
		
	}
	
	@Then("User should be able to cancel the trip and amount should refund in form of credits")
	public void user_should_be_able_to_cancel_the_trip_and_amount_should_refund_in_form_of_credits() throws InterruptedException {
		bashboard.walletSectionCreditValue();
		mobilityride.oneWayTrip("May","27");
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WithSavedCards");
		bashboard.ticketValueRefund();
		bashboard.walletSectionCreditValueRecheck();
	}
	
	@Then("User should be able to view the ticket successfully {string} and rownumber {int}")
	public void user_should_be_able_to_view_the_ticket_successfully(String sheetNa, Integer rowNumb) throws InterruptedException, InvalidFormatException, IOException {
		managetrips.manageTrip();
		List<Map<String, String>>testdata=homepage.testData(sheetNa);
		String name = testdata.get(rowNumb).get("name");
		String email = testdata.get(rowNumb).get("email");
		ticket_booking.manageTripSearch(name,email);
	}
	
	@Then("Verify Refund should happen in to primary passenger account")
	public void verify_Refund_should_happen_in_to_primary_passenger_account() throws InterruptedException {
		managetrips.guestUserCancelTrip();
	}
}
