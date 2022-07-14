package com.brightline.qa.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.brightline.qa.stepDefinitions.Hooks;
import com.brightline.qa.util.ExcelReader;

public class HomePage extends Hooks {

	@FindBy(xpath = "(//div[@class='lg:rounded-b-lg lg:rounded-r-lg bg-white p-5'])")
	WebElement book_tickets_tab_section;

	@FindBy(xpath = "(//div[@class='relative inline-block z-10 pt-4 pb-2 lg:pb-1 w-max px-4 lg:pt-0 lg:w-full'])[2]")
	WebElement manage_trips_tab;

	@FindBy(xpath = "(//div[@class='lg:rounded-b-lg lg:rounded-r-lg bg-white p-5'])")
	WebElement manage_trips_tab_section;

	@FindBy(xpath = "(//div[@class='relative inline-block z-10 pt-4 pb-2 lg:pb-1 w-max px-4 lg:pt-0 lg:w-full'])[3]")
	WebElement train_status_tab;

	@FindBy(xpath = "(//div[@class='lg:rounded-b-lg lg:rounded-r-lg bg-white p-5'])")
	WebElement train_status_tab_section;

	@FindBy(xpath = "//a[@title='Brightline Home']")
	WebElement home_page_text;

	@FindBy(xpath = "//button[text()='I Agree']")
	WebElement accept_button;
	
	

	public HomePage() {

		PageFactory.initElements(Hooks.getDriver(), this);
		
	}

	public void homePageValidation() throws InterruptedException {
		String homepage = home_page_text.getAttribute("title");
    	String expected_value = prop.getProperty("home_page_success_message");
		Assert.assertEquals(homepage, expected_value);
		accept_button.click();

	}

	public void homePageSearchWidget() {
		book_tickets_tab_section.isDisplayed();
		manage_trips_tab.click();
		manage_trips_tab_section.isDisplayed();
		train_status_tab.click();
		train_status_tab_section.isDisplayed();
	}

String server1;
ExcelReader reader = new ExcelReader();
List<Map<String, String>> testdata;
	
	public List<Map<String, String>> testData(String sheetName) throws InvalidFormatException, IOException {
		server1 = prop.getProperty("URL");
		if (server1.equals("https://www.gobrightline.io/")) {
			
			 testdata = reader
					.getData(".//src/main/java/com/brightline/qa/testdata/excel_testdata.xlsx", sheetName);
			
		} else if (server1.equals("https://staging2.gobrightline.io/")) {
			 testdata = reader
					.getData(".//src/main/java/com/brightline/qa/testdata/stg2_excel_testdata.xlsx", sheetName);
			 
		}
		return testdata;
		
		}
	
	}

