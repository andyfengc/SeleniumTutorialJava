package com.happylife.demo.selenium;

import java.io.UnsupportedEncodingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		// openChromeWindow();

		// openFirefoxWindow();

		// openIeWindow();

		// openPhantomJs();

		openHtmlUnitDriver();
	}

	private static void openHtmlUnitDriver() throws UnsupportedEncodingException {
		// baidu search
		// // create driver instance
		// WebDriver driver=new HtmlUnitDriver();
		// // open baidu
		// driver.get("http://www.baidu.com/");
		// // print page title
		// System.out.println("page title: "+ driver.getTitle());
		// // locate search box
		// WebElement search=driver.findElement(By.id("kw"));
		// // enter search keyword
		// search.sendKeys("cheese");
		// // locate search button
		// WebElement submit=driver.findElement(By.id("su"));
		// // click search button
		// submit.click();
		// // print page title
		// System.out.println("page title: "+driver.getTitle());
		// // print page url
		// System.out.println("page url: "+driver.getCurrentUrl());
		// // print window handler
		// System.out.println("window handler: "+driver.getWindowHandle());

		// google search
		// initialize a WebDriver instance
		WebDriver driver = new HtmlUnitDriver();
		// load google search page
		driver.get("https://www.google.ca");
		// print title
		System.out.println("Page title: " + driver.getTitle());
		// enter search word and submit
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese");
		element.submit();
		// print title
		System.out.println("Page title: " + driver.getTitle());
		// quit the driver
		driver.quit();
	}

	private static void openPhantomJs() {
		// Create a new instance of the phantomjs driver
		System.setProperty("phantomjs.binary.path", System.getProperty("user.dir") + "/lib/phantomjs.exe");
		WebDriver driver = new PhantomJSDriver();
		// visit Google
		driver.get("https://www.google.ca");
		// Alternatively the same thing can be done like this
		// driver.navigate().to("https://www.google.ca");

		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));

		// Enter something to search for
		element.sendKeys("Cheese!");

		// Now submit the form. WebDriver will find the form for us from the
		// element
		element.submit();

		// Check the title of the page
		System.out.println("Page title is: " + driver.getTitle());

		// print some content
		System.out.println("Page source code: \n" + driver.getPageSource());
		WebElement element2 = driver.findElement(By.className("st"));
		System.out.println(element2.getText());

		// Google's search is rendered dynamically with JavaScript.
		// Wait for the page to load, timeout after 10 seconds
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});

		// Should see: "cheese! - Google Search"
		System.out.println("Page title is: " + driver.getTitle());

		// Close the browser
		driver.quit();
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
	 * if report: selenium launching Internet Explorer. Protected Mode settings
	 * are not the same for all zones open ie tools > internet options >
	 * security set all zones to the same protected mode, either all enabled or
	 * all disabled
	 */
	private static void openFirefoxWindow() {
		// Create a new instance of Firefox Browser
		WebDriver driver = new FirefoxDriver();

		// Open the URL in firefox browser
		driver.get("https://www.google.ca");

		// Maximize the Browser window
		driver.manage().window().maximize();

		// Get the current page URL and store the value in variable 'str'
		String str = driver.getCurrentUrl();

		// Print the value of variable in the console
		System.out.println("The current URL is " + str);
	}

	// please set the protection model as all the same (either all enabled or all disabled)
	// please set the zoom scale as 100%
	private static void openIeWindow() {
		// set ie driver
		String driverPath = System.getProperty("user.dir") + "/lib/IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", driverPath);
		WebDriver driver = new InternetExplorerDriver();
		driver.navigate().to("https://www.google.ca");

	}
}
