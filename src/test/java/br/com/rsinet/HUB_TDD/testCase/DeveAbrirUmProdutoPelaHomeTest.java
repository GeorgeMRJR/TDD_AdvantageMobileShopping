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

import br.com.rsinet.HUB_TDD.manager.DriverFactory;
import br.com.rsinet.HUB_TDD.manager.PageObjectManager;
import br.com.rsinet.HUB_TDD.pageObjects.CategoriaProdutoPage;
import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.pageObjects.ProdutoPage;
import br.com.rsinet.HUB_TDD.suporte.ExtentReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DeveAbrirUmProdutoPelaHomeTest {

	private AndroidDriver<MobileElement> driver;
	private HomePage homePage;
	private ProdutoPage produtoPage;
	private CategoriaProdutoPage categoriaProdutoPage;
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
	}

	@Test
	public void deveAbrirUmProdutoPelaCategoria() throws InterruptedException {

		// report
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);
		
		// teste
		String produto = "HP ENVY - 17T TOUCH LAPTOP";
		String categoria = "LAPTOPS";
		homePage.clicarCategoria(categoria);
		categoriaProdutoPage.clicarproduto(produto);
		String produtoAtual = produtoPage.nomeProduto();
		
		Assert.assertEquals(produtoAtual, produto);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		ExtentReport.statusReported(test, result, driver);
		ExtentReport.quitExtent(extent);
		DriverFactory.fecharDriver();
	}

}
