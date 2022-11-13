package com.LUMA.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LUMA.actiondriver.Action;
import com.LUMA.base.Base;


public class HomePage extends Base{

	Action action = new Action();

	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
	private WebElement CreateAccountBtn;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
	private WebElement LoginBtn;
	
	@FindBy(name = "q")
	private WebElement searchBtn;

	@FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
	private WebElement cartBtn;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a")
	private WebElement productItems;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[1]/span")
	private WebElement verifyLogin;
	
	
	
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public CreateAccountPage createAccountBtn() {
		
		action.click(getDriver(), CreateAccountBtn);
		action.implicitWait(getDriver(), 10);
		return new CreateAccountPage();
	}
	
	public LoginPage loginBtn() {
		
		action.click(getDriver(), LoginBtn);
		return new LoginPage();
	}

	public boolean verifyLogin() {
		
		return action.isDisplayed(getDriver(), verifyLogin);
	}
	
	public void search(String seartItem) {
		
		action.typestring(searchBtn, seartItem);
	}
	
	public void cart() {
		
		action.click(getDriver(), cartBtn);
	}
	
	public CollectionsPage productItem() {
		
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), productItems);
		return new CollectionsPage(); 
	}
}
