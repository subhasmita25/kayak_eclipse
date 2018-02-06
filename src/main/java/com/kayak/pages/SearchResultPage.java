package com.kayak.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.kayak.commonutility.Utility;


public class SearchResultPage extends Utility {

	WebDriver driver;
	@FindBy(xpath="//div[@class=\"col-field time depart\"]/div[@class=\"bottom\"]")
	private List<WebElement> sourceName;
	
	@FindBy(xpath="//div[@class=\"col-field time return\"]/div[@class=\"bottom\"]")
	private List<WebElement> destinationName;
	
	@FindBy(xpath="//div[@id='pIgV-dialog-close']")
	private WebElement closeButton;
	
	public SearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void closePopUp()
	{
		
		try {
			
			if(closeButton.isEnabled() && closeButton.isDisplayed())
			{
				closeButton.click();
				System.out.println("Pop up closed");
			}
			else
			{
				System.out.println("pop up has not appeared");
			}
			
		}
		catch(Exception e)
		{
			
		}
		System.out.println("pop up method called");
	}
	
	public void verifySearch(String s1,String s2)
	{
		waitToLoad();
		closePopUp();

		for(int i=1;i<=2;i++)
		{
			
			waitToLoad();
			Assert.assertEquals(s1, sourceName.get(i).getText());
			System.out.println("Source"+i+" matched");
			
			Assert.assertEquals(s2, destinationName.get(i).getText());
			System.out.println("destination"+i+" matched");
			

		}
		
		

	}
}
