package com.training.sanity.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
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
import com.training.pom.AddCategoryPOM;
import com.training.pom.AddProductPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditCategoryUNF_0039 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddProductPOM addProductPOM;
	private AddCategoryPOM addCategoryPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException, InterruptedException  {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		addProductPOM = new AddProductPOM(driver);
		addCategoryPOM = new AddCategoryPOM(driver);
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
	public void validLoginTest() throws InterruptedException, IOException {
		boolean isFound = false;
		// This below code is to add Product to cart.
		addCategoryPOM.sendUserName("admin");
	    addCategoryPOM.Password("admin@123");
	    addCategoryPOM.Submit();
	    
	   	addCategoryPOM.Catalog();
	    Actions actions = new Actions(driver);
	    WebElement menuOption = driver.findElement(By.cssSelector(".fa-tags"));
	    actions.moveToElement(menuOption).perform();
	    Thread.sleep(1000);
	    
	    List<WebElement>linklist=driver.findElements(By.xpath("//li[@id='catalog']/ul/li"));
         System.out.println("No. of links is: "+linklist.size());
		
		//To print the link names
		for(int j=0;j<linklist.size();j++){
			System.out.println(linklist.get(j).getText());
		}
	   
	   List<WebElement> lstProductSubmenu =driver.findElements(By.xpath("//a[contains(text(),'Categories')]"));
	    for (WebElement list : lstProductSubmenu) {

	        String getname = list.getText();
	        System.out.println(getname);

	        if (getname.equals("Categories")) {

	            System.out.println("Pass");
	            isFound = true;
	            break;
	        }

	    }
	    if(!isFound)
	       System.out.println("not found");
	    
	    driver.findElement(By.linkText("Categories")).click();
	    driver.findElement(By.xpath("//td[contains(text(),'Blazers(3-5)')]//following::a[1]")).click();
	    addCategoryPOM.MegatagTitle("BLZ 05");
	    addCategoryPOM.MegatagDescription("Uniform for students");;
	    addCategoryPOM.Save();
	    screenShot.captureScreenShot("UNF039_1");	 
 
	}
	  
	
	
}