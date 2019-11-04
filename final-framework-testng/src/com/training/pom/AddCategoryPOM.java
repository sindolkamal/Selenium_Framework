package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCategoryPOM {
	
	private WebDriver driver; 
	
	public AddCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//input[@id='input-username']")
	private WebElement username; 
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement submit;
	
	@FindBy(xpath="//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='catalog']/a[1]")
	private WebElement catalog;
	
	@FindBy(linkText="(Categories)")
	private WebElement categories;
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addnew;
	
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement categoryname;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement categorydescription;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement megatagtitle;
	
	@FindBy(xpath="//textarea[@id='input-meta-description1']")
	private WebElement megatagdescription;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement datatab;
	
	@FindBy(xpath="//a[contains(text(),'Design')]")
	private WebElement designtab;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement save;
	
	
	
	
	
	
	public void sendUserName(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}	
	
	public void Password(String password) {
		this.password.clear();
		this.password.sendKeys(password); 
	}
	
	public void Submit() {
		this.submit.click(); 
	}
	
	public void Catalog() {
		this.catalog.click(); 
	}
    
	public void Categories() {
		this.categories.click(); 
	}
	
	public void Addnew() {
		this.addnew.click(); 
	}
	
	public void CategoryName(String categoryname) {
		this.categoryname.clear();
		this.categoryname.sendKeys(categoryname); 
	}
	
	public void CategoryDescription(String categorydescription) {
		this.categorydescription.clear();
		this.categorydescription.sendKeys(categorydescription); 
	}
	
	public void MegatagTitle(String megatagtitle) {
		this.categorydescription.clear();
		this.megatagtitle.sendKeys(megatagtitle); 
	}
	
	public void MegatagDescription(String megatagdescription) {
		this.megatagdescription.clear();
		this.megatagdescription.sendKeys(megatagdescription); 
	}
	
	public void DataTab() {
		this.datatab.click(); 
	}
	
	public void DesignTab() {
		this.designtab.click(); 
	}
	
	public void Save() {
		this.save.click(); 
	}
	
	
}	