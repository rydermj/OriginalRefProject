package com.brightline.qa.stepDefinitions;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.Parameters;

import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserStackBaseTest {
	
	public static WebDriver driver;
	public static final String USERNAME = "sreekanth40";
	public static final String AUTOMATE_KEY = "EcbzThzpPVrvfvyCQjHJ";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static Properties prop;
	
	//@Before
	
	public void setUp() {
		
		//System.out.println("browser name is : " + browserName);
		//String methodName = name.getName();
		String browserName="chrome";
		DesiredCapabilities caps = new DesiredCapabilities();
        
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser_version", "85.0");
		//caps.setCapability("name", methodName);
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					 ".///src//main//java//com//brightline//qa//config//config.properties");
			prop.load(file);
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			caps.setCapability("browser", "Chrome");
		} else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			caps.setCapability("browser", "Firefox");
		}
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	

}
