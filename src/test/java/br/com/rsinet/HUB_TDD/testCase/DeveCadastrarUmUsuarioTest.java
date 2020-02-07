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

import br.com.rsinet.HUB_TDD.manager.Driver;
import br.com.rsinet.HUB_TDD.manager.PageObjectManager;
import br.com.rsinet.HUB_TDD.pageObjects.CadastroPage;
import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.pageObjects.LoginPage;
import br.com.rsinet.HUB_TDD.pageObjects.MenuPage;
import br.com.rsinet.HUB_TDD.suporte.ExcelConsumer;
import br.com.rsinet.HUB_TDD.suporte.ExcelUtils;
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
	private ExcelConsumer excel;

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
		menuPage = manager.getMenuPage();
		cadastroPage = manager.getCadastroPage();
		loginPage = manager.getLoginPage();
		excel = new ExcelConsumer();
	}

	@Test
	public void deveCadastrarUmUsuario() throws Throwable {

		// report
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);

		// massa
		ExcelUtils.setExcelFile("CadastrarNovoCliente_Po");
		int row = 2;
		// teste
		homePage.clicarMenu();
		menuPage.clicarLogin();
		loginPage.clicarNovaConta();
		((CadastroPage) cadastroPage //
				.digitarUserName(excel.getNomeUsuario(row) + new Random().nextInt(1000)).enter() //
				.digitarEmail(excel.getEmail(row)).enter() //
				.digitarSenha(excel.getSenha(row)).enter() //
				.digitarReSenha(excel.getReSenha(row)).enter() //
				.digitarNome(excel.getPrimeiroNome(row)).enter() //
				.digitarSobreNome(excel.getSegundoNome(row)).enter() //
				.digitarTelefone(excel.getTelefone(row)).enter() //
				.escolherContinente(excel.getContinente(row)) //
				.digitarEstado(excel.getEstado(row)).enter() //
				.digitarEndereco(excel.getEndereco(row)).enter() //
				.digitarCidade(excel.getCidade(row)).enter() //
				.digitarCep(excel.getCodPostal(row)).enter() //
				.scroll(0.9, 0.2) //
		).registrar(); //
		homePage.clicarMenu();

		assertTrue(menuPage.logado());

	}

	@Test
	public void naoDeveCadastrarUsuarioJaCadastrado() throws Throwable {

		// report
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);
		// massa
		ExcelUtils.setExcelFile("CadastrarNovoCliente_Ne");
		int row = 2;
		// teste
		homePage.clicarMenu();
		menuPage.clicarLogin();
		loginPage.clicarNovaConta();

		((CadastroPage) cadastroPage //
				.digitarUserName(excel.getNomeUsuario(row)).enter() //
				.digitarEmail(excel.getEmail(row)).enter() //
				.digitarSenha(excel.getSenha(row)).enter() //
				.digitarReSenha(excel.getReSenha(row)).enter() //
				.digitarNome(excel.getPrimeiroNome(row)).enter() //
				.digitarSobreNome(excel.getSegundoNome(row)).enter() //
				.digitarTelefone(excel.getTelefone(row)).enter() //
				.escolherContinente(excel.getContinente(row)) //
				.digitarEstado(excel.getEstado(row)).enter() //
				.digitarEndereco(excel.getEndereco(row)).enter() //
				.digitarCidade(excel.getCidade(row)).enter() //
				.digitarCep(excel.getCodPostal(row)).enter() //
				.scroll(0.9, 0.2) //
		).registrar(); //
		homePage.clicarMenu();

		assertFalse(menuPage.logado());
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		ExtentReport.statusReported(test, result, driver);
		ExtentReport.quitExtent(extent);
		Driver.fecharDriver();
	}

}
