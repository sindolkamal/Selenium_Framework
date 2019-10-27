package com.training.sanity.tests;

import static org.testng.AssertJUnit.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangePassPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class PasswordMismatchUFM_007 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ChangePassPOM changepassPOM;
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
		changepassPOM=new ChangePassPOM(driver);
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
		
		WebElement register=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
		register.click();
		//Actions Reg=new Actions(driver);
		//Reg.moveToElement(register).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		
		Thread.sleep(3000);
		loginPOM.sendUserName("sindolkamal@gmail.com");
		loginPOM.sendPassword("Kamal136");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		screenShot.captureScreenShot("Login1");
		
		changepassPOM.ChangePasswordClick();
		changepassPOM.sendpassword("sneha");
		changepassPOM.sendconfPassword("mneha");
		changepassPOM.clickContBtn();
		Thread.sleep(3000);
		System.out.println(changepassPOM.getText());
		assertEquals("Password confirmation does not match password!",changepassPOM.getText());
	}
}
