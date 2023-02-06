package com.hyr.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHRMDataProviderExample {

	@Test(dataProvider = "logindata")
	public void login(String uname,String pwd) throws InterruptedException
	{
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	Thread.sleep(5000);
	
	driver.findElement(By.name("username")).sendKeys(uname);
	driver.findElement(By.name("password")).sendKeys(pwd);
	driver.findElement(By.xpath("//button[@type='submit']")).click();

	Thread.sleep(5000);
	WebElement element = driver.findElement(By.xpath("//*[text()='Dashboard']"));
	System.out.println(element.isDisplayed());
	System.out.println(element.getText());
	
	driver.quit();
	
	}
	
	@DataProvider()
	public Object[][] logindata()
	{
		Object[][] data = new Object[2][2];
		data[0][0]="Admin";
		data[0][1]="admin123";
		
		data[1][0]="Admin";
		data[1][1]="test123";
		
		return data;
	}
}
