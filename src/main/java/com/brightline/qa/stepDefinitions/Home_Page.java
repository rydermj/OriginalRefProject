package com.brightline.qa.stepDefinitions;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Home_Page extends BaseClass {

	HomePage homepage = new HomePage();

	@Given("^I am on the BL home page$")
	public void i_am_on_the_BL_home_page() throws InterruptedException {

		homepage.homePageValidation();

	}

	@Then("I verify search widget has 3 tabs")
	public void I_verify_search_widget_has_3_tabs() throws InterruptedException {

		homepage.homePageSearchWidget();
	}

}
