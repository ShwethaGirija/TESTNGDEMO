package com.hyr.tests;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.Test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	ExtentReports extentreports;
	ExtentTest extenttest;
	WebDriver  driver;
	@BeforeSuite
	public void initializereport()
	{
		 extentreports = new ExtentReports();
		ExtentSparkReporter sparkreport = new ExtentSparkReporter("test.html");
		
		extentreports.attachReporter(sparkreport);
	}
	
	@AfterSuite
	public void teardown() throws IOException
	{
		extentreports.flush();
		Desktop.getDesktop().browse(new File("test.html").toURI());
		
	}
	
	@BeforeTest
	public void addTestInfo(ITestContext context)
	{
		extenttest = extentreports.createTest(context.getName());
	}
	
	@AfterMethod
	public void logtestStatus(ITestResult result,Method m) throws Exception
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			extenttest.pass("Test "+m.getName()+" is passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			//extenttest.fail("Test is failed");
			String fname = result.getMethod()+"SCREENSHOT1.jpg";
			takeSnapShot(driver,fname);
			extenttest.addScreenCaptureFromPath(fname);
			extenttest.log(Status.FAIL, result.getThrowable());
		}
		
		
	}
	 public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(fileWithPath);

	                //Copy file at destination

	                FileUtils.copyFile(SrcFile, DestFile);

	    }
		
	
	SoftAssert softassert = new SoftAssert();
	@Test
	public void TestGoogle()
	{
		WebDriverManager.chromedriver().setup();
		
		  driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Shiva",Keys.ENTER);
		
		System.out.println("Title is "+driver.getTitle());
		
		
		softassert.assertEquals(driver.getTitle(), "Google Search","Title mismatched");
		
		driver.quit();
		
		//softassert.assertAll();
	}
	
	@Test
	public void TestGoogleNew()
	{
		WebDriverManager.chromedriver().setup();
		
		  driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("qa")).sendKeys("Shiva",Keys.ENTER);
		
		System.out.println("Title is "+driver.getTitle());
		
		
		softassert.assertEquals(driver.getTitle(), "Google Search","Title mismatched");
		
		driver.quit();
		
		//softassert.assertAll();
	}


}
