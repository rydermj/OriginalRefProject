package com.brightlibe.qa.runner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;

import com.brightline.qa.util.ReportUtils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class Failedrunner {
	
	@CucumberOptions(features="@target/failedrerun.txt",
	        plugin ={"pretty","json:target1/cucumber.json","rerun:target/failedrerun.txt"},
	        glue={"com.brightline.qa.stepDefinitions"}
	        )


	public class TestRunner extends AbstractTestNGCucumberTests{
		
		
		
		  @AfterSuite 
		  public void generateReport() {
		  
		  ReportUtils.generateJVMReport(); }
		 

	        
	       
	    	

	}
}
