package com.brightline.qa.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.*;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class BaseClass {
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static ThreadLocal<RemoteWebDriver> threadChrome = new ThreadLocal<>();
	public static Properties prop;
	
	String strMonth;
	String strDate;
	
	
	public void delay(int secs) throws InterruptedException {
		secs = secs * 1000;
		Thread.sleep(secs);
	}
	
	public String getCurrentTime5digit() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hmmss");
		String reportdate = simpleDateFormat.format(date);
		return reportdate;
	}
	
	public String getCurrentTime4digit() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mmss");
		String reportdate = simpleDateFormat.format(date);
		return reportdate;
	}
	
        public String getMonth() {	
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MMM");
		strMonth = dateFormat.format(tomorrow);
		return strMonth;
        }
        
        public String getDay() {
        	Calendar calendar = Calendar.getInstance();
    		calendar.add(Calendar.DAY_OF_YEAR, 1);
    		Date tomorrow = calendar.getTime();
		DateFormat dateFormatDate = new SimpleDateFormat("dd");
		strDate = dateFormatDate.format(tomorrow);	
		return strDate;
		}

	
	
}
