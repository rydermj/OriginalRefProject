package com.brightline.qa.pages;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.brightline.qa.stepDefinitions.Hooks;

public class ExtrasPage extends Hooks {

	@FindBy(xpath = "//div[text()='Add Extras']")
	WebElement add_extra_text;

	@FindBy(xpath = "(//div[@class='w-full bg-white shadow-extrasCard'])[1]")
	WebElement shared_ride;

	@FindBy(xpath = "(//div[@class='w-full bg-white shadow-extrasCard'])[2]")
	WebElement private_ride;

	@FindBy(xpath = "(//div[@class='w-full bg-white shadow-extrasCard'])[3]")
	WebElement parking;

	@FindBy(xpath = "(//div[@class='w-full bg-white shadow-extrasCard'])[4]")
	WebElement pets;

	@FindBy(xpath = "(//div[@class='w-full bg-white shadow-extrasCard'])[5]")
	WebElement sports_equipment;

	@FindBy(xpath = "(//img[@class='w-11.5 h-auto'])[3]")
	WebElement parking_add_btn;

	@FindBy(xpath = "(//img[@class='w-11.5 h-auto'])[4]")
	WebElement pets_add_btn;

	@FindBy(xpath = "(//img[@class='w-11.5 h-auto'])[5]")
	WebElement sports_add_btn;

	@FindBy(xpath = "//div[contains(text(),'Private Ride')]//following::div[3]/button/img")
	WebElement private_ride_add_btn;

	@FindBy(xpath = "//div[contains(text(),'Shared Ride')]//following::div[3]/button/img")
	WebElement shared_ride_add_btn;

	@FindBy(xpath = "//img[@alt='checked']")
	WebElement parking_add_person_checkbox;

	@FindBy(xpath = "(//img[@alt='checked'])[1]")
	WebElement ride_firstmile_checkbox;

	@FindBy(xpath = "(//img[@alt='checked'])[2]")
	WebElement ride_secondmile_checkbox;

	@FindBy(xpath = "//input[@class='capitalize']")
	WebElement first_mile_from_field;

	@FindBy(xpath = "(//input[@name='Button'])[1]")
	WebElement arrive_to_station;
	
	@FindBy(xpath = "//span[text()='1 Passenger']")
	WebElement passenger_dropdown;

	@FindBy(xpath = "(//input[@name='Button'])")
	WebElement preffered_pick_up;

	@FindBy(xpath = "(//input[@class='pac-target-input'])")
	WebElement ride_firstmile_to;

	@FindBy(xpath = "//div[text()='Add to Trip']")
	WebElement add_to_trip_btn;

	@FindBy(xpath = "//button[text()='CHECK AVAIL']")
	WebElement check_avail_btn;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement success_msg;

	@FindBy(xpath = "//div[text()='1 Added']")
	WebElement one_added_text;

	@FindBy(xpath = "(//span[@class='w-5 h-5 lg:w-6 lg:h-6 rounded-full border-red mr-1 border-2 radio-edge'])[2]")
	WebElement pet_dog_radiobtn;

	@FindBy(xpath = "(//span[@class='w-5 h-5 lg:w-6 lg:h-6 rounded-full border-red mr-1 border-2 radio-edge'])[2]")
	WebElement sports_bike_radiobtn;

	@FindBy(xpath = "(//div[@class='bl-ddmenu__value text-16'])[2]")
	WebElement choose_storage_dropdown;

	@FindBy(xpath = "(//span[contains(text(),'Carry on')])[1]")
	WebElement carry_in_tower;
	
	@FindBy(xpath = "//button[@role='switch']")
	WebElement auto_renewal;
	
	@FindBy(xpath = "//input[@value='Las Olas, Fort Lauderdale, FL 33301, USA']")
	WebElement value;
	
	@FindBy(xpath = "(//div[@class='dropdown_item hover:bg-bl-blue-light'])[1]")
	WebElement dropdown_value;
	
	@FindBy(xpath = "(//div[text()='0 Added'])[4]")
	WebElement petszero_value;
	
	@FindBy(xpath = "(//div[text()='1 Added'])[1]")
	WebElement parkingone_value;
	
	@FindBy(xpath = "(//div[text()='1 Added'])[2]")
	WebElement petsone_value;
	
	@FindBy(xpath = "(//div[text()='1 Added'])[3]")
	WebElement sportsone_value;
	
	@FindBy(xpath = "//p[@class='text-bl-black text-14 mb-2 leading-1-375 lg:text-20 lg:mb-4']")
	WebElement parking_auto_text;
	
	WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 60);
	WebElement parkingaddicon;
	WebElement addtotripbtn;
	WebElement petsonevalue;
	TrainTicketsBookingPage trainticketbookingpage = new TrainTicketsBookingPage();

	public ExtrasPage() {

		PageFactory.initElements(Hooks.getDriver(), this);

	}

	public void addExtrasSection() throws InterruptedException {
		delay(25);
		String current_url = Hooks.getDriver().getCurrentUrl();
		String booking_url = current_url.replace("https://www.gobrightline.io", "http://18.116.161.225");
		delay(10);
		Hooks.getDriver().navigate().to(booking_url);
		delay(12);
	}

	public void addExtrasSectionValidation() throws InterruptedException {
		addExtrasSection();
		add_extra_text.isDisplayed();
		shared_ride.isDisplayed();
		private_ride.isDisplayed();
		parking.isDisplayed();
		pets.isDisplayed();
		sports_equipment.isDisplayed();

	}

	public void parkingAddSection() throws InterruptedException {	
		trainticketbookingpage.ticketBookingSummary();
		try {
		parkingaddicon =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[@class='w-11.5 h-auto'])[3]")));
		Actions act =  new Actions(Hooks.getDriver());
		act.moveToElement(Hooks.getDriver().findElement(By.xpath("(//img[@class='w-11.5 h-auto'])[3]"))).click().perform();
		parkingaddicon.click();}
		
		catch(Exception e) {
			Hooks.getDriver().navigate().refresh();
			parkingaddicon =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[@class='w-11.5 h-auto'])[3]")));
			Actions act =  new Actions(Hooks.getDriver());
			act.moveToElement(Hooks.getDriver().findElement(By.xpath("(//img[@class='w-11.5 h-auto'])[3]"))).click().perform();
			parkingaddicon.click();
		}
		
		delay(3);
		parking_add_person_checkbox.click();
		add_to_trip_btn.click();
		String successmsg = success_msg.getText();
		String expected = prop.getProperty("extras_added_success_message");
		Assert.assertEquals(successmsg, expected);
		one_added_text.isDisplayed();
	}

	public void petsAddSection() throws InterruptedException {
		delay(3);
		pets_add_btn.click();
		delay(2);
		pet_dog_radiobtn.click();
		choose_storage_dropdown.click();
		delay(1);
		carry_in_tower.click();
		add_to_trip_btn.click();
		String successmsg = success_msg.getText();
		String expected = prop.getProperty("extras_added_success_message");
		Assert.assertEquals(successmsg, expected);
	}

	public void firstRideFeildsVerification() throws InterruptedException {
		ride_firstmile_checkbox.click();
		delay(2);
		first_mile_from_field.isDisplayed();
		arrive_to_station.isDisplayed();
		arrive_to_station.click();
		List<WebElement> element = Hooks.getDriver().findElements(By.xpath("//div[@class='dropdown_item hover:bg-bl-blue-light']"));
		ArrayList arrivetostation = new ArrayList ();
		arrivetostation.add("15m Prior (5:32 AM)");
		arrivetostation.add("30m Prior (5:17 AM)");
		arrivetostation.add("45m Prior (5:02 AM)");
		arrivetostation.add("1h Prior (4:47 AM)");
		arrivetostation.add("1h 15m Prior (4:32 AM)");
		arrivetostation.add("1h 30m Prior (4:17 AM)");
		arrivetostation.add("1h 45m Prior (4:02 AM)");
		arrivetostation.add("2h Prior (3:47 AM)");
		arrivetostation.add("2h 15m Prior (3:32 AM)");
		
		for(int i=0; i<element.size(); i++)        
		    {
		       Assert.assertTrue(element.get(i).getText().equals(arrivetostation.get(i)));
		    
		    }
		delay(2);	
		dropdown_value.click();
		passenger_dropdown.isDisplayed();
		check_avail_btn.isDisplayed();
		delay(5);
		ride_firstmile_checkbox.click();
		delay(2);
	}
	
	public void lastRideFeildsVerification() throws InterruptedException {
		ride_secondmile_checkbox.click();
		preffered_pick_up.isDisplayed();
		preffered_pick_up.click();
		ArrayList prefferedpickup = new ArrayList ();
		prefferedpickup.add("Immediately (6:22 AM)");
		prefferedpickup.add("15m Later (6:37 AM)");
		prefferedpickup.add("30m Later (6:52 AM)");
		prefferedpickup.add("45m Later (7:07 AM)");
		prefferedpickup.add("1h Later (7:22 AM)");
		prefferedpickup.add("1h 15m Later (7:37 AM)");
		prefferedpickup.add("1h 30m Later (7:52 AM)");
		prefferedpickup.add("1h 45m Later (8:07 AM)");
		prefferedpickup.add("2h Later (8:22 AM)");
		List<WebElement> element = Hooks.getDriver().findElements(By.xpath("//div[@class='dropdown_item hover:bg-bl-blue-light']"));
		for(int i=0; i<element.size(); i++)        
	    {
		       Assert.assertTrue(element.get(i).getText().equals(prefferedpickup.get(i)));
	    } 
		ride_firstmile_to.isDisplayed();
		passenger_dropdown.isDisplayed();
		check_avail_btn.isDisplayed();
	}
	
	public void sharedRideFeildsVerification() throws InterruptedException {
		shared_ride_add_btn.click();
		firstRideFeildsVerification();
		lastRideFeildsVerification();
	}
	
	public void sharedRideSearchFunctionality() throws InterruptedException {
		addExtrasSection();
		shared_ride_add_btn.click();
		delay(3);
		ride_firstmile_checkbox.click();
		delay(2);
		first_mile_from_field.sendKeys("Las Olas, Fort Lauderdale, FL 33301, USA");
		arrive_to_station.isDisplayed();
		check_avail_btn.click();
		delay(2);
		ride_firstmile_checkbox.click();
		delay(2);
		ride_secondmile_checkbox.click();
		preffered_pick_up.isDisplayed();
		ride_firstmile_to.sendKeys("Miami, FL, USA");
		check_avail_btn.click();

	}
	
	public void sharedRideFirstMile() throws InterruptedException {
		delay(3);
		shared_ride_add_btn.click();
		delay(3);
		ride_firstmile_checkbox.click();
		delay(2);
		first_mile_from_field.sendKeys("Las Olas");
		delay(3);
		first_mile_from_field.sendKeys(Keys.ARROW_DOWN);
		delay(1);
		first_mile_from_field.sendKeys(Keys.ARROW_DOWN);
		first_mile_from_field.sendKeys(Keys.ENTER);
		delay(2);
		check_avail_btn.click();
		addtotripbtn =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='delete']")));
		add_to_trip_btn.click();
		delay(2);
    	String successmsg = success_msg.getText();
    	String expected = prop.getProperty("extras_added_success_message");
		Assert.assertEquals(successmsg, expected);

	}

	public void sharedRideWithChair() throws InterruptedException {
		addExtrasSection();
		shared_ride_add_btn.click();
		delay(3);
		ride_firstmile_checkbox.click();
		delay(5);
		auto_renewal.click();
		  String on_value = auto_renewal.getAttribute("aria-checked");
		  Assert.assertEquals("true", on_value); delay(2); auto_renewal.click(); String
		  off_value = auto_renewal.getAttribute("aria-checked");
		  Assert.assertEquals("false", off_value); delay(2); 

	}

	
	public void sportsEquipmentAddSection() throws InterruptedException {
		delay(3);
		sports_add_btn.click();
		delay(3);
		sports_bike_radiobtn.click();
		choose_storage_dropdown.click();
		carry_in_tower.click();
		add_to_trip_btn.click();
		String successmsg = success_msg.getText();
		String expected = prop.getProperty("extras_added_success_message");
		Assert.assertEquals(successmsg, expected);
	}

	public void privateRideFirstMile() throws InterruptedException {
		delay(3);
		private_ride_add_btn.click();
		delay(3);
		ride_firstmile_checkbox.click();
		delay(2);
		first_mile_from_field.sendKeys("Las Olas");
		delay(3);
		first_mile_from_field.sendKeys(Keys.ARROW_DOWN);
		delay(1);
		first_mile_from_field.sendKeys(Keys.ARROW_DOWN);
		first_mile_from_field.sendKeys(Keys.ENTER);
		delay(2);
		check_avail_btn.click();
		addtotripbtn =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='delete']")));
		add_to_trip_btn.click();
		delay(2);
    	String successmsg = success_msg.getText();
    	String expected = prop.getProperty("extras_added_success_message");
		Assert.assertEquals(successmsg, expected);
		
	}
	
	public void privateRideLastMile() throws InterruptedException {
		ride_secondmile_checkbox.click();
		ride_firstmile_to.sendKeys("Miami, FL, USA");
		delay(2);
		ride_firstmile_to.sendKeys(Keys.ARROW_DOWN);
		ride_firstmile_to.sendKeys(Keys.ARROW_DOWN);
		ride_firstmile_to.sendKeys(Keys.ENTER);
		delay(2);
		check_avail_btn.click();
		delay(10);
	}
	
	public void addToTripButton() throws InterruptedException {
		add_to_trip_btn.click();
		delay(2);
		String successmsg = success_msg.getText();
        String expected = prop.getProperty("extras_added_success_message");
		Assert.assertEquals(successmsg, expected);
	}
	
	public void privateRideRistrictedForSmart() throws InterruptedException {
		boolean yes = private_ride_add_btn.isEnabled();
		Assert.assertFalse(yes);
	}
	
	public void rideVerification() throws InterruptedException {
		addExtrasSection();
		private_ride_add_btn.isDisplayed();
		shared_ride_add_btn.isDisplayed();	
	}
	
	public void extrasAfterChangeTrip() throws InterruptedException {
		trainticketbookingpage.ticketBookingSummary();
		delay(10);
		String successmsg = success_msg.getText();
		String expected = prop.getProperty("extras_after_change_trip");
		Assert.assertEquals(successmsg, expected);
		petszero_value.isDisplayed();
	}
	
	public void extrasAfterAddingPassenger() throws InterruptedException {
		trainticketbookingpage.ticketBookingSummary();
		petsonevalue =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='1 Added'])[2]")));
		petsonevalue.isDisplayed();
		sportsone_value.isDisplayed();
		parkingone_value.isDisplayed();
	}
	
	public void editExtrasAfterAddingPassenger() throws InterruptedException {
		trainticketbookingpage.ticketBookingSummary();
		try {
		parkingaddicon =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[@class='w-11.5 h-auto'])[3]")));
		Actions act =  new Actions(Hooks.getDriver());
		act.moveToElement(Hooks.getDriver().findElement(By.xpath("(//img[@class='w-11.5 h-auto'])[3]"))).click().perform();
		parkingaddicon.click();}
		
		catch(Exception e) {
			Hooks.getDriver().navigate().refresh();
			parkingaddicon =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[@class='w-11.5 h-auto'])[3]")));
			Actions act =  new Actions(Hooks.getDriver());
			act.moveToElement(Hooks.getDriver().findElement(By.xpath("(//img[@class='w-11.5 h-auto'])[3]"))).click().perform();
			parkingaddicon.click();
		}
		delay(2);
		parking_add_person_checkbox.click();
		add_to_trip_btn.click();
		String successmsg = success_msg.getText();
		String expected = prop.getProperty("extras_updated_success_message");
		Assert.assertEquals(successmsg, expected);
	}
	
	public void extrasParkingPassApplied() throws InterruptedException {
		trainticketbookingpage.ticketBookingSummary();
		parkingaddicon =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[@class='w-11.5 h-auto'])[3]")));
		delay(2);
		Actions act =  new Actions(Hooks.getDriver());
		act.moveToElement(Hooks.getDriver().findElement(By.xpath("(//img[@class='w-11.5 h-auto'])[3]"))).click().perform();
		parkingaddicon.click();
		String successmsg = parking_auto_text.getText();
        String expected = prop.getProperty("auto_parking_text");
		Assert.assertEquals(successmsg, expected);
	}

}
