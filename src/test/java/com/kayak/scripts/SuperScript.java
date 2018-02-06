package com.kayak.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class SuperScript {
	static
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Subhasmita.Rout\\eclipse\\Kayak\\server\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Subhasmita.Rout\\eclipse\\Kayak\\server\\chromedriver.exe");
		
	}
	public static WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void preCondition(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.get("https://www.kayak.co.in/");
		driver.manage().window().maximize();
	}
	@AfterClass
	public void postCondition()
	{
		driver.quit();
	}

}
