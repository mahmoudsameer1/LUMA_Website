package com.LUMA.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.LUMA.base.Base;
import com.LUMA.dataProvider.DataProviders;
import com.LUMA.pageObjects.HomePage;
import com.LUMA.pageObjects.LoginPage;

public class LoginTest extends Base{

	private HomePage homePage;
	private LoginPage loginPage;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		loadConfig();
		launchApp(browser);
		afterSuite();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		getDriver().quit();
	}
	
	@Test(dataProvider = "Login", dataProviderClass = DataProviders.class)
	public void login(String email1, String pswd) {
		
		homePage = new HomePage();
		loginPage = homePage.loginBtn();
		homePage = loginPage.loginpage(email1, pswd);
		boolean verifylogin = homePage.verifyLogin();
		Assert.assertTrue(verifylogin);
	}

}
