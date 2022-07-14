package com.brightline.qa.stepDefinitions;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.ExtrasPage;
import com.brightline.qa.pages.MobilityRide;
import com.brightline.qa.pages.TrainTicketsBookingPage;

import cucumber.api.java.en.Then;

public class Extra_Pages extends BaseClass {

	TrainTicketsBookingPage ticket_booking = new TrainTicketsBookingPage();
	ExtrasPage extrapage = new ExtrasPage();
	MobilityRide mobilityride = new MobilityRide();

	@Then("I verify Add Extras metadata")
	public void I_verify_Add_Extras_metadata() throws InterruptedException {
		mobilityride.trainTicketBooking("June","1");
		//ticket_booking.ticketPriceSelection();
		extrapage.addExtrasSectionValidation();

	}

	@Then("User should able to add the Garage parking as Extras to the ticket")
	public void User_should_able_to_add_the_Garage_parking_as_Extras_to_the_ticket() throws InterruptedException {
		mobilityride.trainTicketBooking("June","1");
		//ticket_booking.ticketPriceSelection();
		extrapage.parkingAddSection();

	}

	@Then("User should able to add Pet details as Extras to the ticket")
	public void User_should_able_to_add_Pet_details_as_extras_to_the_ticket() throws InterruptedException {
		mobilityride.trainTicketBooking("June","1");
		//ticket_booking.ticketPriceSelection();
		extrapage.petsAddSection();
		
	}
	
	@Then("User should able to add Sports Equipment details as extras to the ticket")
	public void User_should_able_to_add_Sports_Equipment_details_as_extras_to_the_ticket() throws InterruptedException {
		mobilityride.trainTicketBooking("June","1");
		//ticket_booking.ticketPriceSelection();
		extrapage.petsAddSection();

	}
}
