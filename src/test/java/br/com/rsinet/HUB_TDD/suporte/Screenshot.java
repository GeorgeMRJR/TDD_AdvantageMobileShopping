package br.com.rsinet.HUB_TDD.suporte;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static String gerarScreenShot(WebDriver driver, String nome) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destino = System.getProperty("user.dir") + "/report/Screenshot/" + nome + "-"
				+ Generator.dataHoraParaArquivo() + ".png";

		try {
			FileUtils.copyFile(file, new File(destino));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destino;
	}

}
