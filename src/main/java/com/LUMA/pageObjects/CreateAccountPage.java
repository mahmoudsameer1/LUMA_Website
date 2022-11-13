package com.LUMA.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LUMA.actiondriver.Action;
import com.LUMA.base.Base;

public class CreateAccountPage extends Base {

	Action action = new Action();

	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/h1/span")
	private WebElement pageTitle;
	
	@FindBy(id = "firstname")
	private WebElement firstName;

	@FindBy(id = "lastname")
	private WebElement lastName;

	@FindBy(id = "email_address")
	private WebElement emailAddress;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "password-confirmation")
	private WebElement password_confirmation;

	@FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")
	private WebElement CreateAnAccountBtn;

	public CreateAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyPageTitle() {
		
		return action.isDisplayed(getDriver(), pageTitle);
	}

	public MyAccountPage createYourAccount(String firstname, String lastname, String emailaddress, String pswd,
			String confirmPswd) {

		action.typestring(firstName, firstname);
		action.typestring(lastName, lastname);
		action.typestring(emailAddress, emailaddress);
		action.typestring(password, pswd);
		action.typestring(password_confirmation, confirmPswd);
		action.click(getDriver(), CreateAnAccountBtn);

		return new MyAccountPage();
	}

}
