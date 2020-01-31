package br.com.rsinet.HUB_TDD.manager;

import br.com.rsinet.HUB_TDD.pageObjects.BuscaPage;
import br.com.rsinet.HUB_TDD.pageObjects.CadastroPage;
import br.com.rsinet.HUB_TDD.pageObjects.CategoriaProdutoPage;
import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.pageObjects.LoginPage;
import br.com.rsinet.HUB_TDD.pageObjects.MenuPage;
import br.com.rsinet.HUB_TDD.pageObjects.ProdutoPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageObjectManager {

	private AndroidDriver<MobileElement> driver;

	private HomePage homePage;
	private BuscaPage buscaPage;
	private ProdutoPage produtoPage;
	private CategoriaProdutoPage categoriaProdutoPage;
	private CadastroPage cadastroPage;
	private LoginPage loginPage;
	private MenuPage menuPage;

	public PageObjectManager(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public BuscaPage getBuscaPage() {
		return (buscaPage == null) ? buscaPage = new BuscaPage(driver) : buscaPage;
	}

	public ProdutoPage getProdutoPage() {
		return (produtoPage == null) ? produtoPage = new ProdutoPage(driver) : produtoPage;
	}

	public CategoriaProdutoPage getCategoriaProdutoPage() {
		return (categoriaProdutoPage == null) ? categoriaProdutoPage = new CategoriaProdutoPage(driver)
				: categoriaProdutoPage;
	}

	public CadastroPage getCadastroPage() {
		return (cadastroPage == null) ? cadastroPage = new CadastroPage(driver) : cadastroPage;
	}

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public MenuPage getMenuPage() {
		return (menuPage == null) ? menuPage = new MenuPage(driver) : menuPage;
	}

}
