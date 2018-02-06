package com.kayak.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.kayak.commonutility.Utility;


public class KayakHomePage {
	
	WebDriver driver;
	Utility utils=new Utility();

	@FindBy(xpath="(//label[@title=\"One-way\"])[1]")
	private WebElement oneWay;
	
	@FindBy(xpath="(//input[@name=\"origin\"])[1]")
	private WebElement source;
	
	@FindBy(xpath="(//input[@name=\"destination\"])[1]")
	private WebElement destination;
	
	@FindBy(xpath="//div[@aria-label=\"Departure date input\"]")
	private WebElement datePicker;
	
	
	@FindBy(xpath="(//button[@title=\"Search\"])[2]")
	private WebElement searchBtn;
	
	
	
	public KayakHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void verifyHomepage()
	{
		utils.waitToLoad();

		String expectedTitle="Search Flights, Hotels & Rental Cars | KAYAK";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	public void clickOnOneWay()
	{
		utils.waitToLoad();

		oneWay.click();
		
	}
	
	
	public void enterSourceCity(String src) 
	{
		utils.waitToLoad();

		//source.click();
		source.clear();
		source.sendKeys(src);
		utils.waitToLoad();
	}
	public void enterDestinationCity(String dest) throws Exception
	{
		utils.waitToLoad();
		//destination.click();
		destination.clear();
		
		
		destination.sendKeys(dest);
		//utils.waitToLoad();
		Thread.sleep(2000);

	}
	
	
	public void selectDate(String dateValue)
	{
		utils.waitToLoad();

		datePicker.click();
		driver.findElement(By.xpath("//div[@aria-label='"+dateValue+"']")).click();
	}
	
	
	public void clickOnSearch()
	{
		utils.waitToLoad();

		searchBtn.click();
	}
	


	
}
