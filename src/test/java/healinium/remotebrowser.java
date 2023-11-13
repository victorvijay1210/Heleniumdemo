package healinium;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.epam.healenium.SelfHealingDriver;

public class remotebrowser {
	WebDriver driver;
	
	
	@Test
	public void dockertest() throws Exception {
		URL dockerUrl = new URL("http://localhost:4444/wd/hub");
	     ChromeOptions options = new ChromeOptions(); 
	     RemoteWebDriver delegate = new RemoteWebDriver(dockerUrl, options);       
		driver=	SelfHealingDriver.create(delegate);
		driver.get("https://www.saucedemo.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		assertTrue(driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).isDisplayed());
		driver.quit();
	}
	 

}
