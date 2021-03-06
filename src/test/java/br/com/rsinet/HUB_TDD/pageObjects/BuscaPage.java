package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuscaPage {

	public BuscaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.Advantage.aShopping:id/textViewProductName")
	private WebElement Produto;

	@FindBy(id = "com.Advantage.aShopping:id/textViewNoProductsToShow")
	private WebElement produtoNaoEncontrado;

	public void clicarproduto() {
		Produto.click();
	}

	public String ProdutoNaoEncontrado() {
		return produtoNaoEncontrado.getText();
	}

}
