package com.training.sanity.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddProductPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProductUFM_008 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddProductPOM addProductPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		addProductPOM = new AddProductPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		
		// This belwo code is to add Product to cart.
		addProductPOM.SelectShirtYellow();
		driver.findElement(By.id("input-option382")).click();
		driver.findElement(By.cssSelector("option:nth-child(7)")).click();
	    addProductPOM.Addcart();
	    String actual = addProductPOM.ConfirmText();
	    Assert.assertTrue(actual.contains("Success: You have added REGULAR T-SHIRTS (YELLOW) to your shopping"));
	    
	    // This is verify the added product and remove it from cart.
	    addProductPOM.Cart();
	    addProductPOM.ViewCart();
	    addProductPOM.Remove();
	    String actual1 = driver.findElement(By.xpath("//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')] " )).getText();
	    Assert.assertTrue(actual1.contains("Your shopping cart is empty"));
	    
	}
}