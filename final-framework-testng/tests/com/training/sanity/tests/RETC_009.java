package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.FirstTC;
import com.training.pom.LoginPOM;
import com.training.pom.SecondTC;
import com.training.pom.ThirdTC;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_009 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private FirstTC FirstTC;
	private SecondTC SecondTC;
	private ThirdTC ThirdTC;
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
		ThirdTC = new ThirdTC(driver); 
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
	public void ThirdTestcase() throws AWTException, InterruptedException {
		ThirdTC.ApartmentTab();
		ThirdTC.address("Electronic City");
		ThirdTC.propertytype();
		ThirdTC.taxregion();
		ThirdTC.Search();
		screenShot.captureScreenShot("ThirdTc");
	}
}