package com.kayak.commonutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell cell;
	private static XSSFRow row;
	
	
	public static void setExcelFile(String path,String sheetName)
	{
		try {
			FileInputStream fis =new FileInputStream(path);
			excelWBook=new XSSFWorkbook(fis);
			excelWSheet=excelWBook.getSheet(sheetName);
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static String getCellData(int rowNum,int colNum)
	{
		try
		{
		cell=excelWSheet.getRow(rowNum).getCell(colNum);
		String cellData=cell.getStringCellValue();
		return cellData;
		}
		catch(Exception e)
		{
			return "";

		}
		
	}
	
	public static void setCellData(String result,int r,int c) throws Exception
	{
		row=excelWSheet.getRow(r);
		cell=row.getCell(c);
		
		if(cell==null)
		{
			cell=row.createCell(c);
			cell.setCellValue(result);
		}
		else
		{
			cell.setCellValue(result);
		}
		
		FileOutputStream fos=new FileOutputStream(Utility.Path_testData+Utility.File_testData);
		excelWBook.write(fos);
		fos.close();
		fos.flush();
	}

}
