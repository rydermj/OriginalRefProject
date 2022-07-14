package com.brightline.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.brightline.qa.stepDefinitions.Hooks;

public class ProceedToCheckout extends Hooks{
	

	@FindBy(xpath = "//button[text()='Refund']")
	WebElement refund_text;

	public ProceedToCheckout() {

		PageFactory.initElements(Hooks.getDriver(), this);

	}

	public void parkingPass() throws InterruptedException {
		

	}

}
