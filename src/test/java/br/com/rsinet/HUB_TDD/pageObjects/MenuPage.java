package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
//	private WebDriver driver;

	public MenuPage(WebDriver driver) {
//		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement login;

	public void clicarLogin() {
		login.click();
	}

}
