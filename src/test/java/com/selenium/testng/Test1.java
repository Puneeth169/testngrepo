package com.selenium.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	WebDriver driver;
	@BeforeTest
	public void createDriver() {
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	//@Test
	public void login() {
		//List<WebElement> loginDetails = driver.findElements(By.xpath("//p[@class='oxd-text oxd-text--p']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	}
	
	//@Test(dependsOnMethods = {"login"})
	public void checkPage() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='oxd-main-menu-item'])[1]")));
		driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6")));
		Assert.assertEquals(driver.findElement(By.xpath("//h6")).getText(), "Admin");
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
	
}
