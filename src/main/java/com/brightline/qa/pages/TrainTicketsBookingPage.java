package com.brightline.qa.pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

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

public class TrainTicketsBookingPage extends Hooks {

	@FindBy(className = "bl-menu__title")
	WebElement tickets_travel;

	@FindBy(xpath = "//a[text()='Train Tickets']")
	WebElement traintickets;

	@FindBy(xpath = "(//span[text()='From'])[2]")
	WebElement from_field;

	@FindBy(xpath = "//span[text()='Fort Lauderdale']")
	WebElement from_value;

	@FindBy(xpath = "(//span[text()='To'])[2]")
	WebElement to_field;

	@FindBy(xpath = "//span[text()='Miami']")
	WebElement to_value;

	@FindBy(xpath = "(//button[contains(@class,'bl-dateinput')])[3]")
	WebElement depature_field;

	@FindBy(xpath = "(//span[text()='19'])[3]")
	WebElement depature_value;

	@FindBy(xpath = "//button[text()='DONE']")
	WebElement depature_done_button;

	@FindBy(xpath = "(//button[contains(@class,'bl-dateinput')])[4]")
	WebElement return_field;

	@FindBy(xpath = "(//span[text()='29'])[4]")
	WebElement return_value;

	@FindBy(xpath = "//button[text()='DONE']")
	WebElement return_done_button;

	@FindBy(xpath = "(//button[text()='Search'])[2]")
	WebElement search;

	@FindBy(xpath = "(//div[@class='price'])[1]")
	WebElement departure_price;

	@FindBy(xpath = "(//div[@class='price'])[37]")
	WebElement return_price;

	@FindBy(id = "single-navigation-hub-next")
	WebElement addpassengers_button;

	@FindBy(xpath = "//button[@id='single-navigation-hub-next']")
	WebElement viewseats_button;

	@FindBy(xpath = "//button[@id='single-navigation-hub-next']")
	WebElement continue_button;

	@FindBy(xpath = "(//button[text()='CONTINUE TO CART'])[1]")
	WebElement continue_to_cart_button;

	@FindBy(xpath = "//button[text()='CONTINUE']")
	WebElement your_cart_continue_button;

	@FindBy(xpath = "//button[text()='Remove']")
	WebElement remove_btn;

	@FindBy(xpath = "(//button[@class='flex flex-row justify-between w-full p-4 lg:p-8 lg:py-6 items-center'])[2]")
	WebElement checkout_dropdown2;

	@FindBy(xpath = "(//button[@class='flex flex-row justify-between w-full p-4 lg:p-8 lg:py-6 items-center'])[1]")
	WebElement checkout_dropdown1;

	@FindBy(xpath = "//div[@class='flex flex-row my-1 items-centerundefined']")
	WebElement i_agree_checkbox;

	@FindBy(xpath = "(//div[@class='flex flex-row my-1 items-centerundefined'])[2]")
	WebElement i_agree_checkbox2;

	@FindBy(xpath = "//button[text()='PLACE ORDER']")
	WebElement book_button;

	@FindBy(xpath = "//button[text()='I Agree']")
	WebElement accept_button;

	@FindBy(xpath = "//div[text()='Brightline Wallet']")
	WebElement wallet_text;

	@FindBy(className = "ml-4")
	WebElement wallet_edit_icon;
	
	@FindBy(xpath = "(//button[@class='ml-4'])[2]")
	WebElement wallet_edit_icon2;
	
	@FindBy(xpath = "(//button[@class='ml-4'])[1]")
	WebElement corporate_edit_icon;

	@FindBy(xpath = "(//button[@class='ml-4'])[3]")
	WebElement wallet_editicon;
	
	@FindBy(xpath = "(//button[@class='ml-4'])[2]")
	WebElement travel_editicon;

	@FindBy(id = "pay-amount")
	WebElement payment_amount_textfield;

	@FindBy(xpath = "//button[text()='APPLY']")
	WebElement apply_btn;

	@FindBy(xpath = "//input[@name='Button']")
	WebElement cards_dropdowsdn;

	@FindBy(xpath = "(//div[text()='Mastercard 4444'])[1]")
	WebElement cards_dropdown_value;

	@FindBy(xpath = "(//span[@class='label_bl'])[1]")
	WebElement cards_dropdown;

	@FindBy(xpath = "//span[text()='Confirmed!']")
	WebElement confirmed_text;

	@FindBy(xpath = "//span[text()='Updated!']")
	WebElement updated_text;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement passes_wallet_autoapplied_msg;

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

	@FindBy(xpath = "//input[@id='holder-name']")
	WebElement card_name_text;

	@FindBy(xpath = "//input[@id='exp-date']")
	WebElement exp_date_btn;

	@FindBy(xpath = "//input[@id='cvvNum']")
	WebElement cvv_btn;

	@FindBy(xpath = "//input[@id='card-number']")
	WebElement card_number_text;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement address1_text;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement address2_text;

	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement city_text;

	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement zipcode_text;

	@FindBy(xpath = "(//button[contains(@class,'h-12')])[2]")
	WebElement yes_button;

	@FindBy(xpath = "//button[text()='Add a new card']")
	WebElement add_new_card_button;

	@FindBy(xpath = "(//div[text()='Round Trip'])[4]")
	WebElement roundtrip_button;

	@FindBy(xpath = "//img[@alt='checked']")
	WebElement save_mycard_chkbox;

	@FindBy(xpath = "//div[@class='text-16 leading-lax text-bl-teal mt-4 flex italic justify-between']/div[2]")
	WebElement credits_value_verify_text;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement alert_msg;

	@FindBy(xpath = "//span[@class='float-left']")
	WebElement ticket_id;

	@FindBy(id = "bookingReference")
	WebElement ticket_txtfield;

	@FindBy(xpath = "//button[text()='Search']")
	WebElement search_button;

	@FindBy(xpath = "(//img[@alt='down_arrow'])[1]")
	WebElement dropdown;

	@FindBy(xpath = "((//div[@class='hidden lg:block'])//span[5])[1]")
	WebElement dynamic_ticket_value;

	@FindBy(xpath = "(//span[@class='text-16 leading-5 text-bl-gray undefined'])[1]")
	WebElement useremail_text;

	@FindBy(xpath = "//span[text()='Is empty! Let’s fix that.']")
	WebElement empty_cart_text;

	@FindBy(xpath = "//h1[text()='Your cart']")
	WebElement yourcart_text;

	@FindBy(xpath = "//div[text()='Checkout']")
	WebElement checkout_text;

	@FindBy(xpath = "(//div[@class='text-16 leading-lax text-bl-teal mt-4 flex italic justify-between']/div)[1]")
	WebElement pass_applied_text;

	@FindBy(xpath = "(//div[@class='text-16 leading-lax text-bl-teal mt-4 flex italic justify-between']/div)[3]")
	WebElement corporate_ride_text;

	@FindBy(xpath = "(//div[@class='text-16 leading-lax text-bl-teal mt-4 flex italic justify-between']/div)[5]")
	WebElement oneway_rides_text;

	@FindBy(xpath = "(//div[@class='text-16 leading-lax text-bl-teal mt-4 flex italic justify-between']/div)[7]")
	WebElement credits_text;
	
	@FindBy(xpath = "(//button[text()='APPLY RIDES'])[2]")
	WebElement travelpacks_apply_btn;
	
	@FindBy(xpath = "(//button[text()='APPLY RIDES'])")
	WebElement onewaytravelpacks_apply_btn;
	

	public String ticketid;
	
	WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 60);
	WebElement cofirmed;
	WebElement updated;
	WebElement continuebutton;
	public String date;
	public String guestmobile;
    public	String guestemail;
    
	
	
	public TrainTicketsBookingPage() {

		PageFactory.initElements(Hooks.getDriver(), this);

	}

	public void ticketPriceSelection(String firstname, String lastname, String dob, String mobile)
			throws InterruptedException {
		delay(6);
		Hooks.getDriver().switchTo().frame(0);
		departure_price.click();
		return_price.click();
		Hooks.getDriver().switchTo().defaultContent();
		delay(4);
		Hooks.getDriver().switchTo().frame(0);
		delay(2);
		firstname_text.sendKeys(firstname);
		lastname_text.sendKeys(lastname);
		Select monthdropdown = new Select(Hooks.getDriver().findElement(By.className("left")));
		monthdropdown.selectByValue("06");
		Select datedropdown = new Select(Hooks.getDriver().findElement(By.className("middle")));
		datedropdown.selectByValue("06");
		Select yeardropdown = new Select(Hooks.getDriver().findElement(By.className("right")));
		yeardropdown.selectByValue("1988");
		date = getCurrentTime4digit();
		guestmobile = mobile+date;
		guestemail= date+"@sharklasers.com";
		email_text.sendKeys(guestemail);
		mobile_text.sendKeys(guestmobile);	
		viewseats_button.click();
		Hooks.getDriver().switchTo().defaultContent();
		delay(2);
		Hooks.getDriver().switchTo().frame(0);
        WebElement
		pricemenu =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Departure Seats']")));
		continue_button.click();
		Hooks.getDriver().switchTo().defaultContent();
	}

	public void premiumticketPriceSelection(String firstname, String lastname, String dob,String mobile)
			throws InterruptedException {
		delay(5);
		Hooks.getDriver().switchTo().frame(0);
		firstname_text.sendKeys(firstname);
		lastname_text.sendKeys(lastname);
		Select monthdropdown = new Select(Hooks.getDriver().findElement(By.className("left")));
		monthdropdown.selectByValue("06");
		Select datedropdown = new Select(Hooks.getDriver().findElement(By.className("middle")));
		datedropdown.selectByValue("06");
		Select yeardropdown = new Select(Hooks.getDriver().findElement(By.className("right")));
		yeardropdown.selectByValue("1988");
		date = getCurrentTime4digit();
		guestmobile = mobile+date;
		String guestemail= date+"@sharklasers.com";
		email_text.sendKeys(guestemail);
		mobile_text.sendKeys(guestmobile);
		viewseats_button.click();
		Hooks.getDriver().switchTo().defaultContent();
		delay(5);
		Hooks.getDriver().switchTo().frame(0);
		delay(3);
		continue_button.click();
		Hooks.getDriver().switchTo().defaultContent();
	}
	
	public void ticketBookingSummary() throws InterruptedException {
		String executionurl = prop.getProperty("URL");
		if (executionurl.equals("https://staging2.gobrightline.io/")) {
			boolean stgurl = wait.until(ExpectedConditions.urlMatches("https://www.gobrightline.io/"));
			String current_url = Hooks.getDriver().getCurrentUrl();
			String booking_url = current_url.replace("https://www.gobrightline.io/", "https://staging2.gobrightline.io/");
			Hooks.getDriver().navigate().to(booking_url);
		}
	}
	
	
	public void guestCartContinueButton() throws InterruptedException {
		continuebutton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[text()='CONTINUE TO CART'])[1]")));
		String current_url1 = Hooks.getDriver().getCurrentUrl();
		if(current_url1.startsWith("https://www.gobrightline.io/")) {
			ticketBookingSummary();
		}
		continuebutton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[text()='CONTINUE TO CART'])[1]")));
		Actions act =  new Actions(Hooks.getDriver());
		act.moveToElement(Hooks.getDriver().findElement(By.xpath("(//button[text()='CONTINUE TO CART'])[1]"))).click().perform();
		continuebutton.click();
		delay(3);
		String yourcarttext = yourcart_text.getText();
		String expected = prop.getProperty("your_cart_message");
		Assert.assertEquals(yourcarttext, expected);
		your_cart_continue_button.click();
		delay(3);
		String checkouttext = checkout_text.getText();
		String expected1 = prop.getProperty("checkout_text_message");
		Assert.assertEquals(checkouttext, expected1);
	}

	public void removeTicketfFromCart() throws InterruptedException {
		ticketBookingSummary();
		continuebutton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[text()='CONTINUE TO CART'])[1]")));
		Actions act =  new Actions(Hooks.getDriver());
		act.moveToElement(Hooks.getDriver().findElement(By.xpath("(//button[text()='CONTINUE TO CART'])[1]"))).click().perform();
		continuebutton.click();
		delay(3);
		remove_btn.click();
		yes_button.click();
		String emptycarttext = empty_cart_text.getText();
		Assert.assertEquals(emptycarttext, "Is empty! Let’s fix that.");
	}
	
	public void removePassFromCart() throws InterruptedException {
		delay(3);
		remove_btn.click();
		yes_button.click();
		delay(3);
		remove_btn.click();
		yes_button.click();
		String emptycarttext = empty_cart_text.getText();
		Assert.assertEquals(emptycarttext, "Is empty! Let’s fix that.");
	}

	public String GuestUserAddCard(String cardnumber, String cardname, String expdate, String cvv, String address1,
			String address2, String city, String zipcode) throws InterruptedException {
		delay(3);
		checkout_dropdown2.click();
		try {
			if (add_new_card_button.isDisplayed()) {
				add_new_card_button.click();
				Actions Act = new Actions(Hooks.getDriver());
				Act.moveToElement(card_number_text).build().perform();
				card_number_text.sendKeys(cardnumber);
				card_name_text.sendKeys(cardname);
				exp_date_btn.sendKeys(expdate);
				cvv_btn.sendKeys(cvv);
				address1_text.sendKeys(address1);
				address2_text.sendKeys(address2);
				city_text.sendKeys(city);
				zipcode_text.sendKeys(zipcode);
				save_mycard_chkbox.click();
				delay(5);
				book_button.click();
				delay(5);
				try {
					if (alert_msg.isDisplayed()) {
						String text_alertmsg = alert_msg.getText();
						String expected = prop.getProperty("card_alert_message");
						Assert.assertEquals(text_alertmsg, expected);
					}
				} catch (Exception e) {
					confirmed_text.isDisplayed();
					ticketid = ticket_id.getText();
				}

			}
		} catch (Exception e1) {
			Actions Act = new Actions(Hooks.getDriver());
			Act.moveToElement(card_number_text).build().perform();
			card_number_text.sendKeys(cardnumber);
			card_name_text.sendKeys(cardname);
			exp_date_btn.sendKeys(expdate);
			cvv_btn.sendKeys(cvv);
			address1_text.sendKeys(address1);
			address2_text.sendKeys(address2);
			city_text.sendKeys(city);
			zipcode_text.sendKeys(zipcode);
			delay(5);
			book_button.click();
			delay(5);
			try {
				if (alert_msg.isDisplayed()) {
					String text_alertmsg = alert_msg.getText();
					String expected = prop.getProperty("card_alert_message");
					Assert.assertEquals(text_alertmsg, expected);
				}
			} catch (Exception e) {
				confirmed_text.isDisplayed();
				ticketid = ticket_id.getText();
			}
		}
		return ticketid;
	}

	public void chekOutPage(String paymentType) throws InterruptedException {
		switch (paymentType) {
		case "WithSavedCards":
			try {
				if (wallet_text.isDisplayed()) {
					delay(3);
					wallet_edit_icon.click();
					payment_amount_textfield.clear();
					payment_amount_textfield.sendKeys("0.0");
					apply_btn.click();
					delay(2);
					checkout_dropdown1.click();
					delay(2);
					checkout_dropdown2.click();
					delay(2);
					cards_dropdown.click();
					delay(1);
					cards_dropdown_value.click();
					delay(3);
					book_button.click();
					try {
						cofirmed = wait.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//span[text()='Confirmed!']")));
						cofirmed.isDisplayed();
					} catch (Exception e1) {
						updated = wait.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//span[text()='Updated!']")));
						updated.isDisplayed();
					}
				}
			} catch (Exception e) {
				checkout_dropdown1.click();
				delay(5);
				cards_dropdown.click();
				delay(3);
				cards_dropdown_value.click();
				book_button.click();
				cofirmed = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//span[text()='Confirmed!']")));
				cofirmed.isDisplayed();
			}
			break;
		case "PassesBrightlineWallet":
			String autoapplied_text = passes_wallet_autoapplied_msg.getText();
			String expected = prop.getProperty("passes_brightline_wallet_message");
			Assert.assertEquals(autoapplied_text, expected);
			delay(3);
			book_button.click();
			cofirmed = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[text()='Confirmed!']")));
			cofirmed.isDisplayed();
			break;
		case "TicketCheckoutPageWithCreditsApply":
			delay(3);
			wallet_edit_icon.click();
			payment_amount_textfield.clear();
			payment_amount_textfield.sendKeys("10");
			apply_btn.click();
			String value = credits_value_verify_text.getText();
			String actualvalue = "-$10.00";
			Assert.assertEquals(actualvalue, value);
			delay(2);
			checkout_dropdown1.click();
			delay(2);
			checkout_dropdown2.click();
			delay(2);
			cards_dropdown.click();
			delay(2);
			cards_dropdown_value.click();
			delay(2);
			book_button.click();
			cofirmed = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[text()='Confirmed!']")));
			cofirmed.isDisplayed();
			break;
		case "TicketCheckoutPageWithAllPayments":
			delay(3);
			corporate_edit_icon.click();
			payment_amount_textfield.clear();
			payment_amount_textfield.sendKeys("1");
			apply_btn.click();
			delay(7);
			try {
			travelpacks_apply_btn.click();}
			catch(Exception e) {
				onewaytravelpacks_apply_btn.click();
			}
			wallet_editicon.click();
			payment_amount_textfield.clear();
			payment_amount_textfield.sendKeys("10");
			apply_btn.click();
			delay(5);
			travel_editicon.click();
			payment_amount_textfield.clear();
			payment_amount_textfield.sendKeys("1");
			apply_btn.click();
			delay(7);
			Actions tickets_hover = new Actions(Hooks.getDriver());
			tickets_hover.moveToElement(checkout_dropdown1).build().perform();
			delay(5);
			checkout_dropdown1.click();
			delay(3);
			checkout_dropdown2.click();
			delay(2);
			cards_dropdown.click();
			delay(2);
			cards_dropdown_value.click();
			delay(2);
			/*
			 * SoftAssert sft = new SoftAssert(); String pass = pass_applied_text.getText();
			 * sft.assertEquals(pass, "Sree Kanth Pass Applied"); String corporateride
			 * =corporate_ride_text.getText(); sft.assertEquals(corporateride,
			 * "1 Corporate Rides - PQR Applied"); String onewayrides
			 * =oneway_rides_text.getText();
			 * sft.assertEquals(onewayrides,"1 One-Way Rides Applied"); // String credits =
			 * credits_text.getText(); // sft.assertEquals(credits, "Credits Applied");
			 */			  delay(2);
			book_button.click();
			cofirmed = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[text()='Confirmed!']")));
			cofirmed.isDisplayed();
			//sft.assertAll();
			break;
		case "TicketCheckoutPage":
			checkout_dropdown2.click();
			delay(2);
			cards_dropdown.click();
			delay(2);
			cards_dropdown_value.click();
			book_button.click();
			cofirmed = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//span[text()='Confirmed!']")));
			cofirmed.isDisplayed();
			break;
		case "WalletTicketCheckoutPage":
			book_button.click();
			try {
				cofirmed = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//span[text()='Confirmed!']")));
				cofirmed.isDisplayed();
			} catch (Exception e) {
				updated = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//span[text()='Updated!']")));
				updated.isDisplayed();
			}
			break;
		case "WithAddCards":
			delay(3);
			wallet_edit_icon.click();
			payment_amount_textfield.clear();
			payment_amount_textfield.sendKeys("0.0");
			apply_btn.click();
			delay(3);
			checkout_dropdown1.click();
			break;
		default:
			delay(3);
			System.out.println("Invalid Input");
			break;

		}
	}
	String verify_ticketvalue;
	public void manageTripSearch(String name, String email) throws InterruptedException {
		delay(4);
		String executionurl = prop.getProperty("URL");
		if (executionurl.equals("https://staging2.gobrightline.io/")) {
		ticket_txtfield.sendKeys(ticketid.substring(9));
		System.out.println("ticker " +ticketid);}
		else {
			ticket_txtfield.sendKeys(ticketid.substring(8));
			System.out.println("ticker " +ticketid);
		}
		lastname_text.sendKeys(name);
		search_button.click();
		dropdown.click();
		String actual_email = useremail_text.getText();
		String expected_email = guestemail;
		String actual_ticketvalue = dynamic_ticket_value.getText();
		if (executionurl.equals("https://staging2.gobrightline.io/")) {
			 verify_ticketvalue = ticketid.substring(9);}
			else {
			verify_ticketvalue = ticketid.substring(8);
			}
		
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(actual_ticketvalue, verify_ticketvalue);
		sft.assertEquals(actual_email, expected_email);
		sft.assertAll();
	}

}
