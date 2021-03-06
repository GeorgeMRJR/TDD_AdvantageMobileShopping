package br.com.rsinet.HUB_TDD.pageObjects;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.rsinet.HUB_TDD.manager.Driver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class CadastroPage extends BasePage {

	public CadastroPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "android.widget.RelativeLayout")
	private List<WebElement> elementos;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextUserName']/child::*[1]")
	private WebElement uername;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextEmail']/child::*[1]")
	private WebElement email;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPassword']/child::*[1]")
	private WebElement senha;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextConfirmPassword']/child::*[1]")
	private WebElement reSenha;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextFirstName']/child::*[1]")
	private WebElement primeiroNome;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLastName']/child::*[1]")
	private WebElement sobreNome;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPhoneNumber']/child::*[1]")
	private WebElement telefone;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextState']/child::*[1]")
	private WebElement estado;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextCity']/child::*[1]")
	private WebElement cidade;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextStreet']/child::*[1]")
	private WebElement endereco;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextZip']/child::*[1]")
	private WebElement cep;

	@FindBy(id = "com.Advantage.aShopping:id/linearLayoutCountry")
	private WebElement continente;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/select_dialog_listview']")
	private WebElement continentes;

	@FindBy(className = "android.widget.Button")
	private WebElement btnRegistrar;

	public CadastroPage enter() throws MalformedURLException {
//		(new TouchAction<>(DriverFactory.getDriver())).tap(PointOption.point(985, 1699)).perform();
		Driver.getDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
		return this;
	}

	public CadastroPage digitarUserName(String userNameTxt) {
		uername.click();
		uername.sendKeys(userNameTxt);
		return this;
	}

	public CadastroPage digitarEmail(String emailTxt) {
		email.click();
		email.sendKeys(emailTxt);
		return this;
	}

	public CadastroPage digitarSenha(String senhaTxt) {
		senha.click();
		senha.sendKeys(senhaTxt);
		return this;
	}

	public CadastroPage digitarReSenha(String reSenhaTxt) {
		reSenha.click();
		reSenha.sendKeys(reSenhaTxt);
		return this;
	}

	public CadastroPage digitarNome(String nomeTxt) {
		primeiroNome.click();
		primeiroNome.sendKeys(nomeTxt);
		return this;
	}

	public CadastroPage digitarSobreNome(String sobreNomeTxt) {
		sobreNome.click();
		sobreNome.sendKeys(sobreNomeTxt);
		return this;
	}

	public CadastroPage digitarTelefone(String telefoneTxt) {
		telefone.click();
		telefone.sendKeys(telefoneTxt);
		return this;
	}

	public CadastroPage digitarEstado(String estadoTxt) {
		estado.click();
		estado.sendKeys(estadoTxt);
		return this;
	}

	public CadastroPage digitarCidade(String cidadeTxt) {
		cidade.click();
		cidade.sendKeys(cidadeTxt);
		return this;
	}

	public CadastroPage digitarEndereco(String enderecoTxt) {
		endereco.click();
		endereco.sendKeys(enderecoTxt);
		return this;
	}

	public CadastroPage digitarCep(String cepTxt) {
		cep.click();
		cep.sendKeys(cepTxt);
		return this;
	}

	public CadastroPage escolherContinente(String visibleText) throws MalformedURLException {
		continente.click();

		scrollToText((AndroidDriver<?>) Driver.getDriver(), visibleText);
		Driver.getWait().until(
				ExpectedConditions.visibilityOf(elementToText((AndroidDriver<?>) Driver.getDriver(), visibleText)));
		clickToText((AndroidDriver<?>) Driver.getDriver(), visibleText);
		return this;
	}

	public CadastroPage registrar() throws MalformedURLException {
		try {
			Driver.getDriver().hideKeyboard();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		btnRegistrar.click();

		Driver.getWait()
				.until(ExpectedConditions.presenceOfElementLocated(By.id("com.Advantage.aShopping:id/imageViewMenu")));

		return this;
	}

}
