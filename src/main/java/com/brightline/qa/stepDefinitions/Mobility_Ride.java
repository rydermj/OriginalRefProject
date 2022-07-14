package com.brightline.qa.stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.ExtrasPage;
import com.brightline.qa.pages.HomePage;
import com.brightline.qa.pages.MobilityRide;
import com.brightline.qa.pages.PurchaseTrainPass;
import com.brightline.qa.pages.TrainTicketsBookingPage;
import com.brightline.qa.util.ExcelReader;

import cucumber.api.java.en.Then;

public class Mobility_Ride extends BaseClass {
	MobilityRide mobilityride = new MobilityRide();
	ExtrasPage extrapage = new ExtrasPage();
	TrainTicketsBookingPage ticket_booking = new TrainTicketsBookingPage();
	ExcelReader reader = new ExcelReader();
	PurchaseTrainPass purchasetrainpass = new PurchaseTrainPass();
	HomePage homepage = new HomePage();

	@Then("User should be able to add private ride as Frist Mile to the trip")
	public void User_should_be_able_to_add_private_ride_as_Frist_Mile_to_the_trip() throws InterruptedException {

		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWayPremiumTicket();
		mobilityride.viewSeatsAndContinue();
		extrapage.privateRideFirstMile();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WithSavedCards");

	}

	@Then("User should be able to add private ride as Last Mile to the trip")
	public void User_should_be_able_to_add_private_ride_as_Last_Mile_to_the_trip() throws InterruptedException {

		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWayPremiumTicket();
		mobilityride.viewSeatsAndContinue();
		// extrapage.privateRideFirstMile();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WithSavedCards");

	}

	@Then("Verify Shared Ride From and To fields metadata")
	public void Verify_Shared_Ride_From_and_To_fields_metadata() throws InterruptedException {

		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		extrapage.sharedRideFeildsVerification();

	}

	@Then("Guest user adds the shared ride in Extras as First mile and Last mile {string} and rownumber {int}")
	public void Guest_user_adds_the_shared_ride_in_Extras_as_First_mile_and_Last_mile(String sheetName,
			Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {

		mobilityride.oneWayTrip(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetName);
		String firstname = testdata.get(rowNumber).get("firstname");
		String lastname = testdata.get(rowNumber).get("lastname");
		String dob = testdata.get(rowNumber).get("dob");
		String email = testdata.get(rowNumber).get("email");
		String mobile = testdata.get(rowNumber).get("mobile");
		ticket_booking.ticketPriceSelection(firstname, lastname, dob, mobile);

		extrapage.sharedRideFeildsVerification();

	}
	
	@Then("Guest user adds the private ride in Extras as First mile and Last mile {string} and rownumber {int}")
	public void Guest_user_adds_the_private_ride_in_Extras_as_First_mile_and_Last_mile(String sheetName,
			Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {

		mobilityride.oneWayTrip(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetName);
		String firstname = testdata.get(rowNumber).get("firstname");
		String lastname = testdata.get(rowNumber).get("lastname");
		String dob = testdata.get(rowNumber).get("dob");
		String email = testdata.get(rowNumber).get("email");
		String mobile = testdata.get(rowNumber).get("mobile");
		mobilityride.oneWayPremiumTicket();
		
		ticket_booking.premiumticketPriceSelection(firstname, lastname, dob, mobile);

		extrapage.privateRideFirstMile();
		extrapage.privateRideLastMile();
		extrapage.addToTripButton();
		
	}


	@Then("Ride should be added {string} and rownumber {int}")
	public void First_mile_and_Last_mile_shared_ride_should_be_added(String sheetNam, Integer rowNumbe)
			throws InterruptedException, InvalidFormatException, IOException {
		ticket_booking.guestCartContinueButton();
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String cardnumber = testdata.get(rowNumbe).get("cardnumber");
		String cardname = testdata.get(rowNumbe).get("cardname");
		String expdate = testdata.get(rowNumbe).get("expdate");
		String cvv = testdata.get(rowNumbe).get("cvv");
		String address1 = testdata.get(rowNumbe).get("address1");
		String address2 = testdata.get(rowNumbe).get("address2");
		String city = testdata.get(rowNumbe).get("city");
		String zipcode = testdata.get(rowNumbe).get("zipcode");

		ticket_booking.GuestUserAddCard(cardnumber, cardname, expdate, cvv, address1, address2, city, zipcode);

	}

	@Then("User CheckorUncheck Wheelchair Assistance")
	public void User_CheckorUncheck_Wheelchair_Assistance() throws InterruptedException {
		extrapage.sharedRideWithChair();
	}

	
	@Then("Appropriate search results should be carried out")
	public void appropriate_search_results_should_be_carried_out() throws InterruptedException {
		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		extrapage.sharedRideSearchFunctionality();
	}
	
	@Then("Book a ticket with multiple passengers and include private ride {string} and rownumber {int}")
	public void book_a_ticket_with_multiple_passengers_and_include_private_ride(String sheetNam, Integer rowNumbe) throws InterruptedException, InvalidFormatException, IOException {
		mobilityride.oneWayTripWithMultiPassengers(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String adultfrstname = testdata.get(rowNumbe).get("adultfrstname");
		String adultlstname = testdata.get(rowNumbe).get("adultlstname");
		String kidsfrstname = testdata.get(rowNumbe).get("kidsfrstname");
		String kidslstname = testdata.get(rowNumbe).get("kidslstname");
		String infantfrstname = testdata.get(rowNumbe).get("infantfrstname");
		String infantlstname = testdata.get(rowNumbe).get("infantlstname");
		String value = testdata.get(rowNumbe).get("value");

		mobilityride.oneWayPremiumTicket();
		mobilityride.tripWithMultiPassenger(adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname, infantlstname, value);
	}

	@Then("Booking should be successful and the Private ride should be added for multiple passengers")
	public void booking_should_be_successful_and_the_Private_ride_should_be_added_for_multiple_passengers() throws InterruptedException {
		extrapage.privateRideFirstMile();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WithSavedCards");
	}
	
	@Then("Private ride should be restricted for Smart bookings")
	public void private_ride_should_be_restricted_for_Smart_bookings() throws InterruptedException {
	   
		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		extrapage.addExtrasSection();
		extrapage.privateRideRistrictedForSmart();
		
	}
	
	@Then("User adds Shared Ride to trip")
	public void user_adds_Shared_Ride_to_trip() throws InterruptedException {
		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		extrapage.sharedRideFirstMile();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WithSavedCards");
	}
	
	@Then("User adds Shared Ride to trip and delete the Ride")
	public void user_adds_Shared_Ride_to_trip_and_delete_the_Ride() throws InterruptedException {
		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		extrapage.sharedRideFirstMile();
		ticket_booking.removeTicketfFromCart();
		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWayPremiumTicket();
		mobilityride.viewSeatsAndContinue();
		extrapage.rideVerification();
	}
	
}
