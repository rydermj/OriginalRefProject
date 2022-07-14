package com.brightline.qa.stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.pages.HomePage;
import com.brightline.qa.pages.LoginPage;
import com.brightline.qa.pages.PurchaseTrainPass;
import com.brightline.qa.pages.PurchaseTravelPacks;
import com.brightline.qa.pages.TrainTicketsBookingPage;
import com.brightline.qa.util.ExcelReader;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_Page extends BaseClass {

	HomePage homepage = new HomePage();
	LoginPage loginpage = new LoginPage();
	PurchaseTravelPacks purchasetravelpacks = new PurchaseTravelPacks();
	PurchaseTrainPass purchasetrainpass = new PurchaseTrainPass();
	ExcelReader reader = new ExcelReader();
	TrainTicketsBookingPage ticket_booking = new TrainTicketsBookingPage();
	
	

	@When("I login with valid provider {string} and rownumber {int}")
	public void i_log_in_with_valid_provider_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber)
			throws InterruptedException, InvalidFormatException, IOException {
		List<Map<String, String>>testdata=homepage.testData(sheetName);
		String email = testdata.get(rowNumber).get("Email");
		String password = testdata.get(rowNumber).get("Password");

		loginpage.authentication(email, password);
	}

	@Then("I verify Sign Out button then verify Sign Out")
	public void I_click_on_Sign_Out_button_then_verify_Sign_Out() throws InterruptedException {
		loginpage.logout();
	}
	

	@Then("User clicks on Forgot Password link {string} and rownumber {int}")
	public void User_clicks_on_Forgot_Password_link(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		List<Map<String, String>>testdata=homepage.testData(sheetName);
		String email = testdata.get(rowNumber).get("Email");
     loginpage.forgotPasswordClick(email);
	}
	
	@Then("Forgot Password screen should open")
	public void Forgot_Password_screen_should_open() throws InterruptedException {
		loginpage.forgotPasswordVerification();
	}

	@Then("Sign up as a new user and verify success message {string} and rownumber {int}")
	public void Sign_up_as_a_new_user_and_Sign_up_with_Minor_Account(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		List<Map<String, String>>testdata=homepage.testData(sheetName);
		String firstname = testdata.get(rowNumber).get("firstname");
		String lastname = testdata.get(rowNumber).get("lastname");
		String dob = testdata.get(rowNumber).get("dob");
		String mobile = testdata.get(rowNumber).get("mobile");
		String email = testdata.get(rowNumber).get("email");
		String password = testdata.get(rowNumber).get("password");

		loginpage.signUpAsNewUser(firstname,lastname,dob,mobile,email,password);

	}
	
	@Then("Sign up as a Minor user and verify success message {string} and rownumber {int}")
	public void User_should_be_able_to_sign_up(String sheetNam, Integer rowNumbe) throws InterruptedException, InvalidFormatException, IOException {
		List<Map<String, String>>testdata=homepage.testData(sheetNam);
		String firstname = testdata.get(rowNumbe).get("firstname");
		String lastname = testdata.get(rowNumbe).get("lastname");
		String dob = testdata.get(rowNumbe).get("dob");
		String mobile = testdata.get(rowNumbe).get("mobile");
		String email = testdata.get(rowNumbe).get("email");
		String password = testdata.get(rowNumbe).get("password");
		
		loginpage.signUpAsMinor(firstname,lastname,dob,mobile,email,password);
	}
	
	@When("For Passes User should not be able to buy duplicate passes")
	public void for_Passes_User_should_not_be_able_to_buy_duplicate_passes() throws InterruptedException {
		purchasetrainpass.trainPassToCheckout();
		purchasetrainpass.trainPassTwicePurchase();
	}

	@Then("For Packs User should be able to buy duplicate Packs")
	public void for_Packs_User_should_be_able_to_buy_duplicate_Packs() throws InterruptedException {
		purchasetravelpacks.addToCart();
		purchasetravelpacks.addToCart();
		purchasetravelpacks.viewCartToCheckoutPasses();
		ticket_booking.removePassFromCart();
		
	}
	
	@Then("I Verify Login With Invalid Credentials {string} and rownumber {int}")
	public void i_Verify_Invalid_Credentials_Data_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>>testdata=homepage.testData(sheetName);
		String email = testdata.get(rowNumber).get("Email");
		String password = testdata.get(rowNumber).get("Password");
		loginpage.invalidCredentials(email, password);
	}
	
	@Then("I Verify whether user can update New password same as previous one")
	public void i_Verify_whether_user_can_update_New_password_same_as_previous_one() throws InterruptedException {
		loginpage.forgotPasswordValidation();
	}
	
	@Then("I Verify whether user can login with updated password {string} and rownumber {int}")
	public void i_Verify_whether_user_can_login_with_updated_password(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		List<Map<String, String>>testdata=homepage.testData(sheetName);
		String email = testdata.get(rowNumber).get("Email");
		String yupmail = testdata.get(rowNumber).get("Password");
		loginpage.loginAfterPasswordChange(email,yupmail);
	}
}
