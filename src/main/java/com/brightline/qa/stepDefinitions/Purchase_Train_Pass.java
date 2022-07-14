package com.brightline.qa.stepDefinitions;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.AccountDashboard;
import com.brightline.qa.pages.ExtrasPage;
import com.brightline.qa.pages.MobilityRide;
import com.brightline.qa.pages.PurchaseTrainPass;
import com.brightline.qa.pages.PurchaseTravelPacks;
import com.brightline.qa.pages.TrainTicketsBookingPage;

import cucumber.api.java.en.Then;

public class Purchase_Train_Pass extends BaseClass {

	PurchaseTrainPass purchasetrainpass = new PurchaseTrainPass();
	AccountDashboard bashboard = new AccountDashboard();
	PurchaseTravelPacks purchasetravelpacks = new PurchaseTravelPacks();
	MobilityRide mobilityride = new MobilityRide();
	ExtrasPage extrapage = new ExtrasPage();
	TrainTicketsBookingPage ticket_booking = new TrainTicketsBookingPage();

	@Then("User should be able to view the train passes page")
	public void User_should_be_able_to_view_the_train_passes_page() throws InterruptedException {
		purchasetrainpass.trainPassPage();
	}

	@Then("User should be able to enabledisable the auto renewal button")
	public void User_should_be_able_to_enabledisable_the_auto_renewal_button() throws InterruptedException {
		purchasetrainpass.autoRenewalFunctionality();
	}

	@Then("User should be able to see the toggle button")
	public void User_should_be_able_to_see_the_toggle_button() throws InterruptedException {
		purchasetrainpass.verifyToogleButton();
	}

	@Then("User navigates to train pass page from walletsection and checks AutoRenewal functionality")
	public void User_navigates_to_train_pass_page_from_walletsection_and_checks_AutoRenewal_functionality()
			throws InterruptedException {
		bashboard.walletSection();
		purchasetrainpass.trainPageFromWalletSection();
		purchasetrainpass.autoRenewalFunctionality();

	}

	@Then("Verify Train Pass Eligibility for Refund")
	public void Verify_Train_Pass_Eligibility_for_Refund() throws InterruptedException {
		bashboard.walletSection();
		purchasetrainpass.trainPassEligibility();
	}

	@Then("User navigates to Train Pass and taken to Checkout screen")
	public void User_navigates_to_TravelPacks_and_taken_to_Checkout_screen() throws InterruptedException {
		purchasetrainpass.trainPassToCheckout();
		purchasetravelpacks.viewCartToCheckout();
	}

	@Then("User books a Train Ticket with existing Train Pass from Wallet")
	public void user_books_a_Train_Ticket_with_existing_Train_Pass_from_Wallet() throws InterruptedException {
		mobilityride.oneWayTripWithWallet();
		mobilityride.oneWaySmartTicket();
		mobilityride.viewSeatsAndContinue();
		ticket_booking.guestCartContinueButton();
		ticket_booking.chekOutPage("PassesBrightlineWallet");
	}

	@Then("User should get error message while purchasing duplicate passes")
	public void user_should_get_error_message_while_purchasing_duplicate_passes() throws InterruptedException {
		purchasetrainpass.trainPassToCheckout();
		//Note Passes are already added to cart
		//purchasetravelpacks.viewCartToCheckout();
		//ticket_booking.chekOutPage("WithSavedCards");
		//purchasetrainpass.trainPassToCheckout();
		//purchasetrainpass.trainPassTwicePurchase();
	}

	@Then("User should be able to buy and Auto Renew the Passes")
	public void user_should_be_able_to_buy_the_Passes() throws InterruptedException {
		purchasetrainpass.trainPassWithAutoRenew();
		//Note Passes are already added to cart
		//purchasetravelpacks.viewCartToCheckout();
		//ticket_booking.chekOutPage("WithSavedCards");
	}

	@Then("User should be able to View the Purchase history of the Train Passes")
	public void user_should_be_able_to_View_the_Purchase_history_of_the_Train_Passes() throws InterruptedException {
		bashboard.walletSection();
		bashboard.trainPasssesHistoryPage();
		
	}

}
