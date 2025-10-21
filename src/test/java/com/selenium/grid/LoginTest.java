package com.selenium.grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
	@SuppressWarnings("deprecation")
    @Test(invocationCount = 10)
    @Parameters({"browser"})
    public void loginTest(String browser) throws MalformedURLException {
        URL url = new URL("http://10.206.137.177:4444");
        ChromeOptions options;
        FirefoxOptions fireOptions;
        WebDriver driver = null;

        if (browser.equals("chrome")) {
            options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new RemoteWebDriver(url, options);
        } else if (browser.equals("firefox")) {
            fireOptions = new FirefoxOptions();
            fireOptions.addArguments("--incognito");
            driver = new RemoteWebDriver(url, fireOptions);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        driver.get("https://training-support.net/webelements/login-form/");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() =  'Submit']"))).click();
        wait.until(ExpectedConditions.textToBe(By.tagName("h2"), "Welcome Back, Admin!"));
        String heading = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(heading,"Welcome Back, Admin!");
        driver.quit();
    }
}
 
