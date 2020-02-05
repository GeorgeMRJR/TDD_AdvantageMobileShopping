package br.com.rsinet.HUB_TDD.pageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_TDD.manager.DriverFactory;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

public class ProdutoPage {
	private WebDriver driver;

	public ProdutoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(id = "com.Advantage.aShopping:id/textViewProductName")
	private WebElement produtoNome;

	@FindBy(id = "com.Advantage.aShopping:id/textViewProductQuantity")
	private WebElement qtdProduto;

	@FindBy(id = "com.Advantage.aShopping:id/buttonProductAddToCart")
	private WebElement addToCard;

	@FindBy(id = "com.Advantage.aShopping:id/textViewCartLength")
	private WebElement qtdItensCarrinho;

	@FindBy(id = "com.Advantage.aShopping:id/textViewProductQuantity")
	private WebElement itensTotal;

	public String nomeProduto() {
		return produtoNome.getText();
	}

	public ProdutoPage clicarQtd() {
		qtdProduto.click();
		return this;
	}

	public ProdutoPage addToCart() {
		addToCard.click();
		return this;
	}

	public ProdutoPage colocarVinteItens() throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

		((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.NUMPAD_2));
		((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.NUMPAD_0));
		wait.until(ExpectedConditions.textToBePresentInElement(itensTotal, "20"));
		((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		addToCard.click();
		return this;
	}

	public String qtdProdutoCarrinho() throws MalformedURLException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.Advantage.aShopping:id/textViewCartLength")));
		return qtdItensCarrinho.getText();
	}

}
