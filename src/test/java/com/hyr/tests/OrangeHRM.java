package com.hyr.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	
	@BeforeTest
	public void initialise()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	@Parameters("url")
	@Test
	public void LaunchApp(@Optional("https://opensource-demo.orangehrmlive.com/") String url) throws InterruptedException {
		
		driver.get(url);
		Thread.sleep(5000);
	}
	
	@Parameters({"uname","pwd"})
	@Test
	public void EnterLoginDetails(String uname,String pwd) {
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test
	public void NavigateToMyInfo() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='My Info']/parent::a")).click();
	}
	
	@Test
	public void VerifyMyInfo() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//*[text()='Dashboard']")).isDisplayed());
		
	}
	
	@Test
	public void VerifyLogin() throws InterruptedException {
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//*[text()='Dashboard']"));
		System.out.println(element.isDisplayed());
		System.out.println(element.getText());
		
	}
}