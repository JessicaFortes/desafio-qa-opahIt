package com.automation.livelo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.livelo.drivers.DriverChrome;

public class Main {

	DriverChrome driver = new DriverChrome();
	
	protected void abrirLink(String url) {

		driver.getDriver().get(url);
		
	}
	
	protected void fecharLink() {

		driver.getDriver().close();
		
	}

	protected boolean validarSeElementoExiste(By by) {
		System.out.println("Executando método validarSeElementoExiste");
		return !driver.getDriver().findElements(by).isEmpty();
	}

	protected void esperarElementoSerVisivel(By by, int tempoEmSegundos) {
		System.out.println("Executando método esperarElementoSerVisivel");
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver.getDriver(), tempoEmSegundos);

		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	protected void clicar(By by) {
		System.out.printf("Clicando no elemento [%s].\n", by.toString());
		driver.getDriver().findElement(by).click();
	}
	
	protected String obterTexto(By by) {
		
		WebElement elemento = driver.getDriver().findElement(by);
		
		return elemento.getText();
	}
	

	
	protected void esperarMilisegundos(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			//logger.error("Problema ao executar espera de milisegundos", e);
		}
	}
	
	protected void escrever(By elemento, String texto) {
		StringBuilder s = new StringBuilder();
		
		driver.getDriver().findElement(elemento).clear();
		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			s.append(c).toString();
			driver.getDriver().findElement(elemento).sendKeys(s);
			s.setLength(0);
			esperarMilisegundos(34);
		}
	}
	

}
