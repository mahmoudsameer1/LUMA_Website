package com.LUMA.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LUMA.actiondriver.Action;
import com.LUMA.base.Base;

public class MyAccountPage extends Base{
	
	
	Action action = new Action();

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1/span")
	private WebElement myAccountTitle;
	
	
	public MyAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean verifyTitle() {

		return action.isDisplayed(getDriver(), myAccountTitle);
	}
	
	
	
}
