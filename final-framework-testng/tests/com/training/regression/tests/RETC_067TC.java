package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.RealestateDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.DbTC;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_067TC {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private DbTC DbTC;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		DbTC = new DbTC(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = RealestateDataProviders.class)
	public void RETC067TC(String name, String email,String subject, String message) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
				
		DbTC.ApartmentTab();
		Thread.sleep(5000);
		DbTC.DonecQs();
		Thread.sleep(5000);
		DbTC.YourName(name);
		DbTC.YourEmail(email);
		DbTC.yoursubject(subject);
		DbTC.yourmessage(message);
		DbTC.Send();
		Thread.sleep(5000);
		screenShot.captureScreenShot(name);

	}

}