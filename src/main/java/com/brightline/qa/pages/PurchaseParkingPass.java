package com.brightline.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.brightline.qa.stepDefinitions.Hooks;

public class PurchaseParkingPass extends Hooks {

	@FindBy(className = "bl-menu__title")
	WebElement tickets_travel;

	@FindBy(xpath = "//a[text()='Parking Passes']")
	WebElement parking_passes;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement garage_dropdown;
	
	@FindBy(xpath = "//span[text()='Fort Lauderdale ']")
	WebElement garage_value;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement license_plate;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement state_dropdown;
	
	@FindBy(xpath = "//span[text()='Florida']")
	WebElement state_value;

	@FindBy(xpath = "//button[@id='headlessui-switch-17']")
	WebElement toogle_button;
	
	@FindBy(xpath = "(//a[text()='Purchase now'])[2]")
	WebElement purchase_now_link;
	
	@FindBy(xpath = "(//button[@class='mt-2'])[3]")
	WebElement parking_pass_rightarrow;
	
	@FindBy(xpath = "//div[text()='Active untilll']")
	WebElement active_untill_text;
	
	@FindBy(xpath = "//button[text()='Refund']")
	WebElement refund_text;
	
	@FindBy(xpath = "//div[contains(text(),'Add to')]")
	WebElement add_btn;
	
	@FindBy(xpath = "//div[text()='Enter License Plate Number']")
	WebElement error_msg;
	
	@FindBy(xpath = "//button[@role='switch']")
	WebElement auto_renewal;

	
	public PurchaseParkingPass() {

		PageFactory.initElements(Hooks.getDriver(), this);

	}

	public void parkingPass() throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		parking_passes.click();
		delay(4);
		garage_dropdown.isDisplayed();
		license_plate.isDisplayed();
		state_dropdown.isDisplayed();
		toogle_button.isDisplayed();

	}
	
	public void parkingPassWithoutLicensePlate() throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		parking_passes.click();
		delay(3);
		license_plate.isDisplayed();
		delay(1);
		add_btn.click();
		String actual_message = error_msg.getText();
		String expected_message = prop.getProperty("license_plate");
		Assert.assertEquals(actual_message, expected_message);
	}
	
	public void purchaseParkingPassWithAuto() throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		delay(4);
		parking_passes.click();
		delay(2);
		garage_dropdown.click();
		garage_value.click();
		state_dropdown.click();
		state_value.click();
		license_plate.sendKeys("12345");
		auto_renewal.click();
		add_btn.click();
		String on_value = auto_renewal.getAttribute("aria-checked");
		Assert.assertEquals("true", on_value); 
	}
	
	public void parkingPageFromWalletSection() throws InterruptedException {
		delay(5);
		purchase_now_link.click();
		delay(5);
	}
	
	public void parkingPassEligibility () throws InterruptedException {
		parking_pass_rightarrow.click();
		
		SoftAssert sftassert = new SoftAssert();
		
		String a=String.valueOf(active_untill_text.isDisplayed());
		//boolean test = active_untill_text.isDisplayed();
		delay(5);
	
		//sftassert.assertFalse(active_untill_text.isDisplayed());
		sftassert.assertEquals(a,"true");
		
		refund_text.isDisplayed();
		System.out.println("hello" );
		sftassert.assertAll();

	}
}
