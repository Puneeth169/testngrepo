package com.selenium.testng.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practise2 {
	WebDriver driver;
	@Test
	public void openPage() {
		driver=new ChromeDriver();
		driver.get("https://webapps.tekstac.com/StarfishJS/StarFishJS.html#booking");
		driver.findElement(By.id("bdate")).sendKeys("2025/12/6");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='6-12-2025'",driver.findElement(By.id("bdate")));
	}
}
