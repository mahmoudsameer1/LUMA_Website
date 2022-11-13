package com.LUMA.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LUMA.actiondriver.Action;
import com.LUMA.base.Base;

public class ProductPage extends Base{
	
	Action action = new Action();

	@FindBy(id = "option-label-size-143-item-171")
	private WebElement siz;
	
	@FindBy(id = "option-label-color-93-item-49")
	private WebElement color;
	
	@FindBy(id = "Qty")
	private WebElement qty;
	
	@FindBy(id = "product-addtocart-button")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]")
	private WebElement cartNumber;
	
	
	public ProductPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String addToCart() {

		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), siz);
		action.click(getDriver(), color);
		action.typestring(color, "qty");
		action.click(getDriver(), addToCartBtn);
		String text = action.getText(cartNumber);
		return text;
	}
}
