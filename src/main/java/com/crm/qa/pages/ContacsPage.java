package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContacsPage extends TestBase{

	public ContacsPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	public WebElement contactslabel;
	
	@FindBy(id = "first_name")
	public WebElement firstname;
	
	@FindBy(id = "surname")
	public WebElement surname;
	
	@FindBy(name = "client_lookup")
	public WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	public WebElement savebtn;
	
	
	public boolean verifyContactPage()
	{
		return contactslabel.isDisplayed();
	}
	
	public void selectContact(String name) 
	{
		//driver.findElement(By.xpath("//input[@name='contact_id']")).click();
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title, String f_name, String s_name, String cmpname)
	{
		Select s = new Select(driver.findElement(By.name("title")));
		s.selectByVisibleText(title);
		firstname.sendKeys(f_name);
		surname.sendKeys(s_name);
		company.sendKeys(cmpname);
		savebtn.click();
	}
}
	
