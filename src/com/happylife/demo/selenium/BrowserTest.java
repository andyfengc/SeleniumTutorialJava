package com.happylife.demo.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {
	public static void main(String[] args) {
//		openChromeWindow();
		
		// openFirefoxWindow();
		
		openIeWindow();
	}

	/**
	 * http://chromedriver.storage.googleapis.com/index.html
	 */
	private static void openChromeWindow() {
		// set chrome driver
		String chromeDriverPath = System.getProperty("user.dir") + "/lib/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		// create a new instance of chrome browser
		WebDriver driver = new ChromeDriver();
		// open the url in chrome browser
		driver.get("https://www.google.ca");
		driver.manage().window().maximize();
		String str = driver.getCurrentUrl();
		System.out.println(str);
	}

	/**
	 * if report: selenium launching Internet Explorer. Protected Mode settings are not the same for all zones
	 * open ie
	 * tools > internet options > security
	 * set all zones to the same protected mode, either all enabled or all disabled
	 */
	private static void openFirefoxWindow() {
		// Create a new instance of Firefox Browser
		WebDriver driver = new FirefoxDriver();

		// Open the URL in firefox browser
		driver.get("https://www.google.co.in/");

		// Maximize the Browser window
		driver.manage().window().maximize();

		// Get the current page URL and store the value in variable 'str'
		String str = driver.getCurrentUrl();

		// Print the value of variable in the console
		System.out.println("The current URL is " + str);
	}
	
	private static void openIeWindow(){
		// set ie driver
				String chromeDriverPath = System.getProperty("user.dir") + "/lib/IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", chromeDriverPath);
		WebDriver driver= new InternetExplorerDriver();
		driver.navigate().to("https://www.google.ca");
		
	}
}
