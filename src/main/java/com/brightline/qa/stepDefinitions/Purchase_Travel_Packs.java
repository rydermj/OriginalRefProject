package com.brightline.qa.stepDefinitions;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.AccountDashboard;
import com.brightline.qa.pages.ExtrasPage;
import com.brightline.qa.pages.MobilityRide;
import com.brightline.qa.pages.PurchaseTrainPass;
import com.brightline.qa.pages.PurchaseTravelPacks;
import com.brightline.qa.pages.TrainTicketsBookingPage;

import cucumber.api.java.en.Then;

public class Purchase_Travel_Packs extends BaseClass {

	PurchaseTravelPacks purchasetravelpacks = new PurchaseTravelPacks();
	AccountDashboard bashboard = new AccountDashboard();
	TrainTicketsBookingPage ticket_booking = new TrainTicketsBookingPage();
	PurchaseTrainPass purchasetrainpass = new PurchaseTrainPass();
	MobilityRide mobilityride = new MobilityRide();
	ExtrasPage extrapage = new ExtrasPage();

	@Then("I validate Travel Packs metadata")
	public void I_validate_Travel_Packs_metadata() throws InterruptedException {
	purchasetravelpacks.travelPacksOptions();
	}

	@Then("User should be able to Add Travel Pack to cart")
	public void User_should_able_to_add_travel_pack_to_cart() throws InterruptedException {
		purchasetravelpacks.addToCart();
	}

	@Then("Verify Travel Pack Eligibility for Refund")
	public void Verify_Travel_Pack_Eligibility_for_Refund() throws InterruptedException {
		bashboard.walletSection();
		purchasetravelpacks.travelPackEligibility();
	}
	
	@Then("User navigates to TravelPacks and taken to Checkout screen")
	public void User_navigates_to_TravelPacks_and_taken_to_Checkout_screen() throws InterruptedException {
		purchasetravelpacks.addToCart();
		purchasetravelpacks.viewCartToCheckout();
	}

	@Then("User should be able to buy the Packs")
	public void user_should_be_able_to_buy_the_Packs() throws InterruptedException {
		purchasetravelpacks.addToCart();
		purchasetravelpacks.viewCartToCheckout();
		ticket_booking.chekOutPage("WithSavedCards");
	}
	
	@Then("Guest user buys pass and checkes error message")
	public void guest_user_buys_pass_and_pack() throws InterruptedException {
		purchasetrainpass.premiumTrainPassToCheckout();
		purchasetravelpacks.yourCart();
	}

	@Then("Guest user buys packs and checkes error message")
	public void error_should_pop_up_saying_only_login_user_can_buy_pass() throws InterruptedException {
		purchasetravelpacks.addToCart();
		purchasetravelpacks.yourCart();
	}
	
	@Then("Verify Refund in BL wallet credit")
	public void verify_Refund_in_BL_wallet_credit() throws InterruptedException {
		bashboard.travelPacksRefundAsCredit();
		bashboard.walletSectionCreditValueRecheck();
	}
	
	@Then("User should be able to View the Purchase history of the Packs")
	public void user_should_be_able_to_View_the_Purchase_history_of_the_Packs() throws InterruptedException {
		bashboard.walletSection();
		bashboard.travelPackHistoryPage();
	}
	
	@Then("In checkout page purchased Pack should be applied and booking should be successful")
	public void in_checkout_page_purchased_Pack_should_be_applied_and_booking_should_be_successful() throws InterruptedException {
		mobilityride.oneWayTripWithWallet();
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("PassesBrightlineWallet");
	}
	
	@Then("User should be able to buy the Packs and Books a Trip")
	public void user_should_be_able_to_buy_the_Packs_and_Books_a_Trip() throws InterruptedException {
		user_should_be_able_to_buy_the_Packs();
		bashboard.oneWayPassesCount();
		mobilityride.oneWayTripWithWallet();
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("PassesBrightlineWallet");
	}

	@Then("User cancels the trip and amount should get Refund and the packs count should get increased")
	public void user_cancels_the_trip_and_amount_should_get_Refund_and_the_packs_count_should_get_increased() throws InterruptedException {
		bashboard.verifyRefundOnCancellingTrip();
		bashboard.oneWayPassesCountAfterCancelTrip();
	}

}
