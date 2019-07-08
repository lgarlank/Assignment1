package com.training.regression.tests;

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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_069 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private FirstTC FirstTC;
	private SecondTC SecondTC;
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
		SecondTC = new SecondTC(driver); 
		FirstTC = new FirstTC(driver); 
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
	public void RETC069() throws InterruptedException {
		FirstTC.ApartmentTab();
		Thread.sleep(5000);
		FirstTC.DonecQs();
		Thread.sleep(5000);
		SecondTC.amount("400000");
		Thread.sleep(5000);
		SecondTC.downpayment("XYZ");
		SecondTC.loanTerm("20");
		Thread.sleep(5000);
		SecondTC.interestrate("7.25");
		SecondTC.Calculate();
		Thread.sleep(2000);
		screenShot.captureScreenShot("RETC069");
	}
}