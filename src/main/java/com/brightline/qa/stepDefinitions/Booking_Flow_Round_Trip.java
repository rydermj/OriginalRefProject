package com.brightline.qa.stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.AccountDashboard;
import com.brightline.qa.pages.ExtrasPage;
import com.brightline.qa.pages.HomePage;
import com.brightline.qa.pages.MobilityRide;
import com.brightline.qa.pages.PurchaseTrainPass;
import com.brightline.qa.pages.PurchaseTravelPacks;
import com.brightline.qa.pages.TrainTicketsBookingPage;
import com.brightline.qa.util.ExcelReader;

import cucumber.api.java.en.Then;

public class Booking_Flow_Round_Trip  extends BaseClass {

	PurchaseTravelPacks purchasetravelpacks = new PurchaseTravelPacks();
	TrainTicketsBookingPage ticket_booking = new TrainTicketsBookingPage();
	PurchaseTrainPass purchasetrainpass = new PurchaseTrainPass();
	AccountDashboard bashboard = new AccountDashboard();
	MobilityRide mobilityride = new MobilityRide();
	ExtrasPage extrapage = new ExtrasPage();
	ExcelReader reader = new ExcelReader();
	HomePage homepage = new HomePage();
	
	@Then("Booking should be successful for Single passenger Round Trip without any extras {string} and rownumber {int}")
	public void booking_should_be_successful_for_Single_passenger_Round_Trip_without_any_extras(String sheetNam, Integer rowNumbe) throws InterruptedException, InvalidFormatException, IOException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.trainTicketBooking(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String firstname = testdata.get(rowNumbe).get("firstname");
		String lastname = testdata.get(rowNumbe).get("lastname");
		String dob = testdata.get(rowNumbe).get("dob");
		String email = testdata.get(rowNumbe).get("email");
	    String mobile = testdata.get(rowNumbe).get("mobile");
	    mobilityride.roundTripSmartTicket();
		mobilityride.viewSeatsAndContinue();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WithSavedCards");
	}
	
	@Then("Booking should be successful for Multi passenger Round Trip without any extras {string} and rownumber {int}")
	public void book_tickets_with_Multi_Passenger_for_Premium_Calss_with_Extras_and_rownumber(String sheetNam, Integer rowNumbe) throws InvalidFormatException, IOException, InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.roundTrip();
		mobilityride.oneWayTripWithMultiPassengers(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String adultfrstname = testdata.get(rowNumbe).get("adultfrstname");
		String adultlstname = testdata.get(rowNumbe).get("adultlstname");
		String kidsfrstname = testdata.get(rowNumbe).get("kidsfrstname");
		String kidslstname = testdata.get(rowNumbe).get("kidslstname");
		String infantfrstname = testdata.get(rowNumbe).get("infantfrstname");
		String infantlstname = testdata.get(rowNumbe).get("infantlstname");
		String value = testdata.get(rowNumbe).get("value");
		mobilityride.roundTripPremiumTicket();
		mobilityride.tripWithMultiPassenger(adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname, infantlstname, value);
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WithSavedCards");
	}
	
	@Then("User should allow to add Extras into round trip but Private Ride should not be allow to Add into Trip")
	public void user_should_allow_to_add_Extras_into_round_trip_but_Private_Ride_should_not_be_allow_to_Add_into_Trip() throws InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.trainTicketBooking(getMonth(),getDay());
		mobilityride.roundTripSmartTicket();
		mobilityride.viewSeatsAndContinue();
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WithSavedCards");
	}

	@Then("Book tickets with Multi Passenger for Smart Class Round Trip with Extras {string} and rownumber {int}")
	public void book_tickets_with_Multi_Passenger_for_Smart_Calss_with_Extras_and_rownumber(String sheetNam, Integer rowNumbe) throws InvalidFormatException, IOException, InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.roundTrip();
		mobilityride.roundTripWithMultiPassengers(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String adultfrstname = testdata.get(rowNumbe).get("adultfrstname");
		String adultlstname = testdata.get(rowNumbe).get("adultlstname");
		String kidsfrstname = testdata.get(rowNumbe).get("kidsfrstname");
		String kidslstname = testdata.get(rowNumbe).get("kidslstname");
		String infantfrstname = testdata.get(rowNumbe).get("infantfrstname");
		String infantlstname = testdata.get(rowNumbe).get("infantlstname");
		String value = testdata.get(rowNumbe).get("value");
		mobilityride.roundTripSmartTicket();
		mobilityride.tripWithMultiPassenger(adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname, infantlstname, value);
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
	}
	
	@Then("Book tickets with Multi Passengers for Smart Class Round Trip with Extras {string} and rownumber {int}")
	public void book_tickets_with_Multi_Passengers_for_Smart_Calss_with_Extras_and_rownumber(String sheetNam, Integer rowNumbe) throws InvalidFormatException, IOException, InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.roundTrip();
		mobilityride.roundTripWithMultiPassengers(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String adultfrstname = testdata.get(rowNumbe).get("adultfrstname");
		String adultlstname = testdata.get(rowNumbe).get("adultlstname");
		String kidsfrstname = testdata.get(rowNumbe).get("kidsfrstname");
		String kidslstname = testdata.get(rowNumbe).get("kidslstname");
		String infantfrstname = testdata.get(rowNumbe).get("infantfrstname");
		String infantlstname = testdata.get(rowNumbe).get("infantlstname");
		String value = testdata.get(rowNumbe).get("value");
		mobilityride.roundTripSmartTicket();
		mobilityride.tripWithMultiPassenger(adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname, infantlstname, value);
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
	}
	
	@Then("Book tickets with private ride and Extras for Round Trip")
	public void Book_tickets_with_private_ride_and_Extras() throws InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.trainTicketBooking(getMonth(),getDay());
		mobilityride.roundTripPremiumTicket();
		mobilityride.viewSeatsAndContinue();
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
		//extrapage.privateRideFirstMile();
	}
	
	@Then("Book tickets with premium class with shared ride and Extras for Round Trip {string} and rownumber {int}")
	public void book_tickets_with_premium_class_with_shared_ride_and_Extras_for_Round_Trip(String sheetNam, Integer rowNumbe) throws InterruptedException, InvalidFormatException, IOException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.roundTrip();
		mobilityride.roundTripWithMultiPassengers(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String adultfrstname = testdata.get(rowNumbe).get("adultfrstname");
		String adultlstname = testdata.get(rowNumbe).get("adultlstname");
		String kidsfrstname = testdata.get(rowNumbe).get("kidsfrstname");
		String kidslstname = testdata.get(rowNumbe).get("kidslstname");
		String infantfrstname = testdata.get(rowNumbe).get("infantfrstname");
		String infantlstname = testdata.get(rowNumbe).get("infantlstname");
		String value = testdata.get(rowNumbe).get("value");
		mobilityride.roundTripPremiumTicket();
		mobilityride.tripWithMultiPassenger(adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname, infantlstname, value);
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
		extrapage.sharedRideFirstMile();
	}
	
	@Then("Book tickets with shared ride and Extras for Round Trip {string} and rownumber {int}")
	public void book_tickets_with_shared_ride_and_Extras_for_Round_Trip_and_rownumber(String sheetNam, Integer rowNumbe) throws InterruptedException, InvalidFormatException, IOException {
		mobilityride.roundTrip();
		mobilityride.roundTripWithMultiPassengers(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String adultfirstname = testdata.get(rowNumbe).get("adultfirstname");
		String adultlastname = testdata.get(rowNumbe).get("adultlastname");
		String dob = testdata.get(rowNumbe).get("dob");
		String email = testdata.get(rowNumbe).get("email");
		String mobile = testdata.get(rowNumbe).get("mobile");
		String adultfrstname = testdata.get(rowNumbe).get("adultfrstname");
		String adultlstname = testdata.get(rowNumbe).get("adultlstname");
		String kidsfrstname = testdata.get(rowNumbe).get("kidsfrstname");
		String kidslstname = testdata.get(rowNumbe).get("kidslstname");
		String infantfrstname = testdata.get(rowNumbe).get("infantfrstname");
		String infantlstname = testdata.get(rowNumbe).get("infantlstname");
		String value = testdata.get(rowNumbe).get("value");
		mobilityride.roundTripSmartTicket();
		mobilityride.guesttripWithMultiPassenger(adultfirstname,adultlastname,dob,email,mobile,adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname, infantlstname, value);
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
	    extrapage.petsAddSection();
		extrapage.sharedRideFirstMile();
		ticket_booking.guestCartContinueButton();
	}
	
	@Then("Book tickets with private ride and Extras for Round Trip {string} and rownumber {int}")
	public void book_tickets_with_private_ride_and_Extras_for_Round_Trip_and_rownumber(String sheetNam, Integer rowNumbe) throws InvalidFormatException, IOException, InterruptedException {
		mobilityride.roundTrip();
		mobilityride.roundTripWithMultiPassengers(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String adultfirstname = testdata.get(rowNumbe).get("adultfirstname");
		String adultlastname = testdata.get(rowNumbe).get("adultlastname");
		String dob = testdata.get(rowNumbe).get("dob");
		String email = testdata.get(rowNumbe).get("email");
		String mobile = testdata.get(rowNumbe).get("mobile");
		String adultfrstname = testdata.get(rowNumbe).get("adultfrstname");
		String adultlstname = testdata.get(rowNumbe).get("adultlstname");
		String kidsfrstname = testdata.get(rowNumbe).get("kidsfrstname");
		String kidslstname = testdata.get(rowNumbe).get("kidslstname");
		String infantfrstname = testdata.get(rowNumbe).get("infantfrstname");
		String infantlstname = testdata.get(rowNumbe).get("infantlstname");
		String value = testdata.get(rowNumbe).get("value");
		mobilityride.roundTripPremiumTicket();
		mobilityride.guesttripWithMultiPassenger(adultfirstname,adultlastname,dob,email,mobile,adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname, infantlstname, value);
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
		//extrapage.privateRideFirstMile();
		ticket_booking.guestCartContinueButton();
	}
	
	@Then("Book tickets with Multi Passenger for Smart Class Round Trip with Extras for wallet {string} and rownumber {int}")
	public void book_tickets_with_Multi_Passenger_for_Smart_Calss_with_Extra_and_rownumber(String sheetNam, Integer rowNumbe) throws InvalidFormatException, IOException, InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.roundTrip();
		mobilityride.roundTripWithMultiPassengersWithWallet(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String adultfrstname = testdata.get(rowNumbe).get("adultfrstname");
		String adultlstname = testdata.get(rowNumbe).get("adultlstname");
		String kidsfrstname = testdata.get(rowNumbe).get("kidsfrstname");
		String kidslstname = testdata.get(rowNumbe).get("kidslstname");
		String infantfrstname = testdata.get(rowNumbe).get("infantfrstname");
		String infantlstname = testdata.get(rowNumbe).get("infantlstname");
		String value = testdata.get(rowNumbe).get("value");
		mobilityride.roundTripSmartTicket();
		mobilityride.tripWithMultiPassenger(adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname, infantlstname, value);
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
		extrapage.sharedRideFirstMile();
	}
	
}
