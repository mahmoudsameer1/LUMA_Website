package com.LUMA.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LUMA.actiondriver.Action;
import com.LUMA.base.Base;

public class LoginPage extends Base {

	Action action = new Action();

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span")
	private WebElement verifyTitle;
	
	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "pass")
	private WebElement pass;

	@FindBy(name = "send")
	private WebElement send;

	@FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/div[4]/div[2]/a")
	private WebElement forgotPasswordBtn;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[2]/div[2]/div/div/a")
	private WebElement createaccountBtn;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean verfiypageTitle() {
		
		return action.isDisplayed(getDriver(), verifyTitle);
		
	}
	public HomePage loginpage(String email1, String pswd) {

		action.typestring(email, email1);
		action.typestring(pass, pswd);
		action.click(getDriver(), send);
		return new HomePage();
	}

	public void forgotPassword() {

		action.click(getDriver(), forgotPasswordBtn);
	}

	public void CreateAccountBtn() {

		action.click(getDriver(), createaccountBtn);
	}
}
