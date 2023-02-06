package com.hyr.extentreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasicReport {
	
	public static void main(String[] args)
	{
		ExtentReports extentreports = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		extentreports.attachReporter(spark);
		
		extentreports.createTest("Test1")
		.log(Status.PASS, "Test1 passed");
		
		extentreports.createTest("Test2")
		.log(Status.FAIL, "Test2 passed");
		
		
		extentreports.flush();
		
		try {
			Desktop.getDesktop().browse(new File("Spark.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
