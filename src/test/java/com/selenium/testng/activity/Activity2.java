package com.selenium.testng.activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	
	@Test
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@Test(dependsOnMethods = {"openBrowser"})
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("Puneeth");
		driver.findElement(By.id("password")).sendKeys("Pandu");
		driver.findElement(By.className("svelte-1pdjkmx")).click();
	}
	@Test(dependsOnMethods = {"loginTest"})
	public void getLoginSuccessMessage() {
		String message = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(message, "Login Success!");
	}

	
	@AfterClass
	public void close() {
		driver.quit();
	}
}
