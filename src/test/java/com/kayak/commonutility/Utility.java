package com.kayak.commonutility;

import java.util.concurrent.TimeUnit;

import com.kayak.scripts.SuperScript;

public class Utility 
{
	
	public static final String Path_testData="C:\\Users\\Subhasmita.Rout\\eclipse\\Kayak\\";
	public static final String File_testData="testdata.xlsx";
	
	public static String screenTitle;

	
	public void  waitToLoad()
	{
		SuperScript.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	

}
