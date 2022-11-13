package com.LUMA.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.LUMA.base.Base;
import com.LUMA.pageObjects.CreateAccountPage;
import com.LUMA.pageObjects.HomePage;
import com.LUMA.pageObjects.LoginPage;

public class HomePageTest extends Base {

	private HomePage homePage;
	private CreateAccountPage createAccountPage;
	private LoginPage loingPage;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		loadConfig();
		launchApp(browser);
		afterSuite();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().quit();
	}

	@Test
	public void clickOnCreateNewAccount() {

		homePage = new HomePage();
		createAccountPage = new CreateAccountPage();
		createAccountPage = homePage.createAccountBtn();
		boolean expTitle = createAccountPage.verifyPageTitle();
		Assert.assertTrue(expTitle);
	}

	@Test
	public void clickOnLogin() {

		homePage = new HomePage();
		loingPage = homePage.loginBtn();
		boolean trueTitle = loingPage.verfiypageTitle();
		Assert.assertTrue(trueTitle);
	}
}
