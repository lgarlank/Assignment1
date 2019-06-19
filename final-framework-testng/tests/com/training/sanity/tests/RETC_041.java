package com.training.sanity.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.SixthTC;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_041 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private SixthTC SixthTC;
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
		SixthTC = new SixthTC(driver);
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
	public void SixthTestCaseExec() throws InterruptedException, AWTException {
		
		SixthTC.blog();
		SixthTC.readmore();
		SixthTC.comment("good");
		SixthTC.Name("Admin User");
		SixthTC.email("admin@test.com");
		SixthTC.Postcomment();
		Thread.sleep(10000);
		screenShot.captureScreenShot("RETC_041_AfterPostcomment");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		driver.get(baseUrl);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		loginPOM.clickLogin();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(6000);
		screenShot.captureScreenShot("RETC_041_Loginpage");
		SixthTC.viewcomments();
		Thread.sleep(10000);
		screenShot.captureScreenShot("RETC_041_FinalStep");
	}
}
