package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SixthTC {
private WebDriver driver; 
	
	public SixthTC(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='menu-item-617']/a")
	private WebElement Blog; 
	
	@FindBy(xpath="//*[@id='post-3595']/div/a")
	private WebElement ReadMore; 
	
	@FindBy(xpath="//*[@id='comment']")
	private WebElement Comment; 
	
	@FindBy(id="author")
	private WebElement Name;
	
	@FindBy(id="email")
	private WebElement Email;
	
	@FindBy(id="submit")
	private WebElement Postcomment;
	
	@FindBy(xpath="//*[@id='menu-comments']/a/div[3]")
	private WebElement ViewComments;
	
	public void blog(){
		this.Blog.click();
	}
	
	public void readmore(){
		this.ReadMore.click();
	}
	public void Name(String Name) {
		this.Name.clear(); 
		this.Name.sendKeys(Name); 
	}
	
	public void email(String email) {
		this.Email.clear(); 
		this.Email.sendKeys(email); 
	}
	
	public void comment(String Comment) {
		this.Comment.clear(); 
		this.Comment.sendKeys(Comment); 
	}
	
	public void Postcomment() {
		this.Postcomment.click();
	}
	
	public void viewcomments(){
		this.ViewComments.click();
	}
	

}
