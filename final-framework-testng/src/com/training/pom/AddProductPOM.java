package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddProductPOM {
	
	private WebDriver driver; 
	
	public AddProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'REGULAR T-SHIRTS (YELLOW)')]")
	private WebElement regularyellow; 
	
	@FindBy(xpath="//select[@id='input-option382']")
	private WebElement size;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement addcart;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement sucessfulladd;
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	private WebElement cart;
	
	@FindBy(xpath="//strong[contains(text(),'View Cart')]")
	private WebElement viewcart;
	
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement remove;
	
	
	
	public void SelectShirtYellow() {
		this.regularyellow.click();
	}	
	
		
	public void Addcart() {
		this.addcart.click(); 
	}
	
	public String ConfirmText() {
		return this.sucessfulladd.getText();
		
	}
		public void Cart() {
			this.cart.click();

	}

		public void ViewCart() {
			this.viewcart.click();
		}
			
		public void Remove() {
			this.remove.click();	

	}

}	