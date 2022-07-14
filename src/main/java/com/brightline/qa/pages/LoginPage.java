package com.brightline.qa.pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.brightline.qa.stepDefinitions.Hooks;

public class LoginPage extends Hooks {

	@FindBy(name = "email")
	WebElement emailid;

	@FindBy(id = "password")
	WebElement passwordid;

	@FindBy(className = "bl-forgot__password_link")
	WebElement forgot_password_btn;

	@FindBy(xpath = "//button[contains(@class,'h-12')]")
	WebElement signinbtn;

	@FindBy(xpath = "//span[@class='bl-account__profile']")
	WebElement usericon;

	@FindBy(xpath = "(//button[@class='block text-bl-blue font-semibold px-0 py-1 text-16'])[2]")
	WebElement logout;

	@FindBy(xpath = "//div[@class='bl-auth__cta']")
	WebElement next_button;

	@FindBy(xpath = "(//button[contains(@class,'h-12')])[2]")
	WebElement yes_button;

	@FindBy(xpath = "//button[@class='bl-btn bl-btn-primary']")
	WebElement login_button;

	@FindBy(xpath = "//button[text()='GET RESET LINK']")
	WebElement get_rest_link_btn;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement success_msg;

	@FindBy(xpath = "//button[text()='Remove from Cart']")
	WebElement remove_button;

	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement sign_up_link;

	@FindBy(id = "firstName")
	WebElement firstname_text;

	@FindBy(id = "lastName")
	WebElement lastname_text;

	@FindBy(id = "dob")
	WebElement dob_text;

	@FindBy(id = "phoneNumber")
	WebElement mobile_text;

	@FindBy(id = "email")
	WebElement email_text;

	@FindBy(id = "password")
	WebElement password_text;

	@FindBy(xpath = "//img[@alt='checked']")
	WebElement signup_checkbox;

	@FindBy(xpath = "//button[text()='SIGN UP']")
	WebElement signup_btn;

	@FindBy(xpath = "//button[text()='Create minor account']")
	WebElement create_minor_acct;

	@FindBy(xpath = "//div[text()='Invalid. Please try again']")
	WebElement invalid_cred_text;

	@FindBy(id = "login")
	WebElement yopmail_email;

	@FindBy(xpath = "//button[@title='Check Inbox @yopmail.com']")
	WebElement yop_next_button;

	@FindBy(xpath = "//button[text()='SAVE']")
	WebElement save_button;

	@FindBy(xpath = "//*[@id='mail']/div/center/table/tbody/tr/td/center/div[3]/div[3]/div/div/div/div/div/div/a")
	WebElement yop_forgotpswd_link;

	@FindBy(xpath = "//div[@class='bl-input__helper-text text-left bl-input__helper-text--error']")
	WebElement same_pswd_text;

	@FindBy(xpath = "//div[@class=' lg:text-lg font-semibold text-bl-black   text-center text-lg mt-8']")
	WebElement pswd_success_msg;


	WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 60);
	WebElement emailtextbox;
	String date;
	String updated_password;

	public LoginPage() {

		PageFactory.initElements(Hooks.getDriver(), this);

	}

	public void authentication(String Email, String Password) throws InterruptedException {
		delay(2);
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		login_button.click();
		emailtextbox =wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));		
		emailid.sendKeys(Email);
		passwordid.sendKeys(Password);
		signinbtn.click();
		delay(4);
		try {
			if (remove_button.isDisplayed()) {
				remove_button.click();
				delay(1);
			}
		} catch (Exception e) {
		}
	}

	public void invalidCredentials(String Email, String Password) throws InterruptedException {
		delay(2);
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		try {
		login_button.click();}
		catch(Exception e) {
			login_button.click();
		}
		emailtextbox =wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));		
		emailid.sendKeys(Email);
		passwordid.sendKeys(Password);
		signinbtn.click();
		String text_alertmsg = invalid_cred_text.getText();
		String expected = prop.getProperty("invalid_alert_message");
		Assert.assertEquals(text_alertmsg, expected);
	}

	public void logout() throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		delay(4);
		logout.click();
		delay(3);
		yes_button.click();
		delay(1);
	}

	public void forgotPasswordClick(String email) throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		login_button.click();
		delay(8);
		emailid.sendKeys(email);
		forgot_password_btn.click();
	}

	public void forgotPasswordVerification() throws InterruptedException {
		get_rest_link_btn.click();
		successMessage();
	}

	public void signUpAsNewUser(String firstname, String lastname, String dob, String mobile, String email,
			String password) throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		sign_up_link.click();
		firstname_text.sendKeys(firstname);
		lastname_text.sendKeys(lastname);
		dob_text.sendKeys(dob);
		mobile_text.sendKeys(mobile);
		email_text.sendKeys(email);
		password_text.sendKeys(password);
		signup_checkbox.click();
		signup_btn.click();
		successMessage();
		delay(2);
	}

	public void signUpAsMinor(String firstname, String lastname, String dob, String mobile, String email,
			String password) throws InterruptedException {
		Actions hover = new Actions(Hooks.getDriver());
		hover.moveToElement(usericon).build().perform();
		sign_up_link.click();
		firstname_text.sendKeys(firstname);
		lastname_text.sendKeys(lastname);
		dob_text.sendKeys(dob);
		lastname_text.click();
		create_minor_acct.click();
		signup_checkbox.click();
		email_text.sendKeys(email);
		mobile_text.sendKeys(mobile);
		password_text.sendKeys(password);
		signup_checkbox.click();
		signup_btn.click();
		successMessage();
	}

	public void successMessage() throws InterruptedException {
		String text_successmsg = success_msg.getText();
		String expected = prop.getProperty("email_sent_message");
		Assert.assertEquals(text_successmsg, expected);
	}


	public void loginAfterPasswordChange(String email,String yupmail) throws InterruptedException {
		forgotPasswordClick(email);
		forgotPasswordVerification();
		delay(5);
		Hooks.getDriver().get("https://yopmail.com/");
		delay(2);
		yopmail_email.sendKeys(yupmail);
		yop_next_button.click();
		delay(8);
		Hooks.getDriver().switchTo().frame("ifmail");
		yop_forgotpswd_link.click();
		delay(3);
		String subWindowHandler = null;
		Set<String> handles = Hooks.getDriver().getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		Hooks.getDriver().switchTo().window(subWindowHandler);
		delay(3);
		date = getCurrentTime5digit();
		updated_password = "Sreekanth@" + date;
		passwordid.sendKeys(updated_password);
		save_button.click();
		String actual = pswd_success_msg.getText();
		String expected = prop.getProperty("pswd_success_msg");
		Assert.assertEquals(actual, expected);
		authentication(email, updated_password);
		logout();
		delay(2);
	}

	public void forgotPasswordValidation() throws InterruptedException {
		forgotPasswordClick("");
		forgotPasswordVerification();
		delay(5);
		Hooks.getDriver().get("https://yopmail.com/");
		delay(3);
		yop_next_button.click();
		delay(3);
		Hooks.getDriver().switchTo().frame("ifmail");
		yop_forgotpswd_link.click();
		delay(3);
		String subWindowHandler = null;
		Set<String> handles = Hooks.getDriver().getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		Hooks.getDriver().switchTo().window(subWindowHandler);
		delay(3);
		passwordid.sendKeys(updated_password);
		save_button.click();
		String actual = same_pswd_text.getText();
		String expected = prop.getProperty("same_forgot_password");
		Assert.assertEquals(actual, expected);
	}
}
