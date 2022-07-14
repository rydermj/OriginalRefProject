 package com.brightline.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

public class MobilityRide extends Hooks{
	

	@FindBy(className = "bl-menu__title")
	WebElement tickets_travel;

	@FindBy(xpath = "//a[text()='Train Tickets']")
	WebElement traintickets;
	
	@FindBy(xpath = "(//button[@type='button'])[9]")
	WebElement trip_dropdown;
	
	@FindBy(xpath= "//span[text()='One Way']")
	WebElement oneway_text;
	
	@FindBy(xpath= "(//button[@type='button'])[6]")
	WebElement passenger_dropdown;
	
	@FindBy(xpath= "(//div[@class='flex items-center'])[3]")
	WebElement adults_add_icon;
	
	@FindBy(xpath= "(//div[@class='flex items-center'])[6]")
	WebElement kids_add_icon;
	
	@FindBy(xpath= "(//div[@class='flex items-center'])[9]")
	WebElement infants_add_icon;
	
	@FindBy(xpath = "(//span[text()='From'])[2]")
	WebElement from_field;

	@FindBy(xpath = "//span[text()='Fort Lauderdale']")
	WebElement from_value;

	@FindBy(xpath = "(//span[text()='To'])[2]")
	WebElement to_field;

	@FindBy(xpath = "//span[text()='West Palm Beach']")
	WebElement to_value;
	
	@FindBy(xpath = "//span[text()='Miami']")
	WebElement to_value1;
	
	@FindBy(xpath = "(//button[contains(@class,'bl-dateinput')])[3]")
	WebElement depature_field;

	@FindBy(xpath = "(//span[text()='26'])[3]")
	WebElement depature_value;

	@FindBy(xpath = "//button[text()='DONE']")
	WebElement depature_done_button;
	
	@FindBy(xpath = "(//button[text()='Search'])[2]")
	WebElement search;
	
	@FindBy(xpath = "(//div[@class='price'])[2]")
	WebElement departure_price;
	
	@FindBy(xpath = "(//div[@class='price'])[1]")
	WebElement smart_departure_price;
	
	@FindBy(xpath = "//button[@id='single-navigation-hub-next']")
	WebElement viewseats_button;

	@FindBy(xpath = "//button[@id='single-navigation-hub-next']")
	WebElement continue_button;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement adult_frstname_text;
	
	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement adult_lstname_text;
	
	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement kids_frstname_text;
	
	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement kids_lstname_text;
	
	@FindBy(xpath = "(//input[@type='text'])[7]")
	WebElement infant_frstname_text;
	
	@FindBy(xpath = "(//input[@type='text'])[8]")
	WebElement infant_lstname_text;
	
	@FindBy(xpath = "(//select[@aria-required='true'])[7]")
	WebElement infant_dropdown;
	
	@FindBy(xpath = "(//select[@aria-required='true'])[11]")
	WebElement infant_dropdown1;
	
	@FindBy(xpath = "(//div[@class='price'])[39]")
	WebElement return_price;
	
	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement firstname_text;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement lastname_text;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement dob_text;

	@FindBy(xpath = "(//input[@type='email'])")
	WebElement email_text;

	@FindBy(xpath = "(//input[@type='tel'])")
	WebElement mobile_text;
	
	@FindBy(xpath = "//span[text()='\"+stationname+\"']")
	WebElement station_name;
	
	@FindBy(xpath = "(//div[text()='Round Trip'])[4]")
	WebElement roundtrip_button;
	
	@FindBy(xpath = "(//button[contains(@class,'bl-dateinput')])[4]")
	WebElement return_field;

	@FindBy(xpath = "(//span[text()='29'])[4]")
	WebElement return_value;

	@FindBy(xpath = "//button[text()='DONE']")
	WebElement return_done_button;
	
	@FindBy(className = "left")
	WebElement month_dropdown;
	
	@FindBy(className = "middle")
	WebElement date_dropdown;
	
	@FindBy(className = "right")
	WebElement year_dropdown;
	
	@FindBy(xpath = "(//div[@class='date-selector-section date-selector_section'])[4]")
	WebElement datearrow_dropdown;
	
	@FindBy(xpath = "(//*[text()='Jan'])[2]")
	WebElement date_value_dropdown;
	
	@FindBy(xpath = "(//div[@class='date-selector-section date-selector_section'])[5]")
	WebElement montharrow_dropdown;
	
	@FindBy(xpath = "(//*[text()='01'])[2]")
	WebElement month_value_dropdown;
	
	@FindBy(xpath = "(//div[@class='date-selector-section date-selector_section'])[6]")
	WebElement yeararrow_dropdown;
	
	@FindBy(xpath = "(//*[text()='2009'])[2]")
	WebElement year_value_dropdown;
	
	@FindBy(xpath = "(//div[@class='date-selector-section date-selector_section'])[7]")
	WebElement kiddatearrow_dropdown;
	
	@FindBy(xpath = "(//*[text()='Feb'])[3]")
	WebElement kiddate_value_dropdown;
	
	@FindBy(xpath = "(//div[@class='date-selector-section date-selector_section'])[8]")
	WebElement kidmontharrow_dropdown;
	
	@FindBy(xpath = "(//*[text()='02'])[3]")
	WebElement kidmonth_value_dropdown;
	
	@FindBy(xpath = "(//div[@class='date-selector-section date-selector_section'])[9]")
	WebElement kidyeararrow_dropdown;
	
	@FindBy(xpath = "(//*[text()='2016'])[3]")
	WebElement kidyear_value_dropdown;
	
	@FindBy(xpath = "(//div[@class='date-selector-section date-selector_section'])[10]")
	WebElement infantdatearrow_dropdown;
	
	@FindBy(xpath = "(//*[text()='Mar'])[4]")
	WebElement infantdate_value_dropdown;
	
	@FindBy(xpath = "(//div[@class='date-selector-section date-selector_section'])[11]")
	WebElement infantmontharrow_dropdown;
	
	@FindBy(xpath = "(//*[text()='03'])[4]")
	WebElement infantmonth_value_dropdown;
	
	@FindBy(xpath = "(//div[@class='date-selector-section date-selector_section'])[12]")
	WebElement infantyeararrow_dropdown;
	
	@FindBy(xpath = "(//*[text()='2021'])[4]")
	WebElement infantyear_value_dropdown;
	
	@FindBy(xpath = "(//select[contains(@id,'pax-ADT')])[5]")
	WebElement passengerdropdown;
	
	@FindBy(xpath = "//*[contains(text(),'ADULT FIRST')]")
	WebElement passengervalue_dropdown;
	
	
	
	
	WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 60);
	WebElement pricemenu;
	WebElement return_price_value;
	

	public MobilityRide() {

		PageFactory.initElements(Hooks.getDriver(), this);
	}

	public void oneWayTripWithWallet() throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		traintickets.click();
		delay(4);
		from_field.click();
		stationName("Fort Lauderdale");
		to_field.click();
		stationName("West Palm Beach");
		delay(4);
		depature_field.click();
		setDateFromcalendar(getMonth(),getDay());
		delay(2);
		depature_done_button.click();
		delay(2);
		search.click();
		delay(2);
	}
	
	public void oneWayTrip(String month,String date) throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		traintickets.click();
		delay(4);
		from_field.click();
		stationName("Fort Lauderdale");
		to_field.click();
		stationName("Miami");
		delay(4);
		depature_field.click();
		delay(2);
		setDateFromcalendar(month,date);
		delay(2);
		depature_done_button.click();
		delay(2);
		search.click();
		delay(2);
	}
	
	public void stationName(String stationname) throws InterruptedException {
		Hooks.getDriver().findElement(By.xpath("//span[text()='"+stationname+"']")).click();
	}
	
	public void setDateFromcalendar(String month, String date) throws InterruptedException {
		Select calendarmonth = new Select(Hooks.getDriver().findElement(By.xpath("//div[@class='bl-ts-daterange top-2-688 left-40-5p']//div[@class='hidden lg:block bl-ts-daterange__widget md:text-center']//select[@class='DateRangePicker__MonthHeaderSelect'][1]")));
		calendarmonth.selectByVisibleText(month);
		Hooks.getDriver().findElement(By.xpath("//div[@class='hidden lg:block bl-ts-daterange__widget md:text-center']//td[@class='DateRangePicker__Date' or @class='DateRangePicker__Date DateRangePicker__Date--weekend' or @class='DateRangePicker__Date DateRangePicker__Date--today']//span[text()='"+date+"']")).click();
	}
	
	
	public void oneWayTripWithMultiPassengers(String month,String date) throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		traintickets.click();
		delay(4);
		passenger_dropdown.click();
		adults_add_icon.click();
	    kids_add_icon.click();
		infants_add_icon.click();
		from_field.click();
		stationName("Fort Lauderdale");
		to_field.click();
		stationName("Miami");
		delay(2);
		depature_field.click();
		setDateFromcalendar(month,date);
		delay(2);
		depature_done_button.click();
		delay(2);
		search.click();
		delay(2);
	}
	
	public void roundTrip() throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		traintickets.click();
		delay(2);
		roundtrip_button.click();
	}

	public void trainTicketBooking(String month,String date) throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		traintickets.click();
		delay(2);
		roundtrip_button.click();
		delay(2);
		from_field.click();
		stationName("Fort Lauderdale");
		to_field.click();
		stationName("Miami");
		delay(2);
		depature_field.click();
		setDateFromcalendar(month,date);
		delay(2);
		depature_done_button.click();
		delay(2);
		//return_field.click();
		//setDateFromcalendar(month,date);
		//return_done_button.click();
		search.click();
		delay(2);
	}
	
	
	public void roundTripWithMultiPassengers(String month,String date) throws InterruptedException {
		passenger_dropdown.click();
		adults_add_icon.click();
	    kids_add_icon.click();
		infants_add_icon.click();
		from_field.click();
		stationName("Fort Lauderdale");
		to_field.click();
		stationName("Miami");
		delay(2);
		depature_field.click();
		setDateFromcalendar(month,date);
		delay(2);
		depature_done_button.click();
		delay(2);
		search.click();
		delay(2);
	}
	
	public void viewSeatsAndContinue() throws InterruptedException {
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		viewseats_button.click();
		Hooks.getDriver().switchTo().defaultContent();
		Hooks.getDriver().switchTo().frame(0);
		pricemenu =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Departure Seats']")));
		continue_button.click();
		Hooks.getDriver().switchTo().defaultContent();
	}
	
	
	public void  roundTripPremiumTicket() throws InterruptedException {
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		try {
		pricemenu =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='price'])[1]")));
		departure_price.click();
		return_price.click();
		Hooks.getDriver().switchTo().defaultContent();}
		catch(Exception e) {
			Hooks.getDriver().navigate().refresh();
			Hooks.getDriver().switchTo().frame(0);
			pricemenu =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='price'])[1]")));
			departure_price.click();
			return_price.click();
			Hooks.getDriver().switchTo().defaultContent();
		}
	}
	
	
	
	public void oneWayPremiumTicket() throws InterruptedException {
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		try {
		pricemenu =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='price'])[1]")));
		departure_price.click();
		Hooks.getDriver().switchTo().defaultContent();}
		catch(Exception e) {
			Hooks.getDriver().navigate().refresh();
			Hooks.getDriver().switchTo().frame(0);
			pricemenu =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='price'])[1]")));
			departure_price.click();
			Hooks.getDriver().switchTo().defaultContent();}
		
	}
	
	
   public void  roundTripSmartTicket() throws InterruptedException {
	   delay(3);
		Hooks.getDriver().switchTo().frame(0);
		try {
		pricemenu =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='price'])[1]")));
		smart_departure_price.click();
		return_price.click();
		Hooks.getDriver().switchTo().defaultContent();}
		catch(Exception e) {
			Hooks.getDriver().navigate().refresh();
			Hooks.getDriver().switchTo().frame(0);
			pricemenu =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='price'])[1]")));
			smart_departure_price.click();
			return_price.click();
			Hooks.getDriver().switchTo().defaultContent();}
	}
   
   public void  oneWaySmartTicket() throws InterruptedException {
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		try {
		pricemenu =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='price'])[1]")));
		smart_departure_price.click();
		Hooks.getDriver().switchTo().defaultContent();}
		catch(Exception e) {
			Hooks.getDriver().navigate().refresh();
			Hooks.getDriver().switchTo().frame(0);
			pricemenu =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='price'])[1]")));
			smart_departure_price.click();
			Hooks.getDriver().switchTo().defaultContent();}
	}
	
	public void tripWithMultiPassenger(String adultfrstname,String adultlstname, String kidsfrstname, String kidslstname,String infantfrstname,String infantlstname,String value) throws InterruptedException {
		delay(5);
		Hooks.getDriver().switchTo().frame(0);
		adult_frstname_text.sendKeys(adultfrstname);
		adult_lstname_text.sendKeys(adultlstname);
		datearrow_dropdown.click();
		date_value_dropdown.click();
		montharrow_dropdown.click();
		month_value_dropdown.click();
		yeararrow_dropdown.click();
		year_value_dropdown.click();
		delay(1);
		Select dropdown = new Select(infant_dropdown);
		dropdown.selectByVisibleText(value);
		kids_frstname_text.sendKeys(kidsfrstname);
		kids_lstname_text.sendKeys(kidslstname);
		kiddatearrow_dropdown.click();
		kiddate_value_dropdown.click();
		kidmontharrow_dropdown.click();
		kidmonth_value_dropdown.click();
		kidyeararrow_dropdown.click();
		kidyear_value_dropdown.click();
		delay(1);
		Select dropdown1 = new Select(infant_dropdown1);
		dropdown1.selectByVisibleText("A Firstname A Lastname");
		infant_frstname_text.sendKeys(infantfrstname);
		infant_lstname_text.sendKeys(infantlstname);
		infantdatearrow_dropdown.click();
		infantdate_value_dropdown.click();
		infantmontharrow_dropdown.click();
		infantmonth_value_dropdown.click();
		infantyeararrow_dropdown.click();
		infantyear_value_dropdown.click();
		delay(1);
		viewseats_button.click();
		Hooks.getDriver().switchTo().defaultContent();
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		delay(3);
		continue_button.click();
		Hooks.getDriver().switchTo().defaultContent();
	}
	
	public void guesttripWithMultiPassenger(String adultfirstname, String adultlastname, String dob, String email,
			String mobile, String adultfrstname, String adultlstname, String kidsfrstname, String kidslstname,
			String infantfrstname, String infantlstname, String value) throws InterruptedException {
		delay(5);
		Hooks.getDriver().switchTo().frame(0);
		firstname_text.sendKeys(adultfirstname);
		lastname_text.sendKeys(adultlastname);
		Select monthdropdown = new Select(month_dropdown);
		monthdropdown.selectByValue("06");
		Select datedropdown = new Select(date_dropdown);
		datedropdown.selectByValue("06");
		Select yeardropdown = new Select(year_dropdown);
		yeardropdown.selectByValue("1988");
		email_text.sendKeys(email);
		mobile_text.sendKeys(mobile);
		adult_frstname_text.sendKeys(adultfrstname);
		adult_lstname_text.sendKeys(adultlstname);
		datearrow_dropdown.click();
		date_value_dropdown.click();
		montharrow_dropdown.click();
		month_value_dropdown.click();
		yeararrow_dropdown.click();
		year_value_dropdown.click();
		delay(1);
		Select dropdown = new Select(infant_dropdown);
		dropdown.selectByVisibleText(value);
		kids_frstname_text.sendKeys(kidsfrstname);
		kids_lstname_text.sendKeys(kidslstname);
		Actions test = new Actions(Hooks.getDriver());
		test.moveToElement(infant_dropdown);
		kiddatearrow_dropdown.click();
		kiddate_value_dropdown.click();
		kidmontharrow_dropdown.click();
		kidmonth_value_dropdown.click();
		kidyeararrow_dropdown.click();
		kidyear_value_dropdown.click();
		delay(1);
		Select dropdown1 = new Select(infant_dropdown1);
		dropdown1.selectByVisibleText("A Firstname A Lastname");
		infant_frstname_text.sendKeys(infantfrstname);
		infant_lstname_text.sendKeys(infantlstname);
		infantdatearrow_dropdown.click();
		infantdate_value_dropdown.click();
		infantmontharrow_dropdown.click();
		infantmonth_value_dropdown.click();
		infantyeararrow_dropdown.click();
		infantyear_value_dropdown.click();
		delay(1);
		viewseats_button.click();
		Hooks.getDriver().switchTo().defaultContent();
		delay(3);
		Hooks.getDriver().switchTo().frame(0);
		delay(3);
		continue_button.click();
		delay(3);
	}

	public void oneWayTripWithMultiPassengersWithWallet() throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		traintickets.click();
		delay(4);
		passenger_dropdown.click();
		adults_add_icon.click();
	    kids_add_icon.click();
		infants_add_icon.click();
		from_field.click();
		stationName("Fort Lauderdale");
		to_field.click();
		stationName("West Palm Beach");
		delay(2);
		depature_field.click();
		setDateFromcalendar(getMonth(),getDay());
		delay(2);
		depature_done_button.click();
		delay(2);
		search.click();
		delay(2);
	}
	
	public void roundTripWithMultiPassengersWithWallet(String month,String date) throws InterruptedException {
		passenger_dropdown.click();
		adults_add_icon.click();
	    kids_add_icon.click();
		infants_add_icon.click();
		from_field.click();
		stationName("Fort Lauderdale");
		to_field.click();
		stationName("West Palm Beach");
		delay(4);
		depature_field.click();
		setDateFromcalendar(month,date);
		delay(2);
		depature_done_button.click();
		delay(2);
		search.click();
		delay(2);
	}
	
	public void verifyPassengerValue() throws InterruptedException {
		Hooks.getDriver().switchTo().frame(0);
		passengerdropdown.click();
		try{
			passengervalue_dropdown.isDisplayed();
			Hooks.getDriver().switchTo().defaultContent();
			
		}
		catch(NoSuchElementException e) {
			System.out.println("Element Not Displayed");
		}
	}
	
	
}
