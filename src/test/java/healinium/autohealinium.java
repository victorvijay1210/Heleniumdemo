package healinium;
import static org.testng.Assert.assertTrue;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.epam.healenium.SelfHealingDriver;


public class autohealinium {

	WebDriver driver;
	
	@Test
	public void chrometest() throws Exception {
		
		WebDriver delegate = new ChromeDriver();
		driver=	SelfHealingDriver.create(delegate);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		assertTrue(driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).isDisplayed());
		driver.quit();
	
	}

}
