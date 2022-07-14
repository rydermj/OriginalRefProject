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

public class Booking_Flow_One_Way extends BaseClass {

	PurchaseTravelPacks purchasetravelpacks = new PurchaseTravelPacks();
	TrainTicketsBookingPage ticket_booking = new TrainTicketsBookingPage();
	PurchaseTrainPass purchasetrainpass = new PurchaseTrainPass();
	AccountDashboard bashboard = new AccountDashboard();
	MobilityRide mobilityride = new MobilityRide();
	ExtrasPage extrapage = new ExtrasPage();
	ExcelReader reader = new ExcelReader();
	HomePage homepage = new HomePage();

	@Then("User should allow to add Extras into trip but Private Ride should not be allow to Add into Trip")
	public void user_should_allow_to_add_Extras_into_trip_but_Private_Ride_should_not_be_allow_to_Add_into_Trip()
			throws InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WithSavedCards");
	}

	@Then("Booking should be successful")
	public void booking_should_be_successful() throws InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WithSavedCards");
	}

	@Then("Booking should be successful with Multi Passenger without Extras {string} and rownumber {int}")
	public void booking_should_be_successful_with_Multi_Passenger_without_Extras(String sheetNam, Integer rowNumbe)
			throws InterruptedException, InvalidFormatException, IOException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.oneWayTripWithMultiPassengers(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String adultfrstname = testdata.get(rowNumbe).get("adultfrstname");
		String adultlstname = testdata.get(rowNumbe).get("adultlstname");
		String kidsfrstname = testdata.get(rowNumbe).get("kidsfrstname");
		String kidslstname = testdata.get(rowNumbe).get("kidslstname");
		String infantfrstname = testdata.get(rowNumbe).get("infantfrstname");
		String infantlstname = testdata.get(rowNumbe).get("infantlstname");
		String value = testdata.get(rowNumbe).get("value");
		mobilityride.oneWaySmartTicket();
		mobilityride.tripWithMultiPassenger(adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname,
				infantlstname, value);
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WithSavedCards");
	}

	@Then("Book tickets with Multi Passenger for Smart Class with Extras {string} and rownumber {int}")
	public void book_tickets_with_Multi_Passenger_for_Smart_Calss_with_Extras_and_rownumber(String sheetNam,
			Integer rowNumbe) throws InvalidFormatException, IOException, InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.oneWayTripWithMultiPassengers(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String adultfrstname = testdata.get(rowNumbe).get("adultfrstname");
		String adultlstname = testdata.get(rowNumbe).get("adultlstname");
		String kidsfrstname = testdata.get(rowNumbe).get("kidsfrstname");
		String kidslstname = testdata.get(rowNumbe).get("kidslstname");
		String infantfrstname = testdata.get(rowNumbe).get("infantfrstname");
		String infantlstname = testdata.get(rowNumbe).get("infantlstname");
		String value = testdata.get(rowNumbe).get("value");
		mobilityride.oneWaySmartTicket();
		mobilityride.tripWithMultiPassenger(adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname,
				infantlstname, value);
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
		extrapage.sharedRideFirstMile();
	}
	

	@Then("Book tickets with Multi Passengers for Smart Class with Extras {string} and rownumber {int}")
	public void book_tickets_with_Multi_Passengers_for_Smart_Calss_with_Extras_and_rownumber(String sheetNam,
			Integer rowNumbe) throws InvalidFormatException, IOException, InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.oneWayTripWithMultiPassengers(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String adultfrstname = testdata.get(rowNumbe).get("adultfrstname");
		String adultlstname = testdata.get(rowNumbe).get("adultlstname");
		String kidsfrstname = testdata.get(rowNumbe).get("kidsfrstname");
		String kidslstname = testdata.get(rowNumbe).get("kidslstname");
		String infantfrstname = testdata.get(rowNumbe).get("infantfrstname");
		String infantlstname = testdata.get(rowNumbe).get("infantlstname");
		String value = testdata.get(rowNumbe).get("value");
		mobilityride.oneWaySmartTicket();
		mobilityride.tripWithMultiPassenger(adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname,
				infantlstname, value);
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
		extrapage.sharedRideFirstMile();
	}

	@Then("Complete booking with Add cards functionality {string} and rownumber {int}")
	public void complete_booking_with_Add_cards_functionality(String sheetNa, Integer rowNumb)
			throws InterruptedException, InvalidFormatException, IOException {
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WithAddCards");
		List<Map<String, String>>testdata=homepage.testData(sheetNa);
		String cardnumber = testdata.get(rowNumb).get("cardnumber");
		String cardname = testdata.get(rowNumb).get("cardname");
		String expdate = testdata.get(rowNumb).get("expdate");
		String cvv = testdata.get(rowNumb).get("cvv");
		String address1 = testdata.get(rowNumb).get("address1");
		String address2 = testdata.get(rowNumb).get("address2");
		String city = testdata.get(rowNumb).get("city");
		String zipcode = testdata.get(rowNumb).get("zipcode");
		ticket_booking.GuestUserAddCard(cardnumber, cardname, expdate, cvv, address1, address2, city, zipcode);

	}

	@Then("Book tickets with private ride and Extras")
	public void Book_tickets_with_private_ride_and_Extras() throws InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWayPremiumTicket();
		mobilityride.viewSeatsAndContinue();
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
		//extrapage.privateRideFirstMile();
	}

	@Then("Book tickets with Multi Passenger for Premium Class with Extras {string} and rownumber {int}")
	public void book_tickets_with_Multi_Passenger_for_Premium_Calss_with_Extras_and_rownumber(String sheetNam,
			Integer rowNumbe) throws InvalidFormatException, IOException, InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
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
		mobilityride.tripWithMultiPassenger(adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname,
				infantlstname, value);
		extrapage.parkingAddSection();
	    extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
		extrapage.sharedRideFirstMile();
	}

	@Then("Guest user adds tickets with Smart Class with Extras {string} and rownumber {int}")
	public void guest_user_adds_tickets_with_Smart_Class_with_Extras_and_rownumber(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
		mobilityride.oneWayTrip(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetName);
		String firstname = testdata.get(rowNumber).get("firstname");
		String lastname = testdata.get(rowNumber).get("lastname");
		String dob = testdata.get(rowNumber).get("dob");
		String email = testdata.get(rowNumber).get("email");
		String mobile = testdata.get(rowNumber).get("mobile");
		mobilityride.oneWaySmartTicket();
		ticket_booking.premiumticketPriceSelection(firstname, lastname, dob, mobile);
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
		extrapage.sharedRideFirstMile();
	}

	@Then("Book tickets with shared ride and Extras for One Way {string} and rownumber {int}")
	public void book_tickets_with_shared_ride_and_Extras_for_One_Way_and_rownumber(String sheetNam, Integer rowNumbe)
			throws InvalidFormatException, IOException, InterruptedException {
		mobilityride.oneWayTripWithMultiPassengers(getMonth(),getDay());
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
		mobilityride.oneWaySmartTicket();
		mobilityride.guesttripWithMultiPassenger(adultfirstname, adultlastname, dob, email, mobile, adultfrstname,
				adultlstname, kidsfrstname, kidslstname, infantfrstname, infantlstname, value);
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
		extrapage.sharedRideFirstMile();
		ticket_booking.guestCartContinueButton();
	}

	@Then("User should be able to Remove items from the Cart {string} and rownumber {int}")
	public void user_should_be_able_to_Remove_items_from_the_Cart_and_rownumber(String sheetNam, Integer rowNumbe)
			throws InvalidFormatException, IOException, InterruptedException {
		mobilityride.oneWayTripWithMultiPassengers(getMonth(),getDay());
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String adultfrstname = testdata.get(rowNumbe).get("adultfrstname");
		String adultlstname = testdata.get(rowNumbe).get("adultlstname");
		String kidsfrstname = testdata.get(rowNumbe).get("kidsfrstname");
		String kidslstname = testdata.get(rowNumbe).get("kidslstname");
		String infantfrstname = testdata.get(rowNumbe).get("infantfrstname");
		String infantlstname = testdata.get(rowNumbe).get("infantlstname");
		String value = testdata.get(rowNumbe).get("value");
		mobilityride.oneWaySmartTicket();
		mobilityride.tripWithMultiPassenger(adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname,
				infantlstname, value);
		ticket_booking.removeTicketfFromCart();
	}
	
	@Then("Book tickets with Multi Passenger for Smart Class with Extras for wallet {string} and rownumber {int}")
	public void book_tickets_with_Multi_Passenger_for_Smart_Calss_with_Extra_and_rownumber(String sheetNam,
			Integer rowNumbe) throws InvalidFormatException, IOException, InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
		mobilityride.oneWayTripWithMultiPassengersWithWallet();
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String adultfrstname = testdata.get(rowNumbe).get("adultfrstname");
		String adultlstname = testdata.get(rowNumbe).get("adultlstname");
		String kidsfrstname = testdata.get(rowNumbe).get("kidsfrstname");
		String kidslstname = testdata.get(rowNumbe).get("kidslstname");
		String infantfrstname = testdata.get(rowNumbe).get("infantfrstname");
		String infantlstname = testdata.get(rowNumbe).get("infantlstname");
		String value = testdata.get(rowNumbe).get("value");
		mobilityride.oneWaySmartTicket();
		mobilityride.tripWithMultiPassenger(adultfrstname, adultlstname, kidsfrstname, kidslstname, infantfrstname,
				infantlstname, value);
		extrapage.parkingAddSection();
		extrapage.sportsEquipmentAddSection();
		extrapage.petsAddSection();
		extrapage.sharedRideFirstMile();
	}


	@Then("Verify passes packs corp rides credits and cards amount to be detected")
	public void verify_passes_packs_corp_rides_credits_and_cards_amount_to_be_detected() throws InterruptedException {
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("TicketCheckoutPageWithAllPayments");
	}
}
