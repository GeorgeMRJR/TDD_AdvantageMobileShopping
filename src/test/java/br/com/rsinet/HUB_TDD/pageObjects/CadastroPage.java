package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CadastroPage {
//	private WebDriver driver;

	public CadastroPage(WebDriver driver) {
//		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView")
	private WebElement nomeUsuario;

//	MobileElement el1 = (MobileElement) driver.findElementByXPath("");
//	el1.click();

	public CadastroPage digitarUserName(String nomeUsuario) {
		this.nomeUsuario.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		this.nomeUsuario.sendKeys(nomeUsuario);
		return this;
	}

//	public void inserirDado(String NomeCampo, String texto) {
//		System.out.println("inserirdado");
//		for (int j = 0; j < campo.size(); j++) {
//			System.out.println(campo.size());
//			WebElement element = campo.get(j);
//			System.out.println(element.getText());
//			if (element.getText().contains(NomeCampo)) {
//				System.out.println(element.getText());
//				element.click();
//				element.sendKeys(texto);
//				break;
//			}
//		}
//	}
}
