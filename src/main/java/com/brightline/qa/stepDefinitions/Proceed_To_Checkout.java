package com.brightline.qa.stepDefinitions;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.AccountDashboard;
import com.brightline.qa.pages.ExtrasPage;
import com.brightline.qa.pages.MobilityRide;
import com.brightline.qa.pages.PurchaseTrainPass;
import com.brightline.qa.pages.PurchaseTravelPacks;
import com.brightline.qa.pages.TrainTicketsBookingPage;

import cucumber.api.java.en.Then;

public class Proceed_To_Checkout extends BaseClass{
	
	PurchaseTravelPacks purchasetravelpacks = new PurchaseTravelPacks();
	TrainTicketsBookingPage ticket_booking = new TrainTicketsBookingPage();
	PurchaseTrainPass purchasetrainpass = new PurchaseTrainPass();
	AccountDashboard bashboard = new AccountDashboard();
	MobilityRide mobilityride = new MobilityRide();
	ExtrasPage extrapage = new ExtrasPage();
	
	@Then("User should be taken to Checkout screen")
	public void User_should_be_taken_to_Checkout_screen() throws InterruptedException {

		purchasetravelpacks.addToCart();
		purchasetravelpacks.viewCartToCheckout();

	}
	
	@Then("Cancel the booking which was paid through credits")
	public void cancel_the_booking_which_was_paid_through_credits() throws InterruptedException {
		bashboard.walletSectionCreditValue();
		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("WalletTicketCheckoutPage");
	}

	@Then("Credits should be refunded back")
	public void credits_should_be_refunded_back() throws InterruptedException {
		bashboard.ticketValueRefund();
		bashboard.walletSectionCreditValueRecheck();
	}
	
	@Then("User should be able to edit credits and the credits edited should be applied properly")
	public void user_should_be_able_to_edit_credits_and_the_credits_edited_should_be_applied_properly() throws InterruptedException {
		mobilityride.oneWayTrip(getMonth(),getDay());
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("TicketCheckoutPageWithCreditsApply");
	}

}
