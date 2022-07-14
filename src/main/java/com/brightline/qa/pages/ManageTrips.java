package com.brightline.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.brightline.qa.stepDefinitions.Hooks;

public class ManageTrips extends Hooks {
	@FindBy(className = "bl-menu__title")
	WebElement tickets_travel;

	@FindBy(xpath = "//a[text()='Manage Trips']")
	WebElement managetrip;

	@FindBy(xpath = "//button[text()='Manage Trips']")
	WebElement managetrip_button;

	@FindBy(id = "bookingReference")
	WebElement ticket_txtfield;

	@FindBy(id = "lastName")
	WebElement lastname_text;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement firstname_text;
	
	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement adultfirstname_text;
	
	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement dob_text;
	
	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement adultlastname_text;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement lstname_text;
	
	@FindBy(xpath = "(//input[@type='email'])")
	WebElement email_text;
	
	@FindBy(xpath = "(//input[@type='tel'])")
	WebElement mobile_text;

	@FindBy(xpath = "//button[text()='Search']")
	WebElement search_button;

	@FindBy(xpath = "//a[text()='Edit Trip']")
	WebElement edit_trip;
	
	@FindBy(xpath = "//a[text()='Cancel Trip']")
	WebElement cancel_trip;

	@FindBy(xpath = "(//button[@type='button'])[6]")
	WebElement change_trip;
	
	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement change_name;
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement add_passenger;
	
	@FindBy(xpath = "(//button[@type='button'])[7]")
	WebElement change_seats;
	
	@FindBy(xpath = "(//button[@type='button'])[4]")
	WebElement cancel_passenger;
	
	@FindBy(xpath = "//button[@aria-label='Add Adults']")
	WebElement add_adult;

	@FindBy(xpath = "(//div[@class='vs__selected-options'])[2]")
	WebElement to_field;

	@FindBy(xpath = "//div[@aria-label='West Palm Beach']")
	WebElement to_value;

	@FindBy(xpath = "//button[@class='button normal']")
	WebElement searchtrains_button;

	@FindBy(xpath = "(//div[@class='price'])[3]")
	WebElement departure_price;
	
	@FindBy(xpath = "(//div[@class='price'])[6]")
	WebElement departure_price1;

	@FindBy(xpath = "(//button[@class='summary-button button-right'])")
	WebElement confirm_button;

	@FindBy(xpath = "(//button[@class='summary-button button-right'])[2]")
	WebElement confirm1_button;

	@FindBy(xpath = "//button[text()='YES']")
	WebElement yes_btn;
	
	@FindBy(xpath = "(//img[@alt='down_arrow'])[1]")
	WebElement dropdown;

	@FindBy(xpath = "(//span[@class='text-16 leading-5 text-bl-gray undefined'])[1]")
	WebElement useremail_text;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement success_msg;
	
	@FindBy(xpath = "(//div[@class='rail-car-name'])[2]")
	WebElement select_coach;
	
	@FindBy(xpath = "(//*[@id='Components-/-Seating-/-Part-/-Seat-available'])[12]")
	WebElement select_seat;
	
	@FindBy(id = "navigation-hub-next")
	WebElement payment_button;
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement depature_field;

	@FindBy(xpath = "(//span[text()='2'])[2]")
	WebElement depature_value;
	
	@FindBy(xpath = "//button[text()='Apply']")
	WebElement depature_done_button;
	
	@FindBy(xpath = "(//span[@class='checkbox-button__control'])[3]")
	WebElement cancel_passenger_checkbox;
	
	@FindBy(xpath = "//button[@class='summary-button button-right']")
	WebElement savechanges_button;

	@FindBy(className = "left")
	WebElement month_dropdown;
	
	@FindBy(className = "middle")
	WebElement date_dropdown;
	
	@FindBy(className = "right")
	WebElement year_dropdown;

	WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 60);
	WebElement paymentbutton;
	WebElement addtotripbtn;
	WebElement savechanges;

	public ManageTrips() {

		PageFactory.initElements(Hooks.getDriver(), this);

	}

	public void manageTrip() throws InterruptedException {
		delay(2);
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		managetrip.click();

	}

	public void manageTripPage() throws InterruptedException {
		ticket_txtfield.isDisplayed();
		lastname_text.isDisplayed();
		search_button.isDisplayed();
	}

	public void manageTripSearch() throws InterruptedException {
		ticket_txtfield.sendKeys();
		delay(40);
		lastname_text.sendKeys("kanth");
		search_button.click();
		dropdown.click();
		String actual_message = useremail_text.getText();
		String expected_message = prop.getProperty("manage_trip_email_search");
		Assert.assertEquals(actual_message, expected_message);

	}

	public void editTripGuestUser() throws InterruptedException {
		managetrip_button.click();
		delay(5);
		edit_trip.click();
		delay(4);
		Hooks.getDriver().switchTo().frame(0);
		change_trip.click();
		Hooks.getDriver().switchTo().defaultContent();
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		to_field.click();
		to_value.click();
		searchtrains_button.click();
		delay(4);
		departure_price.click();
		delay(2);
		confirm_button.click();
		delay(40);
		confirm_button.click();
		delay(2);
		confirm1_button.click();
	}

	public void guestUserCancelTrip() throws InterruptedException {
		managetrip_button.click();
		delay(5);
		cancel_trip.click();
		yes_btn.click();
		String successmsg = success_msg.getText();
		String expected = prop.getProperty("trip_cancel_success_message");
		Assert.assertEquals(successmsg, expected);
	}
	
	public void editTripAddPassenger() throws InterruptedException {
		managetrip_button.click();
		delay(5);
		edit_trip.click();
		delay(4);
		Hooks.getDriver().switchTo().frame(0);
		add_passenger.click();
		Hooks.getDriver().switchTo().defaultContent();
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		add_adult.click();
		firstname_text.sendKeys("first name");
		lstname_text.sendKeys("last name");
		Select monthdropdown = new Select(month_dropdown);
		monthdropdown.selectByValue("06");
		Select datedropdown = new Select(date_dropdown);
		datedropdown.selectByValue("06");
		Select yeardropdown = new Select(year_dropdown);
		yeardropdown.selectByValue("1988");
		delay(2);
		confirm_button.click();
		paymentbutton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='navigation-hub-notification success']")));
		payment_button.click();
		delay(2);
		confirm1_button.click();
		Hooks.getDriver().switchTo().defaultContent();
	}
	
	public void editTripChangeDate() throws InterruptedException {
		managetrip_button.click();
		delay(5);
		edit_trip.click();
		delay(4);
		Hooks.getDriver().switchTo().frame(0);
		change_trip.click();
		Hooks.getDriver().switchTo().defaultContent();
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		depature_field.click();
		delay(2);
		depature_value.click();
		delay(2);
		depature_done_button.click();
		delay(2);
		searchtrains_button.click();
		delay(4);
		departure_price.click();
		delay(2);
		confirm_button.click();
		paymentbutton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='navigation-hub-notification success']")));
		payment_button.click();
		delay(2);
		confirm1_button.click();
		Hooks.getDriver().switchTo().defaultContent();
	}
	
	public void editTripChangeTime() throws InterruptedException {
		managetrip_button.click();
		delay(5);
		edit_trip.click();
		delay(4);
		Hooks.getDriver().switchTo().frame(0);
		change_trip.click();
		Hooks.getDriver().switchTo().defaultContent();
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		depature_field.click();
		delay(2);
		depature_value.click();
		delay(2);
		depature_done_button.click();
		delay(2);
		searchtrains_button.click();
		delay(4);
		departure_price1.click();
		delay(2);
		confirm_button.click();
		paymentbutton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='navigation-hub-notification success']")));
		payment_button.click();
		delay(2);
		confirm1_button.click();
		Hooks.getDriver().switchTo().defaultContent();
	}
	
	public void editTripChangeNameMultiUser() throws InterruptedException {
		managetrip_button.click();
		delay(5);
		edit_trip.click();
		delay(4);
		Hooks.getDriver().switchTo().frame(0);
		change_name.click();
		Hooks.getDriver().switchTo().defaultContent();
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		adultfirstname_text.clear();
		adultlastname_text.clear();
		adultfirstname_text.sendKeys("Updated Field");
		adultlastname_text.sendKeys("Updated last Field");
		delay(2);
		confirm_button.click();
		Hooks.getDriver().switchTo().defaultContent();
	}
	
	public void editTripCancelPassenger() throws InterruptedException {
		managetrip_button.click();
		delay(5);
		edit_trip.click();
		delay(4);
		Hooks.getDriver().switchTo().frame(0);
		cancel_passenger.click();
		Hooks.getDriver().switchTo().defaultContent();
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		cancel_passenger_checkbox.click();
		delay(2);
		confirm_button.click();
		savechanges =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='navigation-hub-notification success']")));
		savechanges_button.click();
		confirm1_button.click();
		Hooks.getDriver().switchTo().defaultContent();
	}
	
	public void editTripPassengerShouldNotEdit() throws InterruptedException {
		managetrip_button.click();
		delay(5);
		edit_trip.click();
		delay(5);
		Hooks.getDriver().switchTo().frame(0);
		change_name.click();
		Hooks.getDriver().switchTo().defaultContent();
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		SoftAssert sft = new SoftAssert();
		sft.assertFalse(firstname_text.isEnabled());
		sft.assertFalse(lstname_text.isEnabled());
		sft.assertFalse(email_text.isEnabled());
		sft.assertFalse(mobile_text.isEnabled());
	}
	
	public void editTripAfterChangingSeats() throws InterruptedException {
		managetrip_button.click();
		delay(5);
		edit_trip.click();
		delay(5);
		Hooks.getDriver().switchTo().frame(0);
		change_seats.click();
		Hooks.getDriver().switchTo().defaultContent();
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		delay(4);
		select_coach.click(); 
		Actions tickets_hover = new Actions(Hooks.getDriver());
	    tickets_hover.moveToElement(select_seat).doubleClick().build().perform();
		delay(2);
		confirm_button.click();
		savechanges =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='navigation-hub-notification success']")));
		savechanges_button.click();
		confirm1_button.click();
		Hooks.getDriver().switchTo().defaultContent();
	}
}

