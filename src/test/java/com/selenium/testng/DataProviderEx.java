package com.selenium.testng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.files.ReadExcelData;

public class DataProviderEx extends BaseClass{
//	@BeforeMethod
//	public void createDriver() {
//		driver.get("https://training-support.net/webelements/login-form/");
//	}
	
	@DataProvider(name="credentials")
	public Object[][] data() throws Exception{
		ReadExcelData read=new ReadExcelData();
		return read.readData();
	}
	
	@Test(dataProvider = "credentials")
	public void test(String username,String password,String expectedResult) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		String text="";
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h2"), "Welcome Back, Admin!"));
		if(username.equals("admin") && password.equals("password")) {
			text=driver.findElement(By.tagName("h2")).getText();
		}
		else {
			text=driver.findElement(By.id("subheading")).getText();
		}
		Assert.assertEquals(text, expectedResult);
	}
}
