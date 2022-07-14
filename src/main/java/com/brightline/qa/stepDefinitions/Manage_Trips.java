package com.brightline.qa.stepDefinitions;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.AccountDashboard;
import com.brightline.qa.pages.ExtrasPage;
import com.brightline.qa.pages.ManageTrips;
import com.brightline.qa.pages.MobilityRide;
import com.brightline.qa.pages.PurchaseTrainPass;
import com.brightline.qa.pages.PurchaseTravelPacks;
import com.brightline.qa.pages.TrainTicketsBookingPage;
import com.brightline.qa.util.ExcelReader;

import cucumber.api.java.en.Then;

public class Manage_Trips extends BaseClass {

	ManageTrips managetrips = new ManageTrips();
	ExtrasPage extrapage = new ExtrasPage();
	PurchaseTravelPacks purchasetravelpacks = new PurchaseTravelPacks();
	TrainTicketsBookingPage ticket_booking = new TrainTicketsBookingPage();
	PurchaseTrainPass purchasetrainpass = new PurchaseTrainPass();
	AccountDashboard bashboard = new AccountDashboard();
	MobilityRide mobilityride = new MobilityRide();
	ExcelReader reader = new ExcelReader();

	@Then("I Click on the Manage Trips menu under Ticket and Travels Navigator menu")
	public void I_Click_on_the_Manage_Trips_menu_under_Ticket_and_Travels_Navigator_menu() throws InterruptedException {
		managetrips.manageTrip();
	}

	@Then("Manage Trips page should open")
	public void Manage_Trips_page_should_open() throws InterruptedException {
		managetrips.manageTripPage();
	}

	@Then("User edits Trip and verifies Extras data")
	public void User_edits_Trip_and_verifies_Extras_data() throws InterruptedException {
		managetrips.editTripGuestUser();
		extrapage.extrasAfterChangeTrip();
	}

	@Then("User should be able to cancel the ticket successfully")
	public void user_should_be_able_to_cancel_the_ticket_successfully() throws InterruptedException {
		managetrips.guestUserCancelTrip();
	}

	@Then("User should be able to add Passenger succesully")
	public void user_should_be_able_to_add_Passenger_succesully() throws InterruptedException {
		managetrips.editTripAddPassenger();
		extrapage.extrasAfterAddingPassenger();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WithSavedCards");
	}

	@Then("User should be able to Modify his\\/her ticket\\/ride with Change in trip date")
	public void user_should_be_able_to_Modify_his_her_ticket_ride_with_Change_in_trip_date() throws InterruptedException {
		managetrips.editTripChangeDate();
		extrapage.extrasAfterAddingPassenger();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WalletTicketCheckoutPage");
	}
	
	@Then("User should be able to Modify his\\/her ticket\\/ride with Change in trip timing")
	public void user_should_be_able_to_Modify_his_her_ticket_ride_with_Change_in_trip_timing() throws InterruptedException {
		managetrips.editTripChangeTime();
		extrapage.extrasAfterAddingPassenger();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WalletTicketCheckoutPage");
	}
	
	@Then("Primary passenger of Guest user is allowed to make any changes to the Co passenger")
	public void primary_passenger_of_Guest_user_is_allowed_to_make_any_changes_to_the_Co_passenger() throws InterruptedException {
		managetrips.editTripChangeNameMultiUser();
		extrapage.extrasAfterAddingPassenger();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WalletTicketCheckoutPage");
	}
   
	@Then("user should be able to Cancel the passenger successfully and Refund should get reflected in BL wallet in Credit section")
	public void user_should_be_able_to_Cancel_the_passenger_successfully_and_Refund_should_get_reflected_in_BL_wallet_in_Credit_section() throws InterruptedException {
		managetrips.editTripCancelPassenger();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WalletTicketCheckoutPage");
		bashboard.verifyRefundValueOnCancellingPassenger();
	}
	
	@Then("User should be able to Cancel the passenger successfully")
	public void user_should_be_able_to_Cancel_the_passenger_successfully() throws InterruptedException {
		managetrips.editTripCancelPassenger();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WalletTicketCheckoutPage");
	}
	
	@Then("Primary passenger is allowed to Edit, Add or Remove co passenger and Edit extras to the trip")
	public void primary_passenger_is_allowed_to_Edit_Add_or_Remove_co_passenger_and_Edit_extras_to_the_trip() throws InterruptedException {
		managetrips.editTripChangeNameMultiUser();
		extrapage.editExtrasAfterAddingPassenger();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WalletTicketCheckoutPage");
	}
	
	@Then("Primary Passenger Should not be able to Updated\\/Modify his\\/Her details.")
	public void primary_Passenger_Should_not_be_able_to_Updated_Modify_his_Her_details() throws InterruptedException {
		managetrips.editTripPassengerShouldNotEdit();
	}
	
	@Then("On changing name or changing seat user shouldn't be able to consume packs")
	public void on_changing_name_or_changing_seat_user_shouldn_t_be_able_to_consume_packs() throws InterruptedException {
		managetrips.editTripAfterChangingSeats();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WalletTicketCheckoutPage");
	}
}
