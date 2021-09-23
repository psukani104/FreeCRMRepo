package com.crm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public TestUtil() throws IOException {
	}
	public static long IMPLICIT_WAIT= 10;
	public static long PAGE_LOAD_TIMEOUT= 20;
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}	
	
	public void screenShot() throws IOException 
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile, new File("D:/Selenium_Class/testing/screenshot.png"));
	}
}