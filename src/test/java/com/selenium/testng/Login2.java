package com.selenium.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login2 extends BaseClass2 {
	@BeforeClass
	public void createDriver() {
		//driver=new ChromeDriver();
		driver.get("https://training-support.net/webelements/login-form/");
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h2"), "Welcome Back, Admin!"));
		Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Welcome Back, Admin!");
	}
}
