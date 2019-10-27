package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePassPOM {
	
	private WebDriver driver; 
	
	public ChangePassPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Change your password')]")
	private WebElement changepassword; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement passwordconfirm;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement submit;
	
	@FindBy(xpath="//div[@class='text-danger']")
	private WebElement gettext;
	
	public void ChangePasswordClick() {
		this.changepassword.click();
	}	
	
	public void sendpassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void sendconfPassword(String passwordconfirm) {
		this.passwordconfirm.clear(); 
		this.passwordconfirm.sendKeys(passwordconfirm); 
	}
	
	
	public void clickContBtn() {
		this.submit.click();
    }
	
	public String getText() {
		return this.gettext.getText();		
	}

}