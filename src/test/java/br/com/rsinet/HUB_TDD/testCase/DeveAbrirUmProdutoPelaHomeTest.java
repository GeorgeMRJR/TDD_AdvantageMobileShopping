package br.com.rsinet.HUB_TDD.testCase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.manager.DriverFactory;
import br.com.rsinet.HUB_TDD.manager.PageObjectManager;
import br.com.rsinet.HUB_TDD.pageObjects.CadastroPage;
import br.com.rsinet.HUB_TDD.pageObjects.CategoriaProdutoPage;
import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.pageObjects.LoginPage;
import br.com.rsinet.HUB_TDD.pageObjects.MenuPage;
import br.com.rsinet.HUB_TDD.pageObjects.ProdutoPage;
import br.com.rsinet.HUB_TDD.suporte.ExtentReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DeveAbrirUmProdutoPelaHomeTest {

	private AndroidDriver<MobileElement> driver;
	private HomePage homePage;
	private ProdutoPage produtoPage;
	private CategoriaProdutoPage categoriaProdutoPage;
	private MenuPage menuPage;
	private CadastroPage cadastroPage;
	private LoginPage loginPage;
	private ExtentReports extent;
	private String testName;
	private ExtentTest test;

	@BeforeTest
	public void setUpReport() {
		extent = ExtentReport.setReport();
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		PageObjectManager manager = new PageObjectManager(driver);
		homePage = manager.getHomePage();
		produtoPage = manager.getProdutoPage();
		categoriaProdutoPage = manager.getCategoriaProdutoPage();
		menuPage = manager.getMenuPage();
		cadastroPage = manager.getCadastroPage();
		loginPage = manager.getLoginPage();
	}

	@Test
	public void deveAbrirUmProdutoPelaCategoria() throws InterruptedException, MalformedURLException {

		// report
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);

		// teste
		String produto = "HP Z3600 Wireless Mouse";
		String categoria = "MICE";
		homePage.clicarCategoria(categoria);
		categoriaProdutoPage.clicarproduto(produto.toUpperCase());
		String produtoAtual = produtoPage.nomeProduto();

		Assert.assertEquals(produtoAtual.toUpperCase(), produto.toUpperCase());
	}

	@Test
	public void naoDeveAceitarMaisDeDezItensNoCarrinho() throws MalformedURLException {
		String produto = "HP ENVY - 17T TOUCH LAPTOP";
		String categoria = "LAPTOPS";
		homePage.clicarMenu();
		menuPage.clicarLogin();
		loginPage.clicarNovaConta();
		((CadastroPage) cadastroPage//
				.digitarUserName("carrinho" + new Random().nextInt(1000)).enter() //
				.digitarEmail("aaaaaa@abcd.com").enter() //
				.digitarSenha("Abc123").enter() //
				.digitarReSenha("Abc123").enter() //
				.scroll(0.9, 0.2) //
				.scroll(0.9, 0.2) //
		).registrar(); //

		homePage.clicarCategoria(categoria);
		categoriaProdutoPage.clicarproduto(produto);

		String qtdProdutoCarrinho = produtoPage //
				.clicarQtd() //
				.colocarVinteItens() //
				.addToCart() //
				.qtdProdutoCarrinho(); //

		int parseInt = Integer.parseInt(qtdProdutoCarrinho);
		Assert.assertTrue(parseInt <= 10);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		ExtentReport.statusReported(test, result, driver);
		ExtentReport.quitExtent(extent);
		DriverFactory.fecharDriver();
	}

}
