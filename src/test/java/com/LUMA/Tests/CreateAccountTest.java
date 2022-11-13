package com.LUMA.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.LUMA.base.Base;
import com.LUMA.dataProvider.DataProviders;
import com.LUMA.pageObjects.CreateAccountPage;
import com.LUMA.pageObjects.HomePage;
import com.LUMA.pageObjects.MyAccountPage;


public class CreateAccountTest extends Base{

	private CreateAccountPage createAccountPage;
	private HomePage homePage;
	private MyAccountPage myAccountPage;
	
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
	
	@Test(dataProvider = "CreateAccount", dataProviderClass = DataProviders.class)
	public void startHomePageTest(String firstname, String lastname, String emailaddress, String pswd,
			String confirmPswd) {
		
		homePage = new HomePage();
		createAccountPage = new CreateAccountPage();
		createAccountPage =homePage.createAccountBtn();
		myAccountPage = createAccountPage.createYourAccount(firstname, lastname, emailaddress, pswd, confirmPswd);
		boolean trueTitle = myAccountPage.verifyTitle();
		Assert.assertTrue(trueTitle);
	}
}
