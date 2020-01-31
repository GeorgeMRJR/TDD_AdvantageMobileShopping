package br.com.rsinet.HUB_TDD.caseTest;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.manager.DriverFactory;
import br.com.rsinet.HUB_TDD.manager.PageObjectManager;
import br.com.rsinet.HUB_TDD.pageObjects.CategoriaProdutoPage;
import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.pageObjects.ProdutoPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DeveAbrirUmProdutoPelaHomeTest extends BaseTest {

	private AndroidDriver<MobileElement> driver;
	private HomePage homePage;
	private ProdutoPage produtoPage;
	private CategoriaProdutoPage categoriaProdutoPage;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		PageObjectManager manager = new PageObjectManager(driver);
		homePage = manager.getHomePage();
		produtoPage = manager.getProdutoPage();
		categoriaProdutoPage = manager.getCategoriaProdutoPage();
	}

	@Test
	public void deveAbrirUmProdutoPelaCategoria() throws InterruptedException {
		String produto = "HP ENVY - 17T TOUCH LAPTOP";
		String categoria = "LAPTOPS";
		homePage.clicarCategoria(categoria);
		categoriaProdutoPage.clicarproduto(produto);
		String produtoAtual = produtoPage.nomeProduto();
		Assert.assertEquals(produtoAtual, produto);
	}

}
