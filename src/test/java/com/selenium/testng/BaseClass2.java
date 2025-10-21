package com.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass2 {
	WebDriver driver;
	@BeforeTest 
	public void setupDriver() {
		driver=new EdgeDriver();
	}
	
	@AfterTest  
	public void quit() {
		driver.quit();
	}
}
