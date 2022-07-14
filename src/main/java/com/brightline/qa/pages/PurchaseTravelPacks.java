package com.brightline.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.brightline.qa.stepDefinitions.Hooks;

public class PurchaseTravelPacks extends Hooks {

	@FindBy(className = "bl-menu__title")
	WebElement tickets_travel;

	@FindBy(xpath = "//a[text()='Travel Packs']")
	WebElement travel_packs;

	@FindBy(xpath = "//div[contains(text(),'Add to cart')]")
	WebElement add_to_cart_btn;

	@FindBy(xpath = "//div[@class='bl-container-grid mb-8 mt-12 lg:mt-9']")
	WebElement faq_section;

	@FindBy(xpath = "(//div[@class='bl-container-grid'])[2]")
	WebElement you_may_also_like_section;

	@FindBy(xpath = "//div[text()='Travel Pack']")
	WebElement travel_pack_text;
	
	@FindBy(xpath = "(//div[@class='bl-ddmenu__value  text-16'])[1]")
	WebElement choose_route_dropdown;
	
	@FindBy(xpath = "//span[text()='Fort Lauderdale - West Palm Beach']")
	WebElement choose_route_select;
	
	@FindBy(xpath = "(//div[@class='bl-ddmenu__value  text-16'])[2]")
	WebElement travel_class_dropdown;
	
	@FindBy(xpath = "//span[text()='Smart']")
	WebElement travel_class_select;
	
	@FindBy(xpath = "(//div[@class='bl-ddmenu__value  text-16'])[3]")
	WebElement pack_quantity_dropdown;
	
	@FindBy(xpath = "//span[text()='10 One-way Rides']")
	WebElement pack_quantity_select;
	
	@FindBy(xpath = "//div[contains(text(),'Add to')]")
	WebElement add_btn;
	
	@FindBy(xpath = "//button[text()='view cart']")
	WebElement added_to_cart_text;
	
	@FindBy(xpath = "(//button[@class='mt-2'])[2]")
	WebElement travel_packs_rightarrow;
	
	@FindBy(xpath = "//div[text()='Active until']")
	WebElement active_untill_text;
	
	@FindBy(xpath = "//button[text()='Refund']")
	WebElement refund_text;
	
	@FindBy(xpath = "//button[text()='CONTINUE']")
	WebElement your_cart_continue_button;
	
	@FindBy(xpath = "//div[text()='Checkout']")
	WebElement checkout_text;
	
	@FindBy(xpath = "//h1[text()='Your cart']")
	WebElement yourcart_text;
	
	@FindBy(xpath = "//p[text()='Purchase Summary']")
	WebElement purchase_summary_text;
	
	@FindBy(xpath = "//p[contains(text(),'You’ve added')]")
	WebElement product_text;

	public PurchaseTravelPacks() {

		PageFactory.initElements(Hooks.getDriver(), this);

	}

	public void travelPacksOptions() throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		travel_packs.click();
		delay(4);
		travel_pack_text.isDisplayed();
		add_to_cart_btn.isDisplayed();
		faq_section.isDisplayed();
		you_may_also_like_section.isDisplayed();
	}
	
	public void addToCart() throws InterruptedException {
		Actions tickets_hover = new Actions(Hooks.getDriver());
		tickets_hover.moveToElement(tickets_travel).build().perform();
		travel_packs.click();
	    delay(4);
		choose_route_dropdown.click();
		choose_route_select.click();
		travel_class_dropdown.click();
		travel_class_select.click();
		pack_quantity_dropdown.click();
		pack_quantity_select.click();
		delay(3);
		add_btn.click();
		delay(3);
		String success_msg = added_to_cart_text.getText();
		String expected = prop.getProperty("view_cart_text_message");
		Assert.assertEquals(success_msg, expected);
		
	}
	
	public void viewCartToCheckout() throws InterruptedException {
		 added_to_cart_text.click();
		 your_cart_continue_button.click();
		 String checkouttext= checkout_text.getText();
		 String expected = prop.getProperty("checkout_text_message");
		 Assert.assertEquals(checkouttext, expected);
	}
	
	public void viewCartToCheckoutPasses() throws InterruptedException {
		 added_to_cart_text.click();
	}
	
	public void yourCart() throws InterruptedException {
		 added_to_cart_text.click();
		 String yourcarttext= yourcart_text.getText();
		 String expected = prop.getProperty("your_cart_message");
		 Assert.assertEquals(yourcarttext, expected);
		 String producttext= product_text.getText();
		 String expected1 = prop.getProperty("guest_signup_message");
		 Assert.assertEquals(producttext, expected1);
		 purchase_summary_text.isDisplayed();
	}
	
	
	public void travelPackEligibility () throws InterruptedException {
		travel_packs_rightarrow.click();
		SoftAssert sftassert = new SoftAssert();
		//String a=String.valueOf(active_untill_text.isDisplayed());
		//boolean test = active_untill_text.isDisplayed();
		sftassert.assertTrue(active_untill_text.isDisplayed());
		active_untill_text.isDisplayed();
		refund_text.isDisplayed();
		//System.out.println("hello" );
		//sftassert.assertAll();
	}
}
