package com.qualitystream.tutorial;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.Thread;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class GoogleSearchTest {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void testGooglePage() throws InterruptedException /*throws InterruptedException*/ {
		
		WebElement searchbox = driver.findElement(By.name("q"));
				
		searchbox.clear();
		
		searchbox.sendKeys("quality-stream Introducci�n a la Automatizaci�n de Pruebas de Software");
		
		searchbox.submit();
		
		//Explicit wait(Y)
		sleep(2000);
		
		/*WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
		ewait.until(ExpectedConditions.titleContains("quality-stream"));*/
		
		//FluentWait
		
		/*Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);*/
		
	}
	
	@After
	public void tearDown( ) {
		driver.quit();
		
	}
}
