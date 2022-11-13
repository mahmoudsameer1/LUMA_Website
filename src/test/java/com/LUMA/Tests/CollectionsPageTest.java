package com.LUMA.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.LUMA.base.Base;
import com.LUMA.pageObjects.CollectionsPage;
import com.LUMA.pageObjects.HomePage;

public class CollectionsPageTest extends Base{
	
	private CollectionsPage collectionsPage;
	private HomePage homePage;
	
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
	public void checkListNumber () throws InterruptedException {
		homePage = new HomePage();
		collectionsPage = new CollectionsPage();
		
		collectionsPage = homePage.productItem();
		int expResult = 12;
	    int actSize = collectionsPage.ListOfProducts();
	    Assert.assertEquals(actSize, expResult);
	}
}
