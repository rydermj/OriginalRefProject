package com.brightline.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.brightline.qa.stepDefinitions.Hooks;

public class AccountDashboard extends Hooks {

	@FindBy(xpath = "//span[@class='bl-account__profile']")
	WebElement usericon;

	@FindBy(xpath = "//button[contains(text(),'My Account')]")
	WebElement my_account_btn;

	@FindBy(xpath = "(//div[@class='flex items-center'])[6]")
	WebElement one_way_rides;
	
	@FindBy(xpath = "//div[text()='CREDITS']//preceding::div[1]")
	WebElement credits_value;
	
	@FindBy(xpath = "(//div[@class='flex items-center'])[2]")
	WebElement onewayrides_value;

	@FindBy(xpath = "(//div[@class='col-span-5 mt-12 lg:mt-0 lg:col-span-2'])[1]")
	WebElement wallet_section;
	
	@FindBy(xpath = "//button[text()='Manage Trips']")
	WebElement managetrip_text;
	
	@FindBy(xpath = "//a[text()='View Tickets']")
	WebElement viewticket_text;
	
	@FindBy(xpath = "//a[text()='Cancel Trip']")
	WebElement cancel_link;
	
	@FindBy(xpath = "(//button[contains(@class,'h-12')])[2]")
	WebElement yes_button;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement success_msg;
	
	@FindBy(xpath = "(//button[@class='mt-2'])[2]")
	WebElement oneway_refundpage;
	
	@FindBy(xpath = "(//button[@class='mt-2'])[3]")
	WebElement parking_pass_refund;
	
	@FindBy(xpath = "(//button[@class='mt-2'])[1]")
	WebElement trainpass_refundpage;
	
	@FindBy(xpath = "(//button[text()='Refund'])[1]")
	WebElement refund_btn;
	
	@FindBy(xpath = "(//img[@class='transform false'])[1]")
	WebElement dropdown;
	
	@FindBy(xpath = "(//div[text()='PREMIUM'])[1]")
	WebElement premium_value;
	
	@FindBy(xpath = "(//div[text()='SMART'])[1]")
	WebElement smart_value;
	
	@FindBy(xpath = "(//div[text()='Active until'])[1]")
	WebElement activeuntill_text;
	
	@FindBy(xpath = "//a[text()='All trips']")
	WebElement alltrips_link;
	
	@FindBy(xpath = "(//button[@class='mt-2'])[4]")
	WebElement credits_page;
	
	@FindBy(xpath = "(//div[@class='flex flex-col bl-gray-md lg:py-9 lg:px-4 lg:border-b bg-white font-medium text-bl-black'])[3]")
	WebElement passenger_refund_value;
	

	WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 30);
	WebElement canceltrip;
	WebElement cancelsuccessmsg;
	
	String BeforeRefund;
	String RidesBeforeRefund;

	public AccountDashboard() {

		PageFactory.initElements(Hooks.getDriver(), this);

	}

	public void ticketValueRefund() throws InterruptedException {
		managetrip_text.click();
		cancel_link.click();
		yes_button.click();
		String text_successmsg = success_msg.getText();
		String expected = prop.getProperty("trip_cancel_success_message");
		Assert.assertEquals(text_successmsg, expected);
	}
	
	public void walletSection() throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		delay(3);
		my_account_btn.click();
		delay(1);
		wallet_section.isDisplayed();
	}

	public void walletSectionOneWayRides() throws InterruptedException {
		one_way_rides.isDisplayed();
	}
	
	public void walletSectionCreditValue() throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		delay(3);
		my_account_btn.click();
		delay(1);
		BeforeRefund = credits_value.getText();
		System.out.println("before refund added " + BeforeRefund);
		delay(1);
	}
	
    public void travelPacksRefundAsCredit() throws InterruptedException {
		walletSectionCreditValue();
		delay(2);
		oneway_refundpage.click();
		delay(2);
		refund_btn.click();
		yes_button.click();
		delay(2);
		String text_successmsg = success_msg.getText();
		String expected = prop.getProperty("return_refund_success_message");
		Assert.assertEquals(text_successmsg, expected);
	}
	
	public void walletSectionCreditValueRecheck() throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		delay(3);
		my_account_btn.click();
		delay(1);
		String AfterRefund = credits_value.getAttribute("innerText");
		System.out.println("After refund value " + AfterRefund);
		Assert.assertNotSame(BeforeRefund,AfterRefund);
	}
	
	public void trainPasssesHistoryPage() throws InterruptedException {
		trainpass_refundpage.click();
		historyPageValidation();
	}
	
	public void historyPageValidation() throws InterruptedException {
		dropdown.click();
		activeuntill_text.isDisplayed();
		try {
			premium_value.isDisplayed();
		}
		catch(Exception e) {
			smart_value.isDisplayed();
		}	
	}
	
	public void travelPackHistoryPage() throws InterruptedException {
		oneway_refundpage.click();
		historyPageValidation();
	}
	
	public void verifyRefundOnCancellingTrip() throws InterruptedException {
		walletSection();
		alltrips_link.click();
		try {
		canceltrip =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Cancel Trip']")));
		cancel_link.click();
		yes_button.click();
		cancelsuccessmsg =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		String text_successmsg = success_msg.getText();
		String expected = prop.getProperty("trip_cancel_success_message");
		Assert.assertEquals(text_successmsg, expected);
		success_msg.click();}
		catch(Exception e) {
			
		}
	}
	
	public void verifyRefundValueOnCancellingPassenger() throws InterruptedException {
		walletSection();
		credits_page.click();
		String text_successmsg = passenger_refund_value.getText();
		String expected = prop.getProperty("refund_cancel_passenger_value");
		System.out.println("value "+ text_successmsg);
		Assert.assertNotSame(text_successmsg, expected);
	}
	
	public void oneWayPassesCount() throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		delay(3);
		my_account_btn.click();
		RidesBeforeRefund = onewayrides_value.getAttribute("innerText");
		System.out.println("Before refund value " + RidesBeforeRefund);
	}
	
	public void parkingPassCancel() throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		my_account_btn.click();
		parking_pass_refund.click();
		refund_btn.click();
		yes_button.click();
		delay(2);
		String text_successmsg = success_msg.getText();
		String expected = prop.getProperty("return_refund_success_message");
		Assert.assertEquals(text_successmsg, expected);
		
	}
	
	public void oneWayPassesCountAfterCancelTrip() throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		delay(3);
		my_account_btn.click();
		delay(3);
		String RidesAfterRefund = onewayrides_value.getAttribute("innerText");
		System.out.println("After refund value " + RidesAfterRefund);
		Assert.assertNotSame(RidesBeforeRefund,RidesAfterRefund);
	}
}
