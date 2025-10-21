package com.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	WebDriver driver;
	@BeforeMethod
	public void setupDriver() {
		driver=new ChromeDriver();
		driver.get("https://training-support.net/webelements/login-form/");
	}
	
//	@AfterSuite 
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
