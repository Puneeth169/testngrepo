package com.selenium.testng.activity;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;

public class Activity1 {
	WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		driver=new ChromeDriver();
		driver.get("https://v1.training-support.net/");
	}
	
	@Test
	public void test() {
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Training Support");
		driver.findElement(By.id("about-link")).click();
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
}
