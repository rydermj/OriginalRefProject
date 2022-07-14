package com.brightlibe.qa.runner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import com.brightline.qa.util.ReportUtils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
				
				"./src/main/java/com/brightline/qa/features",
				}, plugin = {
						"html:target/site/cucumber-pretty", "json:target/cucumber.json",
						"rerun:target/failedrerun.txt" }, glue = {
								"com.brightline.qa.stepDefinitions" }, tags = { "@New_Sanity" }, monochrome = true)



public class parallrunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	
	
	
	
	  @AfterSuite 
	  public void generateReport() {
	  
	  ReportUtils.generateJVMReport(); }
	 
	 
	 
	 
}
