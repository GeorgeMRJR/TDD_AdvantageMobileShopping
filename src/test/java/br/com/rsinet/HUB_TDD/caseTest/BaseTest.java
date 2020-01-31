package br.com.rsinet.HUB_TDD.caseTest;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import br.com.rsinet.HUB_TDD.manager.DriverFactory;

public class BaseTest {

	@AfterClass
	public void tearDownClass() {
		DriverFactory.fecharDriver();
	}

	@AfterMethod
	public void tearDown() {
		try {
			DriverFactory.getDriver().resetApp();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
