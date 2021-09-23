package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//WE CANNOT use WebElement like this. we have to use @FindBy(PageFactory - Object Repo:)
		//to avoid NullPointerException we use page factory
		//public WebElement username = driver.findElement(By.name("email"));
	
		@FindBy(name = "username")
		public WebElement username;
		
		@FindBy(name = "password")
		public WebElement password;
		
		//@FindBy(xpath= "//div[@class='ui fluid large blue submit button']")
	    @FindBy(xpath= "//input[@value='Login']")
	    public WebElement login;
	    
	    @FindBy(linkText= "Sign Up")
	    public WebElement signup;
	    
	    //Initialize the page object
	    public LoginPage() throws IOException {
			
			PageFactory.initElements(driver, this);
		}
	    
	    //Actions
	    public String validatePageTitle()
	    {
	    	return driver.getTitle();
	    }
	    
	    public HomePage login(String user, String pwd) throws IOException //not same as webelement name
	    {
	    	username.sendKeys(user);
	    	password.sendKeys(pwd);
	    	login.click();
	    	
	    	return new HomePage();
	    }

}
