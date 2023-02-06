package com.hyr.screenshot;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements ITestListener {
	
	public static WebDriver  driver;
	public static ExtentReports extentreport;
	public static ExtentSparkReporter sparkreporter;
	public static ExtentTest extenttest;
	@BeforeSuite
	public void initialiseextentreport()
	{
		extentreport = new ExtentReports();
		sparkreporter = new ExtentSparkReporter("alltests.html");
		extentreport.attachReporter(sparkreporter);
		
	}
	
	@AfterSuite
	public void generatereport()
	{
		extentreport.flush();
	}
	
	
	@BeforeTest
	public void setup(ITestContext test)
	{
		WebDriverManager.chromedriver().setup();
		
		  driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		extenttest= extentreport.createTest(test.getName());
		extenttest.info("URL opened");		
	}
	
	@AfterMethod
	public void checkstatus(ITestResult result,Method m) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			takeSnapShot(driver,"screen.jpg");
			extenttest.addScreenCaptureFromPath("screen.jpg");
			extenttest.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			extenttest.pass(m.getName()+" is passed");
		}
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
		
		
	}
	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On test success");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On test failed");
		System.out.println("Result name is "+result.getName());
		try {
			takeSnapShot(driver,"screenshot.jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	

}
