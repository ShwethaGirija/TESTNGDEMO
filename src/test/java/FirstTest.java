import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	@Test
	public void TestGoogle()
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver  driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.id("input")).sendKeys("Shiva",Keys.ENTER);
		
		System.out.println("Title is "+driver.getTitle());
		
		
	}

}
