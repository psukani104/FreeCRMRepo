
package com.crm.qa.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage lp; //class level initialize object
	HomePage hp;
	
	public LoginPageTest() throws IOException {
		super(); //1st call the constructor & to get the properties file 
	}
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		lp = new LoginPage(); //object
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = lp.validatePageTitle();
		Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void loginTest() throws IOException
	{
		hp = lp.login(p.getProperty("username"),p.getProperty("password")); //from properties file - username / password
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}