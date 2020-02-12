package br.com.rsinet.HUB_TDD.pageObjects;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.HUB_TDD.manager.Driver;

public class CategoriaProdutoPage extends BasePage {

	public CategoriaProdutoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.Advantage.aShopping:id/textViewProductName")
	private List<WebElement> Produto;

	@FindBy(id = "com.Advantage.aShopping:id/textViewNoProductsToShow")
	private WebElement produtoNaoEncontrado;

	public void clicarproduto(String produto) throws MalformedURLException {
		boolean achou = false;
		boolean Existe = true;
		for (int j = 0; j < Produto.size(); j++) {
			WebElement element = Produto.get(j);
			if (element.getText().contains(produto.toUpperCase())) {
				achou = true;
				element.click();
				break;
			}
		}
		if (!achou && Existe) {
			scrollToText(Driver.getDriver(), produto.toUpperCase());
			if (elementToText(Driver.getDriver(), produto.toUpperCase()) != null) {
				clicarproduto(produto.toUpperCase());
			} else {
				Existe = false;
			}
		}
	}

	public String ProdutoNaoEncontrado() {
		return produtoNaoEncontrado.getText();
	}

}
