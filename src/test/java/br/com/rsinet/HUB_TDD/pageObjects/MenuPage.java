package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.HUB_TDD.manager.Driver;

public class MenuPage {

	public MenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement login;

	@FindBy(id = "com.Advantage.aShopping:id/textViewMenuSignOut")
	private WebElement logOut;

	@FindBy(id = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement menu;

	public void abrir() {
		menu.click();
	}

	public void clicarLogin() {
		login.click();
	}

	public boolean logado() {
		try {
			Driver.offImplicitlyWait();
			boolean displayed = logOut.isDisplayed();
			Driver.onImplicitlyWait();
			return displayed;
		} catch (Exception e) {
			return false;
		}
	}

}
