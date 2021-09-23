package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContacsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testdata.DataFile;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage lp; //class level initialize object
	HomePage hp;
	ContacsPage cp;
	TestUtil testUtil;
	DataFile d;
	
	public ContactsPageTest() throws IOException 
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		testUtil = new TestUtil();
		cp = new ContacsPage();
		lp = new LoginPage();
		d = new DataFile();
		hp = lp.login(p.getProperty("username"),p.getProperty("password") ); //from properties file - username / password
		testUtil.switchToFrame();
		
	}
	@Test(priority=1)
	public void verifyContactsPageTitleTest() throws IOException
	{
		cp = hp.clickOnContactsPage();
		Assert.assertTrue(cp.verifyContactPage(),"Contact label missing");
	}
	@Test(priority=2)
	public void selectContactsTest() throws IOException
	{
		cp = hp.clickOnContactsPage();
		cp.selectContact("Meet Tandel");
	}
	@Test(priority=3)
	public void selectMultipleContactsTest() throws IOException
	{
		cp = hp.clickOnContactsPage();
		cp.selectContact("Meet Tandel");
		cp.selectContact("PARTHKUMAR MUKESHKUMAR sukani");
	}
	
	@DataProvider
	public Object[][] testData()
	{
		Object[][] testdata = d.TestFileData();
		return testdata;
	}
	
	@Test(priority=4, dataProvider="testData")
	public void validateNewContact(String title, String firstname, String lastname, String company) throws IOException
	{
		hp.clickOnNewContacts();
		//cp.createNewContact("Dr.", "Bt", "Tandel", "google");	
		cp.createNewContact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}