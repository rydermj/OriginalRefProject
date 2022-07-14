package com.brightline.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.brightline.qa.stepDefinitions.Hooks;

public class AccountSection extends Hooks {

	@FindBy(xpath = "//span[@class='bl-account__profile']")
	WebElement usericon;

	@FindBy(xpath = "//button[contains(text(),'My Account')]")
	WebElement my_account_btn;

	@FindBy(xpath = "//a[text()='Manage cards']")
	WebElement manage_cards_link;

	@FindBy(xpath = "//button[text()='ADD CARD']")
	WebElement add_cart_btn;

	@FindBy(xpath = "//input[@id='card-number']")
	WebElement card_number_text;
	
	@FindBy(xpath = "//input[@name='Button']")
	WebElement country_code;
	
	@FindBy(id = "phoneNumber")
	WebElement ph_nbr;
	
	@FindBy(id = "email")
	WebElement email_textbox;

	@FindBy(xpath = "//input[@id='holder-name']")
	WebElement card_name_text;
	
	@FindBy(xpath = "//input[@id='exp-date']")
	WebElement exp_date_btn;
	
	@FindBy(xpath = "//input[@id='cvv']")
	WebElement cvv_btn;
	
	@FindBy(xpath = "//button[text()='Add']")
	WebElement add_btn;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement success_msg;

	@FindBy(xpath = "(//button[text()='Add traveler'])")
	WebElement add_travler_btn;
	
	@FindBy(xpath = "(//div[text()='ADD'])")
	WebElement search_btn;
	
	@FindBy(xpath = "(//div[text()='Save changes'])")
	WebElement save_changes_btn;

	@FindBy(id = "firstName")
	WebElement firstname;

	@FindBy(id = "lastName")
	WebElement lastname;
	
	@FindBy(id = "dob")
	WebElement dob_textfield;
	
	@FindBy(xpath = "//a[text()='Manage Profile']")
	WebElement manage_profile_link;
	
	@FindBy(xpath = "(//*[@class='bl-input__helper-text text-left bl-input__helper-text--error'])[1]")
	WebElement firstname_errormsg;
	
	@FindBy(xpath = "(//*[@class='bl-input__helper-text text-left bl-input__helper-text--error'])[2]")
	WebElement lastname_errormsg;
	
	@FindBy(xpath = "(//*[@class='bl-input__helper-text text-left bl-input__helper-text--error'])[3]")
	WebElement dob_errormsg;
	
	@FindBy(xpath = "//button[@class='h-8 w-8 bg-close-icon bg-right bg-no-repeat absolute top-2 right-4 lg:float-right lg:static']")
	WebElement addtraveller_closebtn;
	
	@FindBy(xpath = "(//div[@class='col-span-5 mt-12 lg:mt-0 lg:col-span-2'])[1]")
	WebElement wallet_section;
	
	@FindBy(xpath = "//a[text()='View all']")
	WebElement viewall_link;
	
	@FindBy(xpath = "//button[@class='h-8 w-8 bg-del-icon bg-center p-2 bg-no-repeat float-right']")
	WebElement delete_icon;
	
	@FindBy(xpath = "//div[text()='YES']")
	WebElement delete_yesbtn;
	
	@FindBy(xpath = "(//*[@alt='delete'])[3]")
	WebElement card_delete;
	
	@FindBy(xpath = "(//*[text()='Proceed'])")
	WebElement proceed_btn;
	
	
	WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 20);
	
	public AccountSection() {

		PageFactory.initElements(Hooks.getDriver(), this);

	}

	public void accountWalletSection() throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		delay(3);
		my_account_btn.click();
		delay(3);
		manage_cards_link.click();
		delay(3);
		add_cart_btn.click();
		
	}
	
	public void addCard(String cardnumber, String cardname, String expdate, String cvv) throws InterruptedException {
		delay(3);
		Actions Act = new Actions(Hooks.getDriver());
		Act.moveToElement(card_number_text).build().perform();
		card_number_text.sendKeys(cardnumber);
		card_name_text.sendKeys(cardname);
		exp_date_btn.sendKeys(expdate);
		cvv_btn.sendKeys(cvv);
		add_btn.click();
		WebElement
		expected1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		String text_successmsg = success_msg.getText();
		String expected = prop.getProperty("new_card_success_message");
		Assert.assertEquals(text_successmsg, expected);
	}
	
	public void deletAddedCard() throws InterruptedException {
        card_delete.click();
        proceed_btn.click();
		WebElement
		expected1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		expected1.click();
	}
	
	public void accountAddTraveler() throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		delay(3);
		my_account_btn.click();
		delay(3);
		add_travler_btn.click();
		Actions Act = new Actions(Hooks.getDriver());
		Act.moveToElement(country_code).build().perform();
		delay(3);
		country_code.isDisplayed();
		ph_nbr.isDisplayed();
		email_textbox.isDisplayed();
		search_btn.isDisplayed();
		delay(6); //Application takes time to load
	}
	
	
	public void accountManageProfile(String frstname,String lstname,String phnumber) throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		delay(2);
		my_account_btn.click();
		manage_profile_link.click();
		delay(2);
		firstname.clear();
		delay(2);
		SoftAssert sft = new SoftAssert();
		sft.assertFalse(email_textbox.isEnabled());
		sft.assertFalse(dob_textfield.isEnabled());
		firstname.sendKeys(frstname);
		ph_nbr.clear();
		ph_nbr.sendKeys(phnumber);
		delay(2);
		save_changes_btn.click();
		delay(3);
		String text_successmsg = success_msg.getText();
		String expected = prop.getProperty("update_profile_success_message");
		Assert.assertEquals(text_successmsg, expected);
		sft.assertAll();
	}

	public void accountAddCoPassenger(String frstname,String lstname,String dob) throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		delay(2);
		my_account_btn.click();
		WebElement
		add_travler_button =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add traveler']")));
		add_travler_button.click();
		hover.moveToElement(country_code).build().perform();
		delay(3);
		firstname.sendKeys(frstname);
		lastname.sendKeys(lstname);
		dob_textfield.sendKeys(dob);
		search_btn.click();
		try {
		WebElement
	    success_msg =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		String text_successmsg = success_msg.getText().substring(45);;
		String expected = prop.getProperty("add_traveller_success_message");
		Assert.assertEquals(text_successmsg, expected);
		success_msg.click();
		}
		catch(Exception e) {
			String text_successmsg = firstname_errormsg.getText();
			String expected = prop.getProperty("fistname_errormsg");
			Assert.assertEquals(text_successmsg, expected);
			String text_successmsg1 = lastname_errormsg.getText();
			String expected1 = prop.getProperty("fistname_errormsg");
			Assert.assertEquals(text_successmsg1, expected1);
			String text_successmsg2 = dob_errormsg.getText();
			String expected2 = prop.getProperty("dob_errormsg");
			Assert.assertEquals(text_successmsg2, expected2);
		}
	}
	
	public void accountAddCoPassengerCancelbtn() throws InterruptedException {
		addtraveller_closebtn.isDisplayed();
		addtraveller_closebtn.click();
		wallet_section.isDisplayed();
		}
	
	public void accountAddCoPassengerWithoutFirstNameLastName() throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		delay(2);
		my_account_btn.click();
		WebElement
		add_travler_button =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add traveler']")));
		add_travler_button.click();
		search_btn.click();
		String text_successmsg = firstname_errormsg.getText();
		String expected = prop.getProperty("fn_errormsg");
		Assert.assertEquals(text_successmsg, expected);
		String text_successmsg1 = lastname_errormsg.getText();
		String expected1 = prop.getProperty("fn_errormsg");
		Assert.assertEquals(text_successmsg1, expected1);
		}
	
	
	public void viewAndDeleteTraveler() throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		delay(2);
		my_account_btn.click();
		WebElement
	    view_link =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='View all']")));
		view_link.click();
		delete_icon.isDisplayed();
		delete_icon.click();
		delete_yesbtn.click();
		String text_successmsg = success_msg.getText();
		String expected = prop.getProperty("delete_traveler_msg");
		Assert.assertEquals(text_successmsg, expected);
		success_msg.click();
	}
}
