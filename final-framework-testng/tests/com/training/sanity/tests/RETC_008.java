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
import com.training.pom.FirstTC;
import com.training.pom.SecondTC;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_008 {
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
	public void SecondTestCse() throws InterruptedException {
		FirstTC.ApartmentTab();
		FirstTC.DonecQs();
		SecondTC.amount("400000");
		SecondTC.downpayment("20000");
		SecondTC.loanTerm("20");
		SecondTC.interestrate("7.25");
		SecondTC.Calculate();
		Thread.sleep(2000);
		screenShot.captureScreenShot("SecondTC");
	}
}