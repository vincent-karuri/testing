package com.example.selenium.webdriver.intro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntro {
	WebDriver driver;
	JavascriptExecutor jse;
	
	// set up driver for testing
	public void invokeBrowser () {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VonBass\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("http://www.edureka.co");
			searchCourse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// test category selection
	public void searchCourse () {
		driver.findElement(By.id("homeSearchBar")).sendKeys("Java");
		driver.findElement(By.id("homeSearchBarIcon")).click();
		jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 800)");
		
	
		WebElement element = driver.findElement(By.xpath("//label[contains(text(), 'Weekend')]"));
		
		try {
			// allow page load
			Thread.sleep(10000); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		element.click();
	}
	
	public static void main (String[] args) {
		
		SeleniumIntro sel = new SeleniumIntro();
		sel.invokeBrowser();
	}
}
