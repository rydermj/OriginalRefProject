package com.brightlibe.qa.runner;


import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import com.brightline.qa.util.ReportUtils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {
		
		
		 "./src/main/java/com/brightline/qa/features/Login.feature",
		  "./src/main/java/com/brightline/qa/features/AccountSection.feature",
		 "./src/main/java/com/brightline/qa/features/AccountDashboard.feature",
		 "./src/main/java/com/brightline/qa/features/BookingFlowRoundTrip.feature",
		 "./src/main/java/com/brightline/qa/features/BookingFlowOneWay.feature",
		 "./src/main/java/com/brightline/qa/features/ManageTrips.feature",
		 "./src/main/java/com/brightline/qa/features/PurchaseParkingPass.feature",
		 "./src/main/java/com/brightline/qa/features/PurchaseTrainPass.feature",
		 "./src/main/java/com/brightline/qa/features/PurchaseTravelPacks.feature",
		  
		}, plugin = {
				"html:target/site/cucumber-pretty", "json:target/cucumber.json",
				"rerun:target/failedrerun.txt" }, glue = {
						"com.brightline.qa.stepDefinitions" }, tags = { "@Sanity 1" }, monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	  @AfterSuite 
	  public void generateReport() {
	  
	  ReportUtils.generateJVMReport(); 
	  }
	 	

} 