package com.crm.qa.testcases;
//to import ctrl+shift+O
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContacsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase
{
	LoginPage lp; //class level initialize object
	HomePage hp;
	ContacsPage cp;
	DealsPage dp;
	TasksPage tp;
	TestUtil testUtil;
	public HomePageTest() throws IOException 
	{
		super();
	}
	//test cases should be separated -- independent with each other
	//before each test case --  launch the  browser and login
	//@test - execute testcase
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		testUtil = new TestUtil();
		cp = new ContacsPage();
		dp = new DealsPage();
		tp = new TasksPage();
		lp = new LoginPage();
		
		hp = lp.login(p.getProperty("username"),p.getProperty("password") ); //from properties file - username / password
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = hp.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page title did not match");
	}
	@Test(priority=2)
	public void verifyCorrectUserName()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(hp.verifyUserName());
	}
	@Test(priority=3)
	public void verifyContactsLinkTest() throws IOException
	{
		testUtil.switchToFrame();
		cp = hp.clickOnContactsPage();
	}
	@Test(priority=4)
	public void verifyDealsLinkTest() throws IOException
	{
		testUtil.switchToFrame();
		dp = hp.clickOnDealsPage();
	}
	@Test(priority=5)
	public void verifyTasksLinkTest() throws IOException
	{
		testUtil.switchToFrame();
		tp = hp.clickOnTasksPage();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
