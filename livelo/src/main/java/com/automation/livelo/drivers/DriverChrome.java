package com.automation.livelo.drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverChrome {

	private static WebDriver driver;

	@SuppressWarnings("deprecation")
	public DriverChrome() {
		System.setProperty("webdriver.chrome.driver",
				"..\\livelo\\src\\main\\java\\com\\automation\\livelo\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	public static void finalizarDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}

	public WebDriver getDriver() {
		return driver;
	}

}
