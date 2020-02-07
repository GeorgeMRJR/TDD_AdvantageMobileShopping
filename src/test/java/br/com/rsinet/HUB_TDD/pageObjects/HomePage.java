package br.com.rsinet.HUB_TDD.pageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.rsinet.HUB_TDD.manager.Driver;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(id = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement menu;

	@FindBy(id = "com.Advantage.aShopping:id/editTextSearch")
	private WebElement busca;

	@FindBy(id = "com.Advantage.aShopping:id/imageViewSearch")
	private WebElement lupa;

	public void buscar(String produto) {
		busca.sendKeys(produto);
	}

	public void clicarLupa() {
		lupa.click();
	}

	public void clicarMenu() {
		menu.click();
	}

	public void clicarCategoria(String Categoria) throws MalformedURLException {
		switch (Categoria) {
		case "LAPTOPS":
			Driver.getWait()
					.until(ExpectedConditions.visibilityOf(elementToText((AndroidDriver<?>) driver, "LAPTOPS")));
			clickToText((AndroidDriver<?>) driver, "LAPTOPS");
			break;

		case "HEADPHONES":
			Driver.getWait()
					.until(ExpectedConditions.visibilityOf(elementToText((AndroidDriver<?>) driver, "HEADPHONES")));
			clickToText((AndroidDriver<?>) driver, "HEADPHONES");
			break;

		case "TABLETS":
			Driver.getWait()
					.until(ExpectedConditions.visibilityOf(elementToText((AndroidDriver<?>) driver, "TABLETS")));
			clickToText((AndroidDriver<?>) driver, "TABLETS");
			break;

		case "SPEAKERS":
			scrollToText((AndroidDriver<?>) driver, "SPEAKERS");
			Driver.getWait()
					.until(ExpectedConditions.visibilityOf(elementToText((AndroidDriver<?>) driver, "SPEAKERS")));
			clickToText((AndroidDriver<?>) driver, "SPEAKERS");
			break;

		case "MICE":
			scrollToText((AndroidDriver<?>) driver, "MICE");
			Driver.getWait().until(ExpectedConditions.visibilityOf(elementToText((AndroidDriver<?>) driver, "MICE")));
			clickToText((AndroidDriver<?>) driver, "MICE");
			break;

		default:
			System.out.println("categoria nao encontrada");
			break;
		}
	}

}
