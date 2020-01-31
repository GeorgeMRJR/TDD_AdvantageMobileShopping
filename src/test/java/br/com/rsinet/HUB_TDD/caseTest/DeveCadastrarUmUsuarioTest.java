package br.com.rsinet.HUB_TDD.caseTest;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.manager.DriverFactory;
import br.com.rsinet.HUB_TDD.manager.PageObjectManager;
import br.com.rsinet.HUB_TDD.pageObjects.CadastroPage;
import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.pageObjects.LoginPage;
import br.com.rsinet.HUB_TDD.pageObjects.MenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DeveCadastrarUmUsuarioTest extends BaseTest {

	private AndroidDriver<MobileElement> driver;
	private HomePage homePage;

	private MenuPage menuPage;
	private CadastroPage cadastroPage;
	private LoginPage loginPage;

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
	public void deveCadastrarUmUsuario() throws InterruptedException {
		homePage.clicarMenu();
		menuPage.clicarLogin();
		loginPage.clicarNovaConta();
		cadastroPage.digitarUserName("george");
	}

}
