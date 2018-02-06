package com.kayak.scripts;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.kayak.commonutility.ExcelUtils;
import com.kayak.commonutility.Utility;
import com.kayak.pages.KayakHomePage;
import com.kayak.pages.SearchResultPage;

@Listeners(com.kayak.commonutility.MyListener.class)

public class TestHomePage extends SuperScript{

	Logger logger=Logger.getLogger("TestHomePage");
	@Test
	public void testHome() throws Exception
	{
//		String s1="BOM";
//		String s2="BLR";
		
		ExcelUtils.setExcelFile(Utility.Path_testData+Utility.File_testData,"Sheet1");
		
		String sourceCityName=ExcelUtils.getCellData(1, 0);
		String destinationCityName=ExcelUtils.getCellData(1, 1);
		PropertyConfigurator.configure("Log4j.properties");
		KayakHomePage hp=new KayakHomePage(driver);
		
		hp.verifyHomepage();
		logger.info("===Homepage verified===");
		
		hp.clickOnOneWay();
		logger.info("===One way clicked===");
		hp.enterSourceCity(sourceCityName);
		logger.info("===Source enetered===");
		hp.enterDestinationCity(destinationCityName);
		logger.info("destination enetered");
		

		hp.selectDate("February 16");
		logger.info("====Required date has choosen===");

		hp.clickOnSearch();
		logger.info("===Search button clicked===");

		ExcelUtils.setCellData("Pass", 1, 2);
		Thread.sleep(2000);

		SearchResultPage srP=new SearchResultPage(driver);
		srP.verifySearch(sourceCityName,destinationCityName);
		logger.info("===Source & destination verified===");
		logger.info("Successed");

	}
	
	
}
