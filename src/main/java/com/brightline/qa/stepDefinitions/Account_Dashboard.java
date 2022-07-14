package com.brightline.qa.stepDefinitions;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.AccountDashboard;

import cucumber.api.java.en.Then;

public class Account_Dashboard extends BaseClass {

	AccountDashboard bashboard = new AccountDashboard();

	@Then("I should be able to see the Brightline Wallet section on the Account Dashboard")
	public void I_should_be_able_to_see_the_Brightline_Wallet_section_on_the_Account_Dashboard()
			throws InterruptedException {
		bashboard.walletSection();
	}

	@Then("I should be able to see a summary of My Active Packs and Passes")
	public void I_should_be_able_to_see_a_summary_of_My_Active_Packs_and_Passes() throws InterruptedException {
		bashboard.walletSection();
	}
	
	@Then("I verify credit refund on cancelling trip")
	public void i_verify_credit_refund_on_cancelling_trip() throws InterruptedException {
		bashboard.walletSectionCreditValue();
		bashboard.verifyRefundOnCancellingTrip();
		bashboard.walletSectionCreditValueRecheck();
	}

}
