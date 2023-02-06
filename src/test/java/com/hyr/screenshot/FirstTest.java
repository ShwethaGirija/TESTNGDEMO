package com.hyr.screenshot;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(BaseTest.class)
public class FirstTest extends BaseTest{

	
	SoftAssert softassert = new SoftAssert();
	@Test
	public void TestGoogle()
	{
		
		
		driver.findElement(By.name("qa")).sendKeys("Shiva",Keys.ENTER);
		
		System.out.println("Title is "+driver.getTitle());
		
		
		softassert.assertEquals(driver.getTitle(), "Google Search","Title mismatched");
		
	//	driver.quit();
		
		//softassert.assertAll();
	}

}
