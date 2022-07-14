package com.brightline.qa.stepDefinitions;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.AccountDashboard;
import com.brightline.qa.pages.ExtrasPage;
import com.brightline.qa.pages.MobilityRide;
import com.brightline.qa.pages.PurchaseParkingPass;
import com.brightline.qa.pages.PurchaseTrainPass;
import com.brightline.qa.pages.PurchaseTravelPacks;
import com.brightline.qa.pages.TrainTicketsBookingPage;

import cucumber.api.java.en.Then;

public class Purchase_Parking_Pass extends BaseClass {

	PurchaseTrainPass purchasetrainpass = new PurchaseTrainPass();
	PurchaseParkingPass purchaseparkingpass = new PurchaseParkingPass();
	PurchaseTravelPacks purchasetravelpacks = new PurchaseTravelPacks();
	AccountDashboard bashboard = new AccountDashboard();
	TrainTicketsBookingPage ticket_booking = new TrainTicketsBookingPage();
	MobilityRide mobilityride = new MobilityRide();
	ExtrasPage extrapage = new ExtrasPage();



	@Then("I navigate to Parking Pass page and verify Parking Pass metadata")
	public void I_navigate_to_Parking_Pass_page_and_verify_Parking_Pass_metadata() throws InterruptedException {
		purchaseparkingpass.parkingPass();
	}
	
	@Then("User navigates to parking pass page from walletsection and checks AutoRenewal functionality")
	public void User_navigates_to_parkingpass_page_from_walletsection_and_checks_AutoRenewal_functionality()
			throws InterruptedException {
		bashboard.walletSection();
		purchaseparkingpass.parkingPageFromWalletSection();
		purchasetrainpass.autoRenewalFunctionality();
	}
	
	@Then("Verify Parking Pass Eligibility for refund")
	public void Verify_Parking_Pass_Eligibility_for_Refund() throws InterruptedException {
		bashboard.walletSection();
		purchaseparkingpass.parkingPassEligibility();
	}
	
	@Then("Validation message to be displayed")
	public void validation_message_to_be_displayed() throws InterruptedException {
		purchaseparkingpass.parkingPassWithoutLicensePlate();
	}	
	
	@Then("User should be able buy and Auto Renew the Parking pass")
	public void user_should_be_able_buy_the_Parking_pass() throws InterruptedException {
		purchaseparkingpass.purchaseParkingPassWithAuto();
		purchasetravelpacks.viewCartToCheckout();
		ticket_booking.chekOutPage("TicketCheckoutPage");
		bashboard.parkingPassCancel();
	}
	
	@Then("User should be able to book a ticket\\/ride with purchased parking pass")
	public void user_should_be_able_to_book_a_ticket_ride_with_purchased_parking_pass() throws InterruptedException {
		purchaseparkingpass.purchaseParkingPassWithAuto();
		purchasetravelpacks.viewCartToCheckout();
		ticket_booking.chekOutPage("TicketCheckoutPage");
		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		extrapage.extrasParkingPassApplied();
		bashboard.parkingPassCancel();
	}
}
