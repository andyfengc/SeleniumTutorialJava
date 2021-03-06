package com.happylife.demo.selenium.samples;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screen_shot {
	public static void main(String[] args) throws IOException {
		// Initialize WebDriver
		WebDriver driver = new FirefoxDriver();
		// Wait For Page To Load

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Go to URL
		driver.get("http://www.flipkart.com/");
		// Maximize Window
		driver.manage().window().maximize();
		// Take ScreenShot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D:\\selenium\\screenshot1.png"), true);
		// Close Driver
		driver.quit();
		}
}
