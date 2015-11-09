package com.happylife.demo.selenium;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	@Test
	public void test() throws InterruptedException {
		// locate chrome driver
		String chromeDriverPath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		// create new web driver instance
		WebDriver driver = new ChromeDriver();
		// load google search page
		driver.get("http://www.google.ca");
		Thread.sleep(5000); // wait for a while so that we can see the page
		// locate search textbox
		WebElement searchBox = driver.findElement(By.name("q"));
		// enter search keyword
		searchBox.sendKeys("ChromeDriver");
		// search now
		searchBox.submit();
		Thread.sleep(5000); // wait for a while so that we observe
		// exit
		driver.quit();
	}

}