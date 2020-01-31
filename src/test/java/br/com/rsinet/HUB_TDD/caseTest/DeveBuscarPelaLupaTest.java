package br.com.rsinet.HUB_TDD.caseTest;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.manager.DriverFactory;
import br.com.rsinet.HUB_TDD.manager.PageObjectManager;
import br.com.rsinet.HUB_TDD.pageObjects.BuscaPage;
import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.pageObjects.ProdutoPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DeveBuscarPelaLupaTest extends BaseTest {

	private AndroidDriver<MobileElement> driver;
	private HomePage homePage;
	private BuscaPage buscaPage;
	private ProdutoPage produtoPage;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		PageObjectManager manager = new PageObjectManager(driver);
		homePage = manager.getHomePage();
		buscaPage = manager.getBuscaPage();
		produtoPage = manager.getProdutoPage();

	}

	@Test
	public void deveBuscarUmProdutoExistente() throws InterruptedException {
		String produto = "HP CHROMEBOOK 14 G1(ENERGY STAR)";
		homePage.buscar(produto);
		homePage.clicarLupa();
		buscaPage.clicarproduto();
		String atual = produtoPage.nomeProduto();
		Assert.assertEquals(atual, produto);
	}

	@Test
	public void deveBuscarUmProdutoInexistente() throws InterruptedException {
		String produto = "Iphone";
		homePage.buscar(produto);
		homePage.clicarLupa();
		String txtNaoEncontrado = buscaPage.ProdutoNaoEncontrado();
		Assert.assertTrue(txtNaoEncontrado.contains(produto));
	}

}
