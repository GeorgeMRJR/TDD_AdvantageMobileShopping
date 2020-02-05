package br.com.rsinet.HUB_TDD.testCase;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;

import org.openqa.selenium.support.PageFactory;
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
import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.pageObjects.LoginPage;
import br.com.rsinet.HUB_TDD.pageObjects.MenuPage;
import br.com.rsinet.HUB_TDD.suporte.ExtentReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DeveCadastrarUmUsuarioTest {

	private AndroidDriver<MobileElement> driver;
	private HomePage homePage;

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
		menuPage = manager.getMenuPage();
		cadastroPage = manager.getCadastroPage();
		loginPage = manager.getLoginPage();
	}

	@Test
	public void deveCadastrarUmUsuario() throws MalformedURLException {

		// report
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);

		// teste
		homePage.clicarMenu();
		menuPage.clicarLogin();
		loginPage.clicarNovaConta();
		((CadastroPage) cadastroPage //
				.digitarUserName("georgeTeste" + new Random().nextInt(1000)).enter() //
				.digitarEmail("aaaaaa@abcd.com").enter() //
				.digitarSenha("Abc123").enter() //
				.digitarReSenha("Abc123").enter() //
				.digitarNome("george").enter() //
				.digitarSobreNome("junior").enter() //
				.digitarTelefone("999888998").enter() //
				.escolherContinente("China") //
				.digitarEstado("SP").enter() //
				.digitarEndereco("av. tal").enter() //
				.digitarCidade("sorocaba").enter() //
				.digitarCep("18060000").enter() //
				.scroll(0.9, 0.2) //
		).registrar(); //
		homePage.clicarMenu();

		assertTrue(menuPage.logado());

	}

	@Test
	public void naoDeveCadastrarUsuarioJaCadastrado() throws MalformedURLException {

		// report
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);

		// teste
		homePage.clicarMenu();
		menuPage.clicarLogin();
		loginPage.clicarNovaConta();

		((CadastroPage) cadastroPage //
				.digitarUserName("georgeTeste4").enter() //
				.digitarEmail("aaaaaa@abcd.com").enter() //
				.digitarSenha("Abc123").enter() //
				.digitarReSenha("Abc123").enter() //
				.digitarNome("george").enter()//
				.digitarSobreNome("junior").enter() //
				.digitarTelefone("999888998").enter() //
				.digitarEstado("SP").enter() //
				.digitarEndereco("av. tal").enter() //
				.digitarCidade("sorocaba").enter() //
				.digitarCep("18060000").enter() //
				.scroll(0.9, 0.2) //
		).registrar(); //
		homePage.clicarMenu();

		assertFalse(menuPage.logado());
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		ExtentReport.statusReported(test, result, driver);
		ExtentReport.quitExtent(extent);
		DriverFactory.fecharDriver();
	}

}
