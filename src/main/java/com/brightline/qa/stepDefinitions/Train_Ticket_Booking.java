package com.brightline.qa.stepDefinitions;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.MobilityRide;
import com.brightline.qa.pages.PurchaseTrainPass;
import com.brightline.qa.pages.PurchaseTravelPacks;
import com.brightline.qa.pages.TrainTicketsBookingPage;

import cucumber.api.java.en.Then;

public class Train_Ticket_Booking extends BaseClass {

	TrainTicketsBookingPage ticket_booking = new TrainTicketsBookingPage();
	PurchaseTravelPacks purchasetravelpacks = new PurchaseTravelPacks();
	PurchaseTrainPass purchasetrainpass = new PurchaseTrainPass();
	MobilityRide mobilityride = new MobilityRide();

	@Then("User searches for Trains")
	public void user_searches_for_Trains() throws InterruptedException {
		mobilityride.trainTicketBooking("June","1");
	}

	@Then("User completes booking a train")
	public void User_completes_booking_a_train() throws InterruptedException {
		//ticket_booking.ticketPriceSelection();
		ticket_booking.ticketBookingSummary();
		ticket_booking.chekOutPage("TicketCheckoutPage");
	}
	
	@Then("User adds TravelPacks and Verify Cart page metadata")
	public void User_adds_TravelPacks_and_Verify_Cart_page_metadata() throws InterruptedException {
		purchasetravelpacks.addToCart();
		purchasetravelpacks.yourCart();
	}

	@Then("User adds TrainPass and Verify Cart page metadata")
	public void User_adds_TrainPass_and_Verify_Cart_page_metadata() throws InterruptedException {
		purchasetrainpass.trainPassToCheckout();
		purchasetravelpacks.yourCart();
	}

}
