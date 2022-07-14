package com.brightline.qa.stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.brightline.qa.base.BaseClass;
import com.brightline.qa.util.ExcelReader;
import com.brightline.qa.util.TestUtil;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends BaseClass{
	

	public static Properties prop;
	public static final String USERNAME = "robosofttechnolo_aTQYcb";
	public static final String AUTOMATE_KEY = "syYqhfR8UPTprqyZAtVH";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	String brow;
	static String execution;
	
	
	
	@Before
	public  WebDriver initDriver()  {
		
		
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					 ".///src//main//java//com//brightline//qa//config//config.properties");
			prop.load(file);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		
		 brow = prop.getProperty("browser");
		 execution = prop.getProperty("execution");
		 if( execution.equals("local")) {

		if (brow.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".///Automation_Coding_Standards//chromedriver");
			WebDriverManager.chromedriver().setup();
		   driver.set(new ChromeDriver());
		} else if (brow.equals("firefox")) {
			System.setProperty("https", "");
		}}
		 
		 
		 
		 else if(execution.equals("browserstack")) {
			 String browserName=prop.getProperty("browser");
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser_version", "97");

				if (browserName.equals("Chrome")) {
					WebDriverManager.chromedriver().setup();
					caps.setCapability("browser", "Chrome");
				} else if (browserName.equals("Firefox")) {
					WebDriverManager.firefoxdriver().setup();
					caps.setCapability("browser", "Firefox");
				}
				try {
					WebDriverManager.chromedriver().setup();
					threadChrome.set(new RemoteWebDriver(new URL(URL), caps));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
		 }
		
		getDriver().get(prop.getProperty("URL"));
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return getDriver();
	
	}
	
	
	  public static synchronized WebDriver getDriver() { 
		 if(prop.getProperty("execution").equals("browserstack")) {
		  return threadChrome.get();}
		 else {
			 return driver.get();
		 }
	  }
	 
	 
	 

	@After
	public void teardown() throws InterruptedException {
		System.out.println("Close browser");
		getDriver().quit();
		delay(3);
	}

}
