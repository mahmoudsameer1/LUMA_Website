package com.LUMA.pageObjects;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LUMA.actiondriver.Action;
import com.LUMA.base.Base;

public class CollectionsPage extends Base{

	Action action = new Action();
	
	@FindBy(xpath = "//li[@class='item product product-item']")
	private List<WebElement> productItems;
	
	@FindBy(xpath = "//li[@class='item product product-item']")
	private WebElement productItem;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/div[3]/div")
	private WebElement limiter;
	
	@FindBy(xpath = "//select[@id=\"limiter\"]")
	private WebElement limiteritems;
	
	
	
	public CollectionsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public int ListOfProducts() throws InterruptedException {

        action.moveToElement(getDriver(), limiter);
		action.selectByValue(limiteritems, "12");
		Thread.sleep(3000);
		int actsize = action.returnlist(productItems);
		return actsize;
	}
	
	public ProductPage clickOnproduct(){
		
		action.click(getDriver(), productItem);
		return new ProductPage();
	}
}
