package com.automation.livelo.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.livelo.drivers.DriverChrome;

public interface IFrame {

	DriverChrome driver = new DriverChrome();

	static void entrarFrame(String nomeOuId) {

		driver.getDriver().switchTo().frame(nomeOuId);
	}

	static void entrarFrame(By by) {

		WebElement elemento = driver.getDriver().findElement(by);

		driver.getDriver().switchTo().frame(elemento);
	}

	static void sairFrame() {

		driver.getDriver().switchTo().defaultContent();
	}

}