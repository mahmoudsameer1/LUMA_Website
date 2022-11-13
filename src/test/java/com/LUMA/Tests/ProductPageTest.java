package com.LUMA.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.LUMA.base.Base;
import com.LUMA.dataProvider.DataProviders;
import com.LUMA.pageObjects.CollectionsPage;
import com.LUMA.pageObjects.HomePage;
import com.LUMA.pageObjects.LoginPage;
import com.LUMA.pageObjects.ProductPage;

public class ProductPageTest extends Base{

	private CollectionsPage collectionsPage;
	private HomePage homePage;
	private ProductPage productPage;
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
		Thread.sleep(3000);
		getDriver().quit();
	}
	
	@Test(dataProvider = "Login", dataProviderClass = DataProviders.class)
	public void addtoCart(String email1, String pswd) {
		
		homePage = new HomePage();
		collectionsPage = new CollectionsPage();
		productPage = new ProductPage();
		loginPage = new LoginPage();
		

		loginPage = homePage.loginBtn();
		homePage = loginPage.loginpage(email1, pswd);
		collectionsPage = homePage.productItem();
		productPage = collectionsPage.clickOnproduct();
		String actText = productPage.addToCart();
		System.out.println(actText);
		
	}
}
