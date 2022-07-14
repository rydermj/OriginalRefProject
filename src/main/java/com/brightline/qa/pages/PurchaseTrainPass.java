package com.brightline.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.brightline.qa.stepDefinitions.Hooks;

public class PurchaseTrainPass extends Hooks {

	@FindBy(className = "bl-menu__title")
	WebElement tickets_travel;

	@FindBy(xpath = "//a[text()='Train Pass']")
	WebElement travel_passes;

	@FindBy(xpath = "//div[text()='Train Pass']")
	WebElement travel_pack_text;

	@FindBy(xpath = "(//div[@class='bl-ddmenu__value  text-16'])[1]")
	WebElement choose_route_dropdown;

	@FindBy(xpath = "//span[text()='Fort Lauderdale - West Palm Beach']")
	WebElement choose_route_select;

	@FindBy(xpath = "(//div[@class='bl-ddmenu__value  text-16'])[2]")
	WebElement travel_class_dropdown;

	@FindBy(xpath = "//span[text()='Premium']")
	WebElement travel_class_select;

	@FindBy(xpath = "(//div[@class='bl-ddmenu__value  text-16'])[3]")
	WebElement pack_quantity_dropdown;

	@FindBy(xpath = "//span[text()='1 Month']")
	WebElement pack_quantity_select;

	@FindBy(xpath = "//div[contains(text(),'Add to')]")
	WebElement add_btn;

	@FindBy(xpath = "//button[@role='switch']")
	WebElement auto_renewal;

	@FindBy(xpath = "(//a[text()='Purchase another'])[1]")
	WebElement purchase_now_link;

	@FindBy(className = "mt-2")
	WebElement train_passes_rightarrow;

	@FindBy(xpath = "//div[text()='Active until']")
	WebElement active_untill_text;

	@FindBy(xpath = "//button[text()='Refund']")
	WebElement refund_text;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement purchase_alert;

	public PurchaseTrainPass() {

		PageFactory.initElements(Hooks.getDriver(), this);

	}

	public void trainPassPage() throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		travel_passes.click();
		delay(4);
		travel_pack_text.isDisplayed();
	}

	public void trainPassToCheckout() throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		travel_passes.click();
		delay(4);
		choose_route_dropdown.click();
		choose_route_select.click();
		travel_class_dropdown.click();
		travel_class_select.click();
		pack_quantity_dropdown.click();
		pack_quantity_select.click();
	    add_btn.click();
		String success_msg = purchase_alert.getText();
		String expected = prop.getProperty("duplicate_purchase_trainpass");
		Assert.assertEquals(success_msg, expected);
	}

	public void premiumTrainPassToCheckout() throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		travel_passes.click();
		delay(4);
		choose_route_dropdown.click();
		choose_route_select.click();
		travel_class_dropdown.click();
		travel_class_select.click();
		pack_quantity_dropdown.click();
		pack_quantity_select.click();
		add_btn.click();
	}

	public void trainPassWithAutoRenew() throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		delay(2);
		travel_passes.click();
		delay(4);
		choose_route_dropdown.click();
		choose_route_select.click();
		travel_class_dropdown.click();
		travel_class_select.click();
		pack_quantity_dropdown.click();
		pack_quantity_select.click();
		auto_renewal.click();
		add_btn.click();
		String on_value = auto_renewal.getAttribute("aria-checked");
		Assert.assertEquals("true", on_value);
	}

	public void trainPassTwicePurchase() throws InterruptedException {
		delay(8); // This is mandatory as Add button need to be clicked twice
		add_btn.click();
		String alertmsg = purchase_alert.getText();
		String expected = prop.getProperty("similar_item_cart");
		Assert.assertEquals(alertmsg, expected);
		purchase_alert.click();

	}

	public void autoRenewalFunctionality() throws InterruptedException {
		String default_value = auto_renewal.getAttribute("aria-checked");
		Assert.assertEquals("false", default_value);
		delay(2);
		auto_renewal.click();
		String on_value = auto_renewal.getAttribute("aria-checked");
		Assert.assertEquals("true", on_value);
		delay(2);
		auto_renewal.click();
		String off_value = auto_renewal.getAttribute("aria-checked");
		Assert.assertEquals("false", off_value);
		delay(2);
	}

	public void verifyToogleButton() throws InterruptedException {
		trainPassPage();
		auto_renewal.isDisplayed();
	}

	public void trainPageFromWalletSection() throws InterruptedException {
		delay(4);
		purchase_now_link.click();
		delay(4);

	}

	public void trainPassEligibility() throws InterruptedException {
		train_passes_rightarrow.click();
		// SoftAssert sftassert = new SoftAssert();
		// String a=String.valueOf(active_untill_text.isDisplayed());
		// boolean test = active_untill_text.isDisplayed();
		// sftassert.assertTrue(active_untill_text.isDisplayed());
		active_untill_text.isDisplayed();
		refund_text.isDisplayed();
		// System.out.println("hello" );
		// sftassert.assertAll();

	}

}
