package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DbTC {
private WebDriver driver; 
	
	public DbTC(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='New Launch ']")
	private WebElement ApartmentTab; 
	
	@FindBy(xpath="//*[@id='wpmm-megamenu']//*[text()='Donec quis']")
	private WebElement DonecQs; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(name="your-name")
	private WebElement YourName; 
	
	@FindBy(name="your-email")
	private WebElement YourEmail;
	
	@FindBy(name="your-subject")
	private WebElement yoursubject; 
	
	@FindBy(name="your-message")
	private WebElement yourmessage; 
	
	@FindBy(xpath ="//*[@class='wpcf7-form-control wpcf7-submit']")
	private WebElement Send; 
	
	public void ApartmentTab(){
		Actions mh = new Actions(driver);
		mh.moveToElement(ApartmentTab).build().perform();	
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void DonecQs() {
		this.DonecQs.click(); 
	}
	public void YourName(String YourName) {
		this.YourName.sendKeys(YourName);
	}
	public void YourEmail(String YourEmail) {
		this.YourEmail.sendKeys(YourEmail);
	}
	
	public void yoursubject(String yoursubject) {
		this.yoursubject.sendKeys(yoursubject);
	}
	
	public void yourmessage(String yourmessage) {
		this.yourmessage.sendKeys(yourmessage);
	}
	
	public void Send() {
		this.Send.click();
	}
	
}
