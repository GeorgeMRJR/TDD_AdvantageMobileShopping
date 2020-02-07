package br.com.rsinet.HUB_TDD.testCase;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.manager.Driver;
import br.com.rsinet.HUB_TDD.manager.PageObjectManager;
import br.com.rsinet.HUB_TDD.pageObjects.BuscaPage;
import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.pageObjects.ProdutoPage;
import br.com.rsinet.HUB_TDD.suporte.ExtentReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DeveBuscarPelaLupaTest {

	private AndroidDriver<MobileElement> driver;
	private HomePage homePage;
	private BuscaPage buscaPage;
	private ProdutoPage produtoPage;
	private ExtentReports extent;
	private String testName;
	private ExtentTest test;

	@BeforeTest
	public void setUpReport() {
		extent = ExtentReport.setReport();
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
		PageObjectManager manager = new PageObjectManager(driver);
		homePage = manager.getHomePage();
		buscaPage = manager.getBuscaPage();
		produtoPage = manager.getProdutoPage();

	}

	@Test
	public void deveBuscarUmProdutoExistente() throws InterruptedException {

//		// report
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);

		// teste
		String produto = "HP CHROMEBOOK 14 G1(ENERGY STAR)";
		homePage.buscar(produto);
		homePage.clicarLupa();
		buscaPage.clicarproduto();
		String atual = produtoPage.nomeProduto();

		Assert.assertEquals(atual, produto);
	}

	@Test
	public void deveBuscarUmProdutoInexistente() throws InterruptedException {

		// report
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);

		// teste
		String produto = "Iphone";
		homePage.buscar(produto);
		homePage.clicarLupa();
		String txtNaoEncontrado = buscaPage.ProdutoNaoEncontrado();

		Assert.assertTrue(txtNaoEncontrado.contains(produto));
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		ExtentReport.statusReported(test, result, driver);
		ExtentReport.quitExtent(extent);
		Driver.fecharDriver();
	}

}
