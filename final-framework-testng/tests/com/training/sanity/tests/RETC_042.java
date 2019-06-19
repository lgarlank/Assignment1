package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.FourthTC;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_042 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private FourthTC FourthTC;
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
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		FourthTC = new FourthTC(driver);
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
	public void SeventhTestCaseExec() throws InterruptedException {
		loginPOM.clickLogin();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(10000);
		FourthTC.AllPosts();
		FourthTC.AddNew();
		Thread.sleep(6000);
		FourthTC.posttitle("New Launches");
		FourthTC.content(" New Launch in Home");
		FourthTC.NewLaunchescheckBox();
		FourthTC.Publish();
		Thread.sleep(10000);
		FourthTC.AllPosts();
		FourthTC.ViewPost();
		Thread.sleep(10000);
		screenShot.captureScreenShot("RETC_042_FinalScreenShot");
	}
}