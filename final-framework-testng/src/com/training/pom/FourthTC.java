package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FourthTC {
private WebDriver driver; 
	
	public FourthTC(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='menu-posts']/a/div[2]")
	private WebElement Posts; 
	
	@FindBy(xpath="//*[@id='menu-posts']/ul/li[4]/a")
	private WebElement Categories; 
	
	@FindBy(id="tag-name")
	private WebElement Name;
	
	@FindBy(id="tag-slug")
	private WebElement Slug; 
	
	@FindBy(id="tag-description")
	private WebElement Description;
	
	@FindBy(id="submit")
	private WebElement addnewcategory; 
	
	@FindBy(xpath="//*[@class='page-title-action' and text()='Add New']")
	private WebElement AddNew; 
	
	@FindBy(name="post_title")
	private WebElement posttitle; 
	
	@FindBy(id="content")
	private WebElement content; 
	

	@FindBy(id="in-category-427")
	private WebElement checkBox; 
	
	@FindBy(id="in-category-430")
	private WebElement NewLaunchescheckBox; 

	@FindBy(id="publish")
	private WebElement Publish; 
	
	@FindBy(xpath="//*[@id='message']/p/a")
	private WebElement ViewPost; 
	
	
	@FindBy(xpath ="//*[@class='wpcf7-form-control wpcf7-submit']")
	private WebElement Send; 
	
	@FindBy(xpath="//*[@id='post-3595']/td[1]/strong/a")
	private WebElement OpenPost;
	
	public void Categories(){
		Actions mh = new Actions(driver);
		mh.moveToElement(Posts).build().perform();	
		this.Categories.click();
	}
	
	public void Name(String Name) {
		this.Name.clear(); 
		this.Name.sendKeys(Name); 
	}
	
	public void Slug(String Slug) {
		this.Slug.sendKeys(Slug);
	}
	public void Description(String Description) {
		this.Description.sendKeys(Description);
	}
	
	public void addnewcategory() {
		this.addnewcategory.click();
	}
	public void AllPosts(){
		Actions mh = new Actions(driver);
		mh.moveToElement(Posts).build().perform();
		driver.findElement(By.xpath("//*[@id='menu-posts']/ul/li[2]/a")).click();
	}
	
	public void AddNew() throws InterruptedException {
		this.AddNew.click();
		/*((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.AddNew);
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(this.AddNew));*/
	}
	public void posttitle(String AddNew){
		this.posttitle.sendKeys(AddNew);
	}
	
	public void content(String content){
		this.content.sendKeys(content);
	}
	
	public void checkBox(){
		this.checkBox.click();
	}
	
	public void NewLaunchescheckBox(){
		this.NewLaunchescheckBox.click();
	}
	
	public void Publish(){
		this.Publish.click();
	}
	
	public void ViewPost(){
		this.ViewPost.click();
	}
	
	public void openpost(){
		this.OpenPost.click();
	}
	
}
